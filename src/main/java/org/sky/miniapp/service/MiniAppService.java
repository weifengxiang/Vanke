package org.sky.miniapp.service;

import java.sql.Timestamp;
import java.util.List;

import org.sky.base.client.BaseChannelMapper;
import org.sky.base.client.BasePhoneVerificationMapper;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.base.model.BaseCustomer;
import org.sky.base.model.BasePhoneVerification;
import org.sky.base.model.BasePhoneVerificationExample;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.exception.ServiceException;
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
	private BasePhoneVerificationMapper phoneVerMapper;
	@Autowired
	private SysCommonMapper comMapper;
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
				bc.setCreateTime(CommonUtils.getCurrentDbDate());
				bc.setUpdateTime(CommonUtils.getCurrentDbDate());
				baseChannelMapper.insertSelective(bc);
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
}
