package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseAccount;
import org.sky.base.model.BaseAccountExample;
import org.sky.base.model.BaseAccountExample.Criteria;
import org.sky.base.service.BaseAccountService;
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
@Controller
public class BaseAccountController extends BaseController{
	@Autowired
	private BaseAccountService baseaccountService;
	
	public BaseAccountController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示账户信息列表页面
	**/
	@RequestMapping(value = "/base/BaseAccount/initBaseAccountListPage", method = { RequestMethod.GET })
	public String initBaseAccountListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/account/listbaseaccount";
	}
	/**
	 * 账户信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseAccount/getBaseAccountByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseAccountByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseAccountExample pote= new BaseAccountExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = baseaccountService.getBaseAccountByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示账户信息新增页面
	**/
	@RequestMapping(value = "/base/BaseAccount/initAddBaseAccountPage", method = { RequestMethod.GET })
	public String initAddBaseAccountPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/account/editbaseaccount";
	}
	/**
	*显示账户信息修改页面
	**/
	@RequestMapping(value = "/base/BaseAccount/initEditBaseAccountPage", method = { RequestMethod.GET })
	public String initEditBaseAccountPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/account/editbaseaccount";
	}
	/**
	*显示账户信息详细页面
	**/
	@RequestMapping(value = "/base/BaseAccount/initDetailBaseAccountPage", method = { RequestMethod.GET })
	public String initDetailBaseAccountPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/account/detailbaseaccount";
	}
	/**
	*保存新增/修改账户信息
	**/
	@RequestMapping(value = "/base/BaseAccount/saveAddEditBaseAccount", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseAccount(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseAccount edit = (BaseAccount) getEntityBean(request,BaseAccount.class);
			baseaccountService.saveAddEditBaseAccount(edit);
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
	*删除账户信息
	**/
	@RequestMapping(value = "/base/BaseAccount/delBaseAccount", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseAccount(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseAccount.class);
			baseaccountService.delBaseAccountById(de);
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
	*根据主键查询账户信息
	**/
	@RequestMapping(value = "/base/BaseAccount/getBaseAccountById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseAccountById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseAccount bean = baseaccountService.getBaseAccountById(id);
		return JsonUtils.obj2json(bean);
	}
}