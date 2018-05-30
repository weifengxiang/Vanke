package org.sky.miniapp.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.sky.base.client.BaseAccountDetailMapper;
import org.sky.base.client.BaseAccountMapper;
import org.sky.base.client.BaseBankCardMapper;
import org.sky.base.client.BaseChannelImgMapper;
import org.sky.base.client.BaseChannelMapper;
import org.sky.base.client.BaseCustomerMapper;
import org.sky.base.client.BaseMsgMapper;
import org.sky.base.client.BaseParttimeJobEnrollMapper;
import org.sky.base.client.BasePhoneVerificationMapper;
import org.sky.base.client.BaseWithdrawCashMapper;
import org.sky.base.model.BaseAccount;
import org.sky.base.model.BaseAccountDetail;
import org.sky.base.model.BaseAccountDetailExample;
import org.sky.base.model.BaseAccountExample;
import org.sky.base.model.BaseBankCard;
import org.sky.base.model.BaseBankCardExample;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.base.model.BaseChannelImgExample;
import org.sky.base.model.BaseChannelImgWithBLOBs;
import org.sky.base.model.BaseCustomer;
import org.sky.base.model.BaseCustomerExample;
import org.sky.base.model.BaseMsg;
import org.sky.base.model.BaseMsgExample;
import org.sky.base.model.BaseParttimeJobEnroll;
import org.sky.base.model.BaseParttimeJobEnrollExample;
import org.sky.base.model.BasePhoneVerification;
import org.sky.base.model.BasePhoneVerificationExample;
import org.sky.base.model.BaseWithdrawCash;
import org.sky.base.model.BaseWithdrawCashExample;
import org.sky.base.service.BaseCodeService;
import org.sky.land.client.LandParttimeJobMapper;
import org.sky.land.model.LandParttimeJob;
import org.sky.land.model.LandParttimeJobExample;
import org.sky.miniapp.utils.MiniAppUtils;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.client.SysDictItemMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.utils.AliyunSmsUtils;
import org.sky.sys.utils.ApplicationCached;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.MD5Utils;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aliyuncs.exceptions.ClientException;

