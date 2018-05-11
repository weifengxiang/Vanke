package org.sky.app.utils;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.sys.utils.ResultData;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;

public class JwtInterceptor extends HandlerInterceptorAdapter {
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        if (path.matches(AppConst.NO_INTERCEPTOR_PATH)) {
            return true;
        } else {
        	//验证token
        	ResultData rd = new ResultData();
        	String token = request.getParameter(AppConst.REQUEST_TOKEN_NAME);
        	if(null==token||"".equals(token)){
        		rd.setCode(AppConst.TOKEN_NULL);
        		rd.setName(AppConst.TOKEN_NULL_DESCRIPTION);
        	}else{
        		rd = JwtUtil.parseJWT(token,JwtUtil.TOKEN_TYPE_REQUEST);
        	}
        	if(AppConst.SUCCESS.equals(rd.getCode())){
        		request.setAttribute(AppConst.REQUEST_LOGIN_MSG, (String)rd.getData());
        		return true;
        	}else{
	        	response.setContentType("application/json;charset=UTF-8");
	    		OutputStream oStream = response.getOutputStream();
				oStream.write(JSONObject.toJSONString(rd).getBytes("UTF-8"));
				oStream.close();
				return false;
        	}
        }
    }
	
}
