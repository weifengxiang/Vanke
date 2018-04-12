package org.sky.app.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.entity.AppUser;
import org.sky.app.service.AppSysService;
import org.sky.app.utils.JWTUtils;
import org.sky.reception.model.BaseVisitor;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysUser;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @ClassName:  SysController   
 * @Description:TODO(App后台服务)   
 * @author: weifx 
 * @date:   2018年4月11日 下午10:03:10   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class AppSysController {
	private Logger logger = Logger.getLogger(AppSysController.class);
	@Autowired
	private AppSysService appSysService;
	
	@RequestMapping(value = "/app/SysController/login", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody ResultData login(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		SysUser su = appSysService.getSysUserByCode(userName);
		if(null!=su) {
			if(passWord.equals(su.getPassword())) {
				try {
					//保持登录状态TOKEN
					String loginToken = JWTUtils.createJWT(su.getCode(),su.getCode(),JWTUtils.JWT_LOGIN_TYPE);
					//请求访问TOKEN
					String requestToken = JWTUtils.createJWT(su.getCode(),su.getCode(),JWTUtils.JWT_REQUEST_TYPE);
					rd.setCode("1");
					rd.setName("登录成功");
					Map token = new HashMap();
					token.put("loginToken", loginToken);
					token.put("requestToken", requestToken);
					AppUser au = new AppUser();
					au.setCode(su.getCode());
					au.setName(su.getName());
					token.put("au", au);
					rd.setData(token);
					return rd;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error(e.getStackTrace());
					rd.setCode("0");
					rd.setName("登录失败");
					rd.setDesc(e.getMessage());
				}
			}
		}
		rd.setCode("0");
		rd.setName("登录失败");
		return rd;
	}
}
