package org.sky.app.utils;
/**
 * 
 * @ClassName:  Const   
 * @Description:TODO(APP常量类)   
 * @author: weifx 
 * @date:   2018年4月11日 下午11:18:20   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class AppConst {
	
	/********************不需要验证token的地址*************************/
	public static final String NO_INTERCEPTOR_PATH = ".*/((test)|(initPosition)|(tokenLogin)|(login)|(refreshToken)).*";//不需要验证token地址
	
	/*******************返回成功代码**********************************/
	public static final String SUCCESS = "SUCCESS";//成功
	public static final String SUCCESS_DESCRIPTION = "操作成功";
	
	/*******************返回错误代码及描述******************************/
	//通用错误类型
	public static final String SYS_ERROR = "SYS_ERROR";
	public static final String SYS_ERROR_DESCRIPTION = "系统错误";
	public static final String PARAMETER_NULL = "PARAMETER_NULL";
	public static final String PARAMETER_NULL_DESCRIPTION = "缺少必须参数";
	public static final String PARAMETER_ERROR = "PARAMETER_ERROR";
	public static final String PARAMETER_ERROR_DESCRIPTION = "参数不符合要求";
	public static final String ROLE_ERROR = "ROLE_ERROR";
	public static final String ROLE_ERROR_DESCRIPTION = "没有权限";
	//token错误类型
	public static final String TOKEN_NULL = "TOKEN_ERROR_0001";
	public static final String TOKEN_NULL_DESCRIPTION = "没有token参数";
	public static final String TOKEN_EXP = "TOKEN_ERROR_0002";
	public static final String TOKEN_EXP_DESCRIPTION = "token过期";
	public static final String TOKEN_ERROR = "TOKEN_ERROR_0003";
	public static final String TOKEN_ERROR_DESCRIPTION = "token无效";
	//用户错误类型
	public static final String USER_LOGIN_ERROR = "USER_ERROR_0002";
	public static final String USER_LOGIN_ERROR_DESCRIPTION = "用户名或密码错误";
	public static final String USER_LOGIN_INVALID = "USER_ERROR_0003";
	public static final String USER_LOGIN_INVALID_DESCRIPTION = "登录信息无效";
	
	/********************系统常量*********************/
	//request中的参数名
	public static final String REQUEST_TOKEN = "token";//request中token参数名称
	public static final String REQUEST_USER_ID = "request_user_id";//request中userid参数名称
	//全局常量
	public static final String APP_NOT = "0";//否
	public static final String APP_IS = "1";//是
	
	/********************客户模块常量******************/
	public static final String CUSTOMER_TYPE_0 = "0";//表示全部客户
	public static final String CUSTOMER_TYPE_1 = "1";//表示今日客户
	public static final String CUSTOMER_TYPE_2 = "2";//表示重点客户
}
