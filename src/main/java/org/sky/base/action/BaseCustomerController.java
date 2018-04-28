package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseCustomer;
import org.sky.base.model.BaseCustomerExample;
import org.sky.base.model.BaseCustomerExample.Criteria;
import org.sky.base.service.BaseCustomerService;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 * 
 * @ClassName:  BaseCustomerController   
 * @Description:TODO(客户信息管理)   
 * @author: weifx 
 * @date:   2018年4月28日 下午9:47:08   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class BaseCustomerController extends BaseController{
	@Autowired
	private BaseCustomerService basecustomerService;
	
	public BaseCustomerController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示客户资源信息列表页面
	**/
	@RequestMapping(value = "/base/BaseCustomer/initBaseCustomerListPage", method = { RequestMethod.GET })
	public String initBaseCustomerListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/customer/listbasecustomer";
	}
	/**
	 * 客户资源信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseCustomer/getBaseCustomerByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseCustomerByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseCustomerExample pote= new BaseCustomerExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = basecustomerService.getBaseCustomerByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示客户资源信息新增页面
	**/
	@RequestMapping(value = "/base/BaseCustomer/initAddBaseCustomerPage", method = { RequestMethod.GET })
	public String initAddBaseCustomerPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/customer/editbasecustomer";
	}
	/**
	*显示客户资源信息修改页面
	**/
	@RequestMapping(value = "/base/BaseCustomer/initEditBaseCustomerPage", method = { RequestMethod.GET })
	public String initEditBaseCustomerPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/customer/editbasecustomer";
	}
	/**
	*显示客户资源信息详细页面
	**/
	@RequestMapping(value = "/base/BaseCustomer/initDetailBaseCustomerPage", method = { RequestMethod.GET })
	public String initDetailBaseCustomerPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/customer/detailbasecustomer";
	}
	/**
	*保存新增/修改客户资源信息
	**/
	@RequestMapping(value = "/base/BaseCustomer/saveAddEditBaseCustomer", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseCustomer(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseCustomer edit = (BaseCustomer) getEntityBean(request,BaseCustomer.class);
			basecustomerService.saveAddEditBaseCustomer(edit);
			rd.setCode(ResultData.code_success);
			rd.setName("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("保存失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
	/**
	*删除客户资源信息
	**/
	@RequestMapping(value = "/base/BaseCustomer/delBaseCustomer", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseCustomer(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseCustomer.class);
			basecustomerService.delBaseCustomerById(de);
			rd.setCode(ResultData.code_success);
			rd.setName("删除成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("删除失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
	/**
	*根据主键查询客户资源信息
	**/
	@RequestMapping(value = "/base/BaseCustomer/getBaseCustomerById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseCustomerById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseCustomer bean = basecustomerService.getBaseCustomerById(id);
		return JsonUtils.obj2json(bean);
	}
}