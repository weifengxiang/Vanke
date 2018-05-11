package org.sky.miniapp.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.sky.base.client.BaseChannelImgMapper;
import org.sky.base.client.BaseChannelMapper;
import org.sky.base.client.BaseCustomerMapper;
import org.sky.base.client.BasePhoneVerificationMapper;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.base.model.BaseChannelImg;
import org.sky.base.model.BaseChannelImgWithBLOBs;
import org.sky.base.model.BaseCustomer;
import org.sky.base.model.BaseCustomerExample;
import org.sky.base.model.BasePhoneVerification;
import org.sky.base.model.BasePhoneVerificationExample;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.client.SysDictItemMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysDictItemExample;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.MD5Utils;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniAppService {
	
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
	private SysDictItemMapper itemMapper;
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
	 * 渠道登录
	 * @param tel
	 * @param password
	 */
	public BaseChannel login(String tel,String password) throws ServiceException{
		BaseChannelExample example = new BaseChannelExample();
		example.createCriteria().andTelEqualTo(tel);
		List<BaseChannel> list = baseChannelMapper.selectByExample(example);
		if(null==list||list.size()<1){
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
	public BaseChannel register(String tel,String password,String verCode) throws ServiceException {
		BaseChannel bc = null;
		BaseChannelExample example = new BaseChannelExample();
		example.createCriteria().andTelEqualTo(tel);
		List<BaseChannel> channelList = baseChannelMapper.selectByExample(example);
		if(channelList.size()==0 || channelList.isEmpty()) {
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
				bc.setTel(tel);
				bc.setPassword(MD5Utils.MD5LOWER(password));
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
			throw new ServiceException("客户信息不能为空");
		}
		BaseCustomer bc = JsonUtils.json2pojo(customer, BaseCustomer.class);
		Timestamp ts = comMapper.queryTimestamp();
		bc.setId(CommonUtils.getUUID(32));
		bc.setCreater(channelCode);
		bc.setCreateTime(ts);
		bc.setUpdater(channelCode);
		bc.setUpdateTime(ts);
		bc.setChannelCode(channelCode);
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
			list=baseCustomerMapper.selectByExample(e);
		}else if("channel".equals(type)) {
			BaseChannelExample e = new BaseChannelExample();
			e.createCriteria().andChannelCodeEqualTo(channelCode);
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
			throw new ServiceException("认证信息不能为空");
		}
		try {
			BaseChannel bc = JsonUtils.json2pojo(channel, BaseChannel.class);
			BaseChannelExample e = new BaseChannelExample();
			e.createCriteria().andChannelCodeEqualTo(channelCode);
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
			imgMapper.insertSelective(bci);
		}catch(Exception e) {
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
			e.createCriteria().andChannelCodeEqualTo(channelCode);
			baseChannelMapper.updateByExampleSelective(bc, e);
		}catch(Exception e) {
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
			e.createCriteria().andChannelCodeEqualTo(channelCode);
			List<BaseChannel> list = baseChannelMapper.selectByExample(e);
			if(list.size()>0) {
				return list.get(0);
			}else {
				return null;
			}
		}catch(Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * 更新新密码
	 * @param tel
	 * @param newPassword
	 * @param verCode
	 */
	public void updatePassword(String channelCode,String tel,String newPassword,String verCode) throws ServiceException{
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
				try {
					BaseChannel bc = new BaseChannel();
					bc.setCode(channelCode);
					bc.setPassword(MD5Utils.MD5LOWER(newPassword));		
					bc.setUpdateTime(CommonUtils.getCurrentDbDate());
					BaseChannelExample bce = new BaseChannelExample();
					bce.createCriteria().andCodeEqualTo(channelCode).andTelEqualTo(tel);
					baseChannelMapper.updateByExampleSelective(bc,bce);
					//使用完验证码后删掉
					phoneVerMapper.deleteByExample(e);
				}catch(Exception ex) {
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
		SysDictItemExample sdie = new SysDictItemExample();
		sdie.createCriteria().andDictCodeEqualTo(itemType);
		return itemMapper.selectByExample(sdie);
	}
	/**
	 * 获取短信验证码
	 * @param tel
	 */
	public void obtainSms(String tel) {
		
	}
}