@Service
public class MiniAppService {
	private Logger logger = Logger.getLogger(MiniAppService.class);
	@Autowired
	private BaseChannelMapper baseChannelMapper;
	@Autowired
	private BaseCustomerMapper baseCustomerMapper;
	@Autowired
	private BaseChannelImgMapper imgMapper;
	@Autowired
	private BasePhoneVerificationMapper phoneVerMapper;
	@Autowired
	private SysCommonMapper comMapper;
	@Autowired
	private BaseCodeService bcService;
	@Autowired
	private BaseBankCardMapper bbcMapper;
	@Autowired
	private BaseAccountMapper bacMapper;
	@Autowired
	private BaseWithdrawCashMapper bwcMapper;
	@Autowired
	private BaseAccountDetailMapper badMapper;
	@Autowired
	private LandParttimeJobMapper lpjMapper;
	@Autowired
	private BaseParttimeJobEnrollMapper bptjMapper;
	@Autowired
	private BaseMsgMapper bMsgMapper;
	/**
	 * 根据电话号码获取渠道信息
	 * @param tel
	 * @return
	 */
	public BaseChannel getBaseChannelByTel(String tel) {
		BaseChannelExample example = new BaseChannelExample();
		example.createCriteria().andTelEqualTo(tel);
		List<BaseChannel> list = baseChannelMapper.selectByExample(example);
		if(null!=list&&list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * 根据渠道编号获取渠道信息
	 * @param code
	 * @return
	 */
	public BaseChannel getBaseChannelByCode(String code) {
		BaseChannelExample example = new BaseChannelExample();
		example.createCriteria().andCodeEqualTo(code);
		List<BaseChannel> list = baseChannelMapper.selectByExample(example);
		if(null!=list&&list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * 渠道登录
	 * @param tel
	 * @param password
	 */
	public BaseChannel login(String tel,String password) throws ServiceException{
		BaseChannelExample example = new BaseChannelExample();
		example.createCriteria().andTelEqualTo(tel);
		List<BaseChannel> list = baseChannelMapper.selectByExample(example);
		if(null==list||list.size()<1){
			logger.error("电话号码不存在"+tel);
			throw new ServiceException("电话号码不存在");
		}else {
			BaseChannel bc =list.get(0);
			if(!bc.getPassword().equals(MD5Utils.MD5LOWER(password))) {
				throw new ServiceException("密码不正确");
			}else {
				return bc;
			}
		}
	}
	/**
	 * 渠道注册
	 * @param tel
	 * @param password
	 * @param verCode
	 */
	public BaseChannel register(String tel,String password,String verCode,String recCode) throws ServiceException {
		BaseChannel bc = null;
		BaseChannelExample example = new BaseChannelExample();
		example.createCriteria().andTelEqualTo(tel);
		List<BaseChannel> channelList = baseChannelMapper.selectByExample(example);
		if(channelList.size()>0) {
			throw new ServiceException("该电话号码已经注册过,请登录");
		}
		BasePhoneVerificationExample e = new BasePhoneVerificationExample();
		e.createCriteria().andPhoneNumEqualTo(tel);
		List<BasePhoneVerification> list = phoneVerMapper.selectByExample(e);
		if(list.size()==0 || list.isEmpty()) {
			throw new ServiceException("电话号码不正确");
		}else {
			BasePhoneVerification vf = list.get(0);
			if(vf.getValidityTime().before(CommonUtils.getCurrentDbDate())){
				throw new ServiceException("验证码超期,请重新获取");
			}else if(!vf.getVerificationCode().equals(verCode)) {
				throw new ServiceException("验证码输入不正确,请重新输入");
			}else {
				bc = new BaseChannel();
				bc.setId(CommonUtils.getUUID(32));
				bc.setCode(bcService.getNextBizCode("CHA"));
				bc.setTel(tel);
				bc.setPassword(MD5Utils.MD5LOWER(password));
				bc.setChannelCode(recCode);
				bc.setState("01");//已注册状态
				bc.setCreateTime(CommonUtils.getCurrentDbDate());
				bc.setUpdateTime(CommonUtils.getCurrentDbDate());
				baseChannelMapper.insertSelective(bc);
				//使用完验证码后删掉
				phoneVerMapper.deleteByExample(e);
			}
		}
		return bc;
	}
	/**
	 * 推荐客户
	 * @param customer
	 * @param channelCode
	 */
	public void recommendCustomer(String customer,String channelCode) throws ServiceException{
		if(StringUtils.isNull(customer)) {
			logger.error("客户信息不能为空"+customer);
			throw new ServiceException("客户信息不能为空");
		}
		BaseCustomer bc = JsonUtils.json2pojo(customer, BaseCustomer.class);
		if(null==bc) {
			logger.error("客户信息参数错误"+customer);
			throw new ServiceException("客户信息参数错误"+customer);
		}
		Timestamp ts = comMapper.queryTimestamp();
		bc.setId(CommonUtils.getUUID(32));
		bc.setCode(bcService.getNextBizCode("CUS"));
		bc.setCreater(channelCode);
		bc.setCreateTime(ts);
		bc.setUpdater(channelCode);
		bc.setUpdateTime(ts);
		bc.setChannelCode(channelCode);
		baseCustomerMapper.insert(bc);
	}
	/**
	 * 查询我的推荐（客户/渠道）信息
	 * @param type
	 * @param channelCode
	 * @return
	 */
	public List myRecommend(String type,String channelCode) {
		List list = null;
		if("customer".equals(type)) {
			BaseCustomerExample e = new BaseCustomerExample();
			e.createCriteria().andChannelCodeEqualTo(channelCode);
			e.setOrderByClause("CREATE_TIME DESC");
			list=baseCustomerMapper.selectByExample(e);
		}else if("channel".equals(type)) {
			BaseChannelExample e = new BaseChannelExample();
			e.createCriteria().andChannelCodeEqualTo(channelCode);
			e.setOrderByClause("CREATE_TIME DESC");
			list=baseChannelMapper.selectByExample(e);
		}
		return list;
	}
	/**
	 * 实名认证
	 * @param channel
	 * @param channelCode
	 */
	public void realNameAuthentication(String channel,String channelCode) throws ServiceException{
		if(StringUtils.isNull(channel)) {
			logger.error("认证信息不能为空"+channel);
			throw new ServiceException("认证信息不能为空");
		}
		try {
			BaseChannelExample e = new BaseChannelExample();
			e.createCriteria().andCodeEqualTo(channelCode);
			//校验用户状态
			List<BaseChannel> list = baseChannelMapper.selectByExample(e);
			if(null==list||list.size()!=1){
				logger.error("认证用户不存在"+channel);
				throw new ServiceException("认证用户不存在");
			}
			if(!"01".equals(list.get(0).getState())&&!"04".equals(list.get(0).getState())){
				logger.error("用户已认证或在审核中"+channel);
				throw new ServiceException("用户已认证或在审核中");
			}
			BaseChannel bc = JsonUtils.json2pojo(channel, BaseChannel.class);
			bc.setState("05");//设置状态为等待认证
			baseChannelMapper.updateByExampleSelective(bc, e);
			Map params = JsonUtils.json2map(channel);
			BaseChannelImgWithBLOBs bci = new BaseChannelImgWithBLOBs();
			Timestamp ts = comMapper.queryTimestamp();
			bci.setId(CommonUtils.getUUID(32));
			bci.setChannelCode(channelCode);
			bci.setCreater(channelCode);
			bci.setCreateTime(ts);
			bci.setUpdater(channelCode);
			bci.setUpdateTime(ts);
			bci.setIdcardPic1((String)params.get("idcardPic1"));
			bci.setIdcardPic2((String)params.get("idcardPic2"));
			bci.setStudPic1((String)params.get("studPic1"));
			bci.setStudPic2((String)params.get("studPic2"));
			//先删除之前上传的图像
			BaseChannelImgExample bcimge = new BaseChannelImgExample();
			bcimge.createCriteria().andChannelCodeEqualTo(channelCode);
			imgMapper.deleteByExample(bcimge);
			imgMapper.insertSelective(bci);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * 基础资料保存
	 * @param channel
	 * @param channelCode
	 */
	public void saveBaseChannel(String channel,String channelCode) {
		try {
			BaseChannel bc = JsonUtils.json2pojo(channel, BaseChannel.class);
			BaseChannelExample e = new BaseChannelExample();
			e.createCriteria().andCodeEqualTo(channelCode);
			baseChannelMapper.updateByExampleSelective(bc, e);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * 基础资料查询
	 * @param channelCode
	 * @return
	 */
	public BaseChannel getBaseChannel(String channelCode) {
		try {
			BaseChannelExample e = new BaseChannelExample();
			e.createCriteria().andCodeEqualTo(channelCode);
			List<BaseChannel> list = baseChannelMapper.selectByExample(e);
			if(list.size()>0) {
				return list.get(0);
			}else {
				return null;
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * 更新新密码
	 * @param tel
	 * @param newPassword
	 * @param verCode
	 */
	public void updatePassword(String tel,String newPassword,String verCode) throws ServiceException{
		BasePhoneVerificationExample e = new BasePhoneVerificationExample();
		e.createCriteria().andPhoneNumEqualTo(tel);
		List<BasePhoneVerification> list = phoneVerMapper.selectByExample(e);
		if(list.size()==0 || list.isEmpty()) {
			throw new ServiceException("电话号码不正确");
		}else {
			BasePhoneVerification vf = list.get(0);
			if(vf.getValidityTime().before(CommonUtils.getCurrentDbDate())){
				//删除验证码
				phoneVerMapper.deleteByExample(e);
				throw new ServiceException("验证码超期,请重新获取");
			}else if(!vf.getVerificationCode().equals(verCode)) {
				throw new ServiceException("验证码输入不正确,请重新输入");
			}else {
				try {
					BaseChannel bc = new BaseChannel();
					bc.setPassword(MD5Utils.MD5LOWER(newPassword));		
					bc.setUpdateTime(CommonUtils.getCurrentDbDate());
					BaseChannelExample bce = new BaseChannelExample();
					bce.createCriteria().andTelEqualTo(tel);
					baseChannelMapper.updateByExampleSelective(bc,bce);
					//使用完验证码后删掉
					phoneVerMapper.deleteByExample(e);
				}catch(Exception ex) {
					logger.error(ex.getMessage());
					throw new ServiceException(ex.getMessage());
				}
			}
		}
	}
	/**
	 * 查询字典信息
	 * @param itemType
	 * @return
	 */
	public List getItem(String itemType) {
		return ApplicationCached.getDictItemByDicType(itemType);
	}
	/**
	 * 获取短信验证码
	 * @param tel
	 */
	public void obtainSms(String tel) throws ServiceException{
		//
		String verCode="888888";
		//发送信息...
		try {
			if("true".equals(ConfUtils.getValue("SendSms"))) {
				verCode=MiniAppUtils.getVerficationCode();
				AliyunSmsUtils.sendSms(tel, verCode);
			}
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new ServiceException("消息发送失败"+e1.getMessage());
		}	
		BasePhoneVerification pv = new BasePhoneVerification();
		pv.setCreateTime(CommonUtils.getCurrentDbDate());
		pv.setPhoneNum(tel);
		pv.setRecid(CommonUtils.getUUID(32));
		long curren = System.currentTimeMillis();
        curren += 30 * 60 * 1000;
        Timestamp validityTime = new Timestamp(curren);;
		pv.setValidityTime(validityTime);//有效期半小时
		pv.setVerificationCode(verCode);
		//先删除
		BasePhoneVerificationExample e = new BasePhoneVerificationExample();
		e.createCriteria().andPhoneNumEqualTo(tel);
		phoneVerMapper.deleteByExample(e);
		phoneVerMapper.insert(pv);
	}
	/**
	 * 渠道图像查询
	 * @param channelCode
	 * @return
	 */
	public BaseChannelImgWithBLOBs getBaseChannelImgByCode(String channelCode) {
		BaseChannelImgExample e = new BaseChannelImgExample();
		e.createCriteria().andChannelCodeEqualTo(channelCode);
		List<BaseChannelImgWithBLOBs> list = imgMapper.selectByExampleWithBLOBs(e);
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * 绑定银行卡
	 * @param channelCode
	 * @param bbc
	 * @throws ServiceException
	 */
	public void saveAddBaseBankCard(String channelCode,BaseBankCard bbc) throws ServiceException{
		BaseBankCardExample bbce = new BaseBankCardExample();
		bbce.createCriteria().andCardCodeEqualTo(bbc.getCardCode()).andBankCodeEqualTo(bbc.getBankCode());
		long count = bbcMapper.countByExample(bbce);
		if(count>0) {
			logger.error("渠道编号"+channelCode+"银行编号"+bbc.getBankCode()+"卡号"+bbc.getCardCode()+"银行卡已经绑定");
			throw new ServiceException("银行卡已经绑定");
		}
		Timestamp ts = CommonUtils.getCurrentDbTimestamp();
		bbc.setId(CommonUtils.getUUID(32));
		bbc.setBindingDate(ts);
		bbc.setChaCode(channelCode);
		bbc.setCreater(channelCode);
		bbc.setCreateTime(ts);
		bbc.setUpdater(channelCode);
		bbc.setUpdateTime(ts);
		bbcMapper.insertSelective(bbc);
	}
	/**
	 * 查询绑定的银行卡
	 * @param channelCode
	 * @return
	 */
	public List<BaseBankCard> selectBaseBankCard(String channelCode){
		BaseBankCardExample bbce = new BaseBankCardExample();
		bbce.createCriteria().andChaCodeEqualTo(channelCode);
		List<BaseBankCard> list = bbcMapper.selectByExample(bbce);
		return list;
	}
	/**
	 * 账户信息查询
	 * @param channelCode
	 * @return
	 */
	public BaseAccount getBaseAccount(String channelCode) throws ServiceException{
		BaseAccountExample bae = new BaseAccountExample();
		bae.createCriteria().andChaCodeEqualTo(channelCode);
		List<BaseAccount> list = bacMapper.selectByExample(bae);
		if(null==list || list.isEmpty()) {
			throw new ServiceException("未查询到任何账户");
		}
		return list.get(0);
	}
	/**
	 * 提现申请
	 * @param channelCode
	 * @param bwc
	 */
	public void saveAddBaseWithDrawCash(String channelCode,BaseWithdrawCash bwc) {
		Timestamp ts = CommonUtils.getCurrentDbTimestamp();
		bwc.setId(CommonUtils.getUUID(32));
		bwc.setChaCode(channelCode);
		bwc.setCreater(channelCode);
		bwc.setCreateTime(ts);
		bwc.setReqDate(ts);
		bwc.setState("0");
		bwc.setUpdater(channelCode);
		bwc.setUpdateTime(ts);
		bwcMapper.insertSelective(bwc);
	}
	/**
	 * 提现进度查询
	 * @param channelCode
	 * @return
	 */
	public List<BaseWithdrawCash> selectBaseWithDrawCashProcess(String channelCode) {
		BaseWithdrawCashExample bwce = new BaseWithdrawCashExample();
		bwce.createCriteria().andChaCodeEqualTo(channelCode);
		return bwcMapper.selectByExample(bwce);
	}
	/**
	 * 交易明细查询
	 * @param channelCode
	 * @return
	 */
	public List<BaseAccountDetail> selectBaseAccountDetail(String channelCode) {
		BaseAccountDetailExample bade = new BaseAccountDetailExample();
		bade.createCriteria();
		Map filter = new HashMap();
		filter.put("exists(select 1 from base_account ba where ba.code = account_code and lower(ba.cha_code)='"+channelCode.toLowerCase()+"') and 1@=","1");
		bade.integratedQuery(filter);
		return badMapper.selectByExample(bade);
	}
	/**
	 * 兼职任务查询
	 * @return
	 */
	public List<LandParttimeJob> selectLandParttimeJob(){
		LandParttimeJobExample lpje = new LandParttimeJobExample();
		return lpjMapper.selectByExample(lpje);
	}
	/**
	 * 兼职任务明细
	 * @param code
	 * @return
	 */
	public LandParttimeJob getLandParttimeJobDetail(String code) throws ServiceException{
		LandParttimeJobExample lpje = new LandParttimeJobExample();
		lpje.createCriteria().andCodeEqualTo(code);
		List<LandParttimeJob> list = lpjMapper.selectByExample(lpje);
		if(null==list || list.isEmpty()) {
			throw new ServiceException("未查询到任何账户");
		}
		return list.get(0);
	}
	/**
	 * 兼职报名
	 * @param channelCode
	 * @param bpe
	 */
	public void saveAddBaseParttimeJobEnroll(String channelCode,BaseParttimeJobEnroll bpe) throws ServiceException{
		BaseParttimeJobEnrollExample bpje = new BaseParttimeJobEnrollExample();
		bpje.createCriteria().andChaCodeEqualTo(channelCode).andJobCodeEqualTo(bpe.getJobCode());
		long count = bptjMapper.countByExample(bpje);
		if(count>0) {
			throw new ServiceException("已经报名，不能重复报名");
		}
		Timestamp ts = CommonUtils.getCurrentDbTimestamp();
		bpe.setChaCode(channelCode);
		bpe.setCode(bcService.getNextBizCode("ENR"));
		bpe.setCreater(channelCode);
		bpe.setCreateTime(ts);
		bpe.setEnrollDate(ts);
		bpe.setId(CommonUtils.getUUID(32));
		bpe.setState("0");
		bpe.setUpdater(channelCode);
		bpe.setUpdateTime(ts);
		bptjMapper.insertSelective(bpe);
	}
	/**
	 * 查询我的兼职
	 * @param channelCode
	 * @return
	 */
	public List<BaseParttimeJobEnroll> selectMyLandParttimeJob(String channelCode) {
		BaseParttimeJobEnrollExample bpje = new BaseParttimeJobEnrollExample();
		bpje.createCriteria();
		Map filter = new HashMap();
		filter.put("exists(select 1 from base_parttime_job_enroll b where b.job_code = land_parttime_job.code and lower(b.cha_code)='"+channelCode.toLowerCase()+"') and 1@=","1");
		bpje.integratedQuery(filter);
		return bptjMapper.selectByExample(bpje);
	}
	/**
	 * 查询我的消息
	 * @param channelCode
	 * @return
	 */
	public List<BaseMsg> selectMyBaseMsg(String channelCode) {
		BaseMsgExample bme = new BaseMsgExample();
		bme.createCriteria().andReceiverEqualTo(channelCode);
		return bMsgMapper.selectByExample(bme);
	}
}
