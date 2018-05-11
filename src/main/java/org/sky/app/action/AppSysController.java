package org.sky.app.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.service.AppSysService;
import org.sky.app.utils.AppConst;
import org.sky.app.utils.JwtUtil;
import org.sky.sys.model.SysUser;
import org.sky.sys.model.SysUserExample;
import org.sky.sys.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @ClassName:  SysController   
 * @Description:TODO(App后台服务)   
 * @author: weifx 
 * @date:   2018年4月11日 下午10:03:10   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@RestController
public class AppSysController {
	private Logger logger = Logger.getLogger(AppSysController.class); 
	@Autowired
	private AppSysService appSysService;
	
	/**
	 * 使用token登录
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/app/tokenLogin",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
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
			String userCode = (String) rd.getData();
			//判断必要信息是否存在
			if(null==userCode||"".equals(userCode)){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setName(AppConst.TOKEN_ERROR_DESCRIPTION);
				return rd;
			}
			//从数据库获取用户信息
			SysUser appUser = appSysService.getSysUserByCode(userCode);
			loginSuccessResult(rd,appUser);
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
	 * 用户登录接口
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/app/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData login(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		try {
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			if(null==loginName||"".equals(loginName)||null==password||"".equals(password)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setName(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			SysUserExample auExample = new SysUserExample();
			auExample.createCriteria().andCodeEqualTo(loginName).andPasswordEqualTo(password);
			List<SysUser> list = appSysService.listSysUserByExample(auExample);
			if(null==list||list.size()<1){
				rd.setCode(AppConst.USER_LOGIN_ERROR);
				rd.setName(AppConst.USER_LOGIN_ERROR_DESCRIPTION);
				return rd;
			}
			SysUser appUser = list.get(0);
			loginSuccessResult(rd,appUser);
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
	 * 刷新token
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/refreshToken",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
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
			if(!AppConst.SUCCESS.equals(rd.getCode())||null==rd.getName()||"".equals(rd.getName())){
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
	private ResultData loginSuccessResult(ResultData rd,SysUser user) throws Exception{
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("loginToken", JwtUtil.createJWT(user.getCode(),JwtUtil.TOKEN_TYPE_LOGIN,JwtUtil.JWT_REFRESH_TTL));
		resultMap.put("requestToken", JwtUtil.createJWT(user.getCode(), JwtUtil.TOKEN_TYPE_REQUEST, JwtUtil.JWT_EXP));
		resultMap.put("name", user.getName());
		rd.setCode(AppConst.SUCCESS);
		rd.setData(resultMap);
		return rd;
	}
}
