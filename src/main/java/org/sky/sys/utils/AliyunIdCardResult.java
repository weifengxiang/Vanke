package org.sky.sys.utils;

import java.util.Map;

/**
 * 
 * @ClassName:  IdCardResult   
 * @Description:TODO(身份证识别结果)   
 * @author: weifx 
 * @date:   2018年5月16日 下午5:16:17   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class AliyunIdCardResult {
	/**
	 * "{"side":"face"}"
	 */
	private String config_str;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 民族
	 */
	private String nationality;
	/**
	 * 是否成功
	 */
	private boolean success;
	/**
	 * 身份证号
	 */
	private String num;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 姓名
	 */
	private String name;
	
	private String birth;
	
	private String request_id;
	
	private Map<String,Object> face_rect;

	public String getConfig_str() {
		return config_str;
	}

	public void setConfig_str(String config_str) {
		this.config_str = config_str;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public Map<String, Object> getFace_rect() {
		return face_rect;
	}

	public void setFace_rect(Map<String, Object> face_rect) {
		this.face_rect = face_rect;
	}
	
}
