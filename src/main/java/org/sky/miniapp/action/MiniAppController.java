package org.sky.miniapp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.utils.AppConst;
import org.sky.app.utils.JwtUtil;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.miniapp.service.MiniAppService;
import org.sky.sys.utils.MD5Utils;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: MiniAppController 
 * @Description: TODO(小程序后台服务) 
 * @author AK
 * @date 2018-5-9 下午8:08:27 
 *
 */
@RestController
public class MiniAppController {
	@Autowired
	private MiniAppService miniappService;
	
	/**
	 * 使用token登录
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/miniapp/tokenLogin",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData tokenLogin(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		try {
			String token = request.getParameter("refreshToken");
			if(null==token||"".equals(token)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setName(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			//解析token值
			rd = JwtUtil.parseJWT(token, JwtUtil.TOKEN_TYPE_REFRESH);
			if(!AppConst.SUCCESS.equals(rd.getCode())){
				return rd;
			}
			String chaCode = (String) rd.getData();
			//判断必要信息是否存在
			if(null==chaCode||"".equals(chaCode)){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setName(AppConst.TOKEN_ERROR_DESCRIPTION);
				return rd;
			}
			//从数据库获取渠道用户信息
			BaseChannel channelUser = miniappService.getBaseChannelByCode(chaCode);
			loginSuccessResult(rd,channelUser);
			return rd;
		} catch (Exception e) {
			rd.setCode("0");
			rd.setName("登录失败,请从新登录,"+e.getMessage());
			return rd;
		}
	}
	
	/**
	 * 渠道登录接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData login(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		if(StringUtils.isNull(tel)) {
			rd.setCode("0");
			rd.setName("登录失败,电话号码不能为空");
			return rd;
		}else if(StringUtils.isNull(password)) {
			rd.setCode("0");
			rd.setName("登录失败,密码不能为空");
			return rd;
		}
		try {
			BaseChannel bc = miniappService.login(tel, password);
			loginSuccessResult(rd,bc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rd.setCode("0");
			rd.setName(e.getMessage());
		}
		return rd;
	}
	/**
	 * 用户注册接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/register",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData register(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		String verCode = request.getParameter("verCode");
		if(StringUtils.isNull(tel)) {
			rd.setCode("0");
			rd.setName("注册失败,电话号码不能为空");
			return rd;
		}else if(StringUtils.isNull(password)) {
			rd.setCode("0");
			rd.setName("注册失败,密码不能为空");
			return rd;
		}else if(StringUtils.isNull(verCode)) {
			rd.setCode("0");
			rd.setName("注册失败,验证码不能为空");
			return rd;
		}
		try {
			miniappService.register(tel, password, verCode);
			rd.setCode("1");
			rd.setName("注册成功");
			return rd;
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName(e.getMessage());
			return rd;
		}
	}
	/**
	 * 推荐客户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/recommendCustomer",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData recommendCustomer(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String customer = request.getParameter("customer");
		String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		try {
			miniappService.recommendCustomer(customer, channelCode);
			rd.setCode("1");
			rd.setName("保存成功");
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("保存失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 我的推荐
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/myRecommend/{type}",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData myRecommend(
			@PathVariable String type,
			HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		try {
			List list = miniappService.myRecommend(type,channelCode);
			rd.setCode("1");
			rd.setName("查询成功");
			rd.setData(list);
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("查询失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 实名认证
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/realNameAuthentication",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData realNameAuthentication(
			HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		String channel = (String) request.getParameter("channel");
		try {
			miniappService.realNameAuthentication(channel,channelCode);
			rd.setCode("1");
			rd.setName("资料已经上传，等待后台认证");
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("资料上传失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 基础资料保存
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/saveBaseChannel",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData saveBaseChannel(
			HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		String channel = (String) request.getParameter("channel");
		try {
			miniappService.saveBaseChannel(channel,channelCode);
			rd.setCode("1");
			rd.setName("基础资料保存成功");
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("基础资料保存失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 基础资料查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/getBaseChannel",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData getBaseChannel(
			HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		try {
			BaseChannel bc = miniappService.getBaseChannel(channelCode);
			rd.setCode("1");
			rd.setName("查询成功");
			rd.setData(bc);
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("查询失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 忘记密码/修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/updatePassword",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData updatePassword(
			HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		String tel = request.getParameter("tel");
		String newPassword = request.getParameter("newPassword");
		String verCode = request.getParameter("verCode");
		try {
			miniappService.updatePassword(channelCode,tel,newPassword,verCode);
			rd.setCode("1");
			rd.setName("密码修改成功");
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("密码修改失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 查询字典信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/getItem",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData getItem(
			HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String itemType = request.getParameter("itemType");
		try {
			List list = miniappService.getItem(itemType);
			rd.setCode("1");
			rd.setName("查询成功");
			rd.setData(list);
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("查询失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 刷新token
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/refreshToken",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData refreshToken(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		try {
			String token = request.getParameter(AppConst.REFRESH_TOKEN_NAME);
			if(null==token||"".equals(token)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setName(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			//解析token值
			rd = JwtUtil.parseJWT(token, JwtUtil.TOKEN_TYPE_REFRESH);
			Map<String,String> resultMap = new HashMap<String,String>();
			resultMap.put("refreshToken", JwtUtil.createJWT((String)rd.getData(),JwtUtil.TOKEN_TYPE_REFRESH,JwtUtil.JWT_REFRESH_EXP));
			resultMap.put("requestToken", JwtUtil.createJWT((String)rd.getData(),JwtUtil.TOKEN_TYPE_REQUEST,JwtUtil.JWT_REQUEST_EXP));
			rd.setCode("1");
			rd.setName("刷新成功");
			rd.setData(resultMap);
			return rd;
		} catch (Exception e) {
			rd.setCode("0");
			rd.setName("刷新失败,"+e.getMessage());
			return rd;
		}
	}
	/**
	 * 获取短信验证码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/miniapp/obtainSms",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData obtainSms(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String tel = request.getParameter("tel");
		if(StringUtils.isNull(tel)) {
			rd.setCode("0");
			rd.setName("电话号码不能为空");
			return rd;
		}
		try {
			miniappService.obtainSms(tel);
			rd.setCode("1");
			rd.setName("验证码已发送");
			return rd;
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName(e.getMessage());
			return rd;
		}
	}
	/**
	 * 生成登录返回值
	 * @param rd
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private ResultData loginSuccessResult(ResultData rd,BaseChannel user) throws Exception{
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("refreshToken", JwtUtil.createJWT(user.getCode(),JwtUtil.TOKEN_TYPE_REFRESH,JwtUtil.JWT_REFRESH_EXP));
		resultMap.put("requestToken", JwtUtil.createJWT(user.getCode(),JwtUtil.TOKEN_TYPE_REQUEST,JwtUtil.JWT_REQUEST_EXP));
		resultMap.put("username", user.getName());
		rd.setCode("1");
		rd.setName("登录成功");
		rd.setData(resultMap);
		return rd;
	}

}
