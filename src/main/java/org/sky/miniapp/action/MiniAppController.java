package org.sky.miniapp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.utils.AppConst;
import org.sky.app.utils.JwtUtil;
import org.sky.app.utils.ResultData;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.miniapp.service.MiniAppService;
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
				rd.setResult(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			//解析token值
			rd = JwtUtil.parseJWT(token, JwtUtil.TOKEN_TYPE_LOGIN);
			if(!AppConst.SUCCESS.equals(rd.getCode())){
				return rd;
			}
			String userid = (String) rd.getResult();
			//判断必要信息是否存在
			if(null==userid||"".equals(userid)){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setResult(AppConst.TOKEN_ERROR_DESCRIPTION);
				return rd;
			}
			//从数据库获取渠道用户信息
			BaseChannel channelUser = miniappService.getBaseChannelById(userid);
			loginSuccessResult(rd,channelUser);
			return rd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			rd.setCode(AppConst.SYS_ERROR);
			rd.setResult(AppConst.SYS_ERROR_DESCRIPTION);
			return rd;
		}
	}
	
	/**
	 * 用户登录接口
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/miniapp/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData login(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		try {
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			if(null==loginName||"".equals(loginName)||null==password||"".equals(password)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setResult(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			BaseChannelExample example = new BaseChannelExample();
			example.createCriteria().andTelEqualTo(loginName).andPasswordEqualTo(password);
			List<BaseChannel> list = miniappService.listBaseChannelByExample(example);
			if(null==list||list.size()<1){
				rd.setCode(AppConst.USER_LOGIN_ERROR);
				rd.setResult(AppConst.USER_LOGIN_ERROR_DESCRIPTION);
				return rd;
			}
			BaseChannel channelUser = list.get(0);
			loginSuccessResult(rd,channelUser);
			return rd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			rd.setCode(AppConst.SYS_ERROR);
			rd.setResult(AppConst.SYS_ERROR_DESCRIPTION);
			return rd;
		}
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
				rd.setResult(AppConst.TOKEN_NULL_DESCRIPTION);
				return rd;
			}
			//解析token值
			rd = JwtUtil.parseJWT(token, JwtUtil.TOKEN_TYPE_LOGIN);
			if(!AppConst.SUCCESS.equals(rd.getCode())||null==rd.getResult()||"".equals(rd.getResult())){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setResult(AppConst.TOKEN_ERROR_DESCRIPTION);
				return rd;
			}
			
			Map<String,String> resultMap = new HashMap<String,String>();
			resultMap.put("requestToken", JwtUtil.createJWT((String)rd.getResult(), JwtUtil.TOKEN_TYPE_REQUEST, JwtUtil.JWT_EXP));
			rd.setCode(AppConst.SUCCESS);
			rd.setResult(resultMap);
			return rd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			rd.setCode(AppConst.SYS_ERROR);
			rd.setResult(AppConst.SYS_ERROR_DESCRIPTION);
			return rd;
		}
	}
	
	private ResultData loginSuccessResult(ResultData rd,BaseChannel user) throws Exception{
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("loginToken", JwtUtil.createJWT(user.getId(),JwtUtil.TOKEN_TYPE_LOGIN,JwtUtil.JWT_REFRESH_TTL));
		resultMap.put("requestToken", JwtUtil.createJWT(user.getId(), JwtUtil.TOKEN_TYPE_REQUEST, JwtUtil.JWT_EXP));
		resultMap.put("name", user.getName());
		rd.setCode(AppConst.SUCCESS);
		rd.setResult(resultMap);
		return rd;
	}

}
