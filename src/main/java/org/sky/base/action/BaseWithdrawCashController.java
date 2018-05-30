package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseWithdrawCash;
import org.sky.base.model.BaseWithdrawCashExample;
import org.sky.base.model.BaseWithdrawCashExample.Criteria;
import org.sky.base.service.BaseWithdrawCashService;
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
public class BaseWithdrawCashController extends BaseController{
	@Autowired
	private BaseWithdrawCashService basewithdrawcashService;
	
	public BaseWithdrawCashController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示提现申请信息列表页面
	**/
	@RequestMapping(value = "/base/BaseWithdrawCash/initBaseWithdrawCashListPage", method = { RequestMethod.GET })
	public String initBaseWithdrawCashListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/withdrawcash/listbasewithdrawcash";
	}
	/**
	 * 提现申请信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseWithdrawCash/getBaseWithdrawCashByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseWithdrawCashByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseWithdrawCashExample pote= new BaseWithdrawCashExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = basewithdrawcashService.getBaseWithdrawCashByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示提现申请信息新增页面
	**/
	@RequestMapping(value = "/base/BaseWithdrawCash/initAddBaseWithdrawCashPage", method = { RequestMethod.GET })
	public String initAddBaseWithdrawCashPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/withdrawcash/editbasewithdrawcash";
	}
	/**
	*显示提现申请信息修改页面
	**/
	@RequestMapping(value = "/base/BaseWithdrawCash/initEditBaseWithdrawCashPage", method = { RequestMethod.GET })
	public String initEditBaseWithdrawCashPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/withdrawcash/editbasewithdrawcash";
	}
	/**
	*显示提现申请信息详细页面
	**/
	@RequestMapping(value = "/base/BaseWithdrawCash/initDetailBaseWithdrawCashPage", method = { RequestMethod.GET })
	public String initDetailBaseWithdrawCashPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/withdrawcash/detailbasewithdrawcash";
	}
	/**
	*保存新增/修改提现申请信息
	**/
	@RequestMapping(value = "/base/BaseWithdrawCash/saveAddEditBaseWithdrawCash", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseWithdrawCash(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseWithdrawCash edit = (BaseWithdrawCash) getEntityBean(request,BaseWithdrawCash.class);
			basewithdrawcashService.saveAddEditBaseWithdrawCash(edit);
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
	*删除提现申请信息
	**/
	@RequestMapping(value = "/base/BaseWithdrawCash/delBaseWithdrawCash", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseWithdrawCash(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseWithdrawCash.class);
			basewithdrawcashService.delBaseWithdrawCashById(de);
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
	*根据主键查询提现申请信息
	**/
	@RequestMapping(value = "/base/BaseWithdrawCash/getBaseWithdrawCashById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseWithdrawCashById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseWithdrawCash bean = basewithdrawcashService.getBaseWithdrawCashById(id);
		return JsonUtils.obj2json(bean);
	}
}