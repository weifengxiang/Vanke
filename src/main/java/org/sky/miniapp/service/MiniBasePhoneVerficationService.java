package org.sky.miniapp.service;

import java.util.Date;

import org.sky.base.client.BasePhoneVerificationMapper;
import org.sky.base.model.BasePhoneVerification;
import org.sky.miniapp.utils.MiniAppUtils;
import org.sky.sys.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniBasePhoneVerficationService {
	
	@Autowired
	private BasePhoneVerificationMapper basePhoneVerificationMapper;
	
	/**
	 * 生成验证码
	 * @return
	 */
	public String getVerficationCode(String phoneNum) {
		// TODO Auto-generated method stub
		BasePhoneVerification pv = new BasePhoneVerification();
		pv.setRecid(CommonUtils.getUUID());
		pv.setPhoneNum(phoneNum);
		String code = MiniAppUtils.getVerficationCode();
		pv.setVerificationCode(code);
		Date vtime = new Date((CommonUtils.getCurrentDbDate().getTime()) + (long)(1000*60*30));
		pv.setValidityTime(vtime);
		pv.setCreateTime(CommonUtils.getCurrentDbTimestamp());
		basePhoneVerificationMapper.insertSelective(pv);
		return code;
	}

}
