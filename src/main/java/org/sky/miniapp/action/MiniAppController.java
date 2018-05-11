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
	
	private Logger logger = Logger.getLogger(MiniAppController.class);
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
			String token = request.getParameter(AppConst.REQUEST_TOKEN);
			if(null==token||"".equals(token)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setName(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			//解析token值
			rd = JwtUtil.parseJWT(token, JwtUtil.TOKEN_TYPE_LOGIN);
			if(!AppConst.SUCCESS.equals(rd.getCode())){
				return rd;
			}
			String tel = (String) rd.getData();
			//判断必要信息是否存在
			if(null==tel||"".equals(tel)){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setName(AppConst.TOKEN_ERROR_DESCRIPTION);
				return rd;
			}
			//从数据库获取渠道用户信息
			BaseChannel channelUser = miniappService.getBaseChannelByTel(tel);
			loginSuccessResult(rd,channelUser);
			return rd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			rd.setCode(AppConst.SYS_ERROR);
			rd.setName(AppConst.SYS_ERROR_DESCRIPTION);
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
			logger.error(e.getMessage());
			e.printStackTrace();
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
			logger.error(e.getMessage());
			e.printStackTrace();
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
		String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN);
		try {
			miniappService.recommendCustomer(customer, channelCode);
			rd.setCode("1");
			rd.setName("保存成功");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			rd.setCode("0");
			rd.setName("保存失败");
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
			String token = request.getParameter(AppConst.REQUEST_TOKEN);
			if(null==token||"".equals(token)){
				rd.setCode(AppConst.TOKEN_NULL);
				rd.setName(AppConst.TOKEN_NULL_DESCRIPTION);
				return rd;
			}
			//解析token值
			rd = JwtUtil.parseJWT(token, JwtUtil.TOKEN_TYPE_LOGIN);
			if(!AppConst.SUCCESS.equals(rd.getCode())||null==rd.getData()||"".equals(rd.getData())){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setName(AppConst.TOKEN_ERROR_DESCRIPTION);
				return rd;
			}
			Map<String,String> resultMap = new HashMap<String,String>();
			resultMap.put("requestToken", JwtUtil.createJWT((String)rd.getData(), JwtUtil.TOKEN_TYPE_REQUEST, JwtUtil.JWT_EXP));
			rd.setCode(AppConst.SUCCESS);
			rd.setData(resultMap);
			return rd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			rd.setCode(AppConst.SYS_ERROR);
			rd.setName(AppConst.SYS_ERROR_DESCRIPTION);
			return rd;
		}
	}
	
	private ResultData loginSuccessResult(ResultData rd,BaseChannel user) throws Exception{
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("loginToken", JwtUtil.createJWT(user.getCode(),JwtUtil.TOKEN_TYPE_LOGIN,JwtUtil.JWT_REFRESH_TTL));
		resultMap.put("requestToken", JwtUtil.createJWT(user.getCode(), JwtUtil.TOKEN_TYPE_REQUEST, JwtUtil.JWT_EXP));
		resultMap.put("username", user.getName());
		rd.setCode(AppConst.SUCCESS);
		rd.setData(resultMap);
		return rd;
	}

}
