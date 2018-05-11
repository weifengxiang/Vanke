package org.sky.app.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.service.AppBaseCustomerService;
import org.sky.app.utils.AppConst;
import org.sky.base.model.BaseCustomerExample;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: BaseCustomerController 
 * @Description: TODO(客户接口类) 
 * @author AK
 * @date 2018-5-7 下午7:32:13 
 *
 */
@RestController
public class AppBaseCustomerController {
	
	private final Logger logger = Logger.getLogger(AppBaseCustomerController.class); 
	
	@Autowired
	private AppBaseCustomerService appBaseCustomerService;
	
	/**
	 * 客户分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/app/BaseCustomer/listBaseCustomerByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public ResultData listBaseCustomerByPage(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		try{
			//获取用户ID
			String user_id = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
			//获取参数
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			String type = request.getParameter("type");//0:表示全部用户，1:表示今日客户2:表示重点客户
			if(StringUtils.isNull(page)||StringUtils.isNull(rows)||StringUtils.isNull(type)||StringUtils.isNull(user_id)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setName(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			Map<String,Object> filterMap = new HashMap<String,Object>();
			BaseCustomerExample example = new BaseCustomerExample();
			if(AppConst.CUSTOMER_TYPE_1.equals(type)){
				filterMap.put("to_char(visit_time,'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd') and 1@=", "1");
			}else if(AppConst.CUSTOMER_TYPE_2.equals(type)){
				filterMap.put("impCustomer@=", AppConst.APP_IS);
			}
			filterMap.put("creater@=", user_id);
			example.createCriteria();
			example.integratedQuery(filterMap);
			example.setOrderByClause("update_time desc");
			//设置分页
			Page p = new Page();
			p.setBegin((Integer.valueOf(page)-1)*Integer.valueOf(rows));
			p.setEnd(Integer.valueOf(page)*Integer.valueOf(rows));
			example.setPage(p);
			PageListData pld = appBaseCustomerService.listBaseCustomerByPage(example);
			rd.setCode(AppConst.SUCCESS);
			rd.setData(pld);
			return rd;
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			rd.setCode(AppConst.SYS_ERROR);
			rd.setName(AppConst.SYS_ERROR_DESCRIPTION);
			return rd;
		}
		
	}

}
