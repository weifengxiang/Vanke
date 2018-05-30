package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseAccountDetail;
import org.sky.base.model.BaseAccountDetailExample;
import org.sky.base.model.BaseAccountDetailExample.Criteria;
import org.sky.base.service.BaseAccountDetailService;
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
public class BaseAccountDetailController extends BaseController{
	@Autowired
	private BaseAccountDetailService baseaccountdetailService;
	
	public BaseAccountDetailController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示账户明细列表页面
	**/
	@RequestMapping(value = "/base/BaseAccountDetail/initBaseAccountDetailListPage", method = { RequestMethod.GET })
	public String initBaseAccountDetailListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/accountdetail/listbaseaccountdetail";
	}
	/**
	 * 账户明细分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseAccountDetail/getBaseAccountDetailByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseAccountDetailByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseAccountDetailExample pote= new BaseAccountDetailExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = baseaccountdetailService.getBaseAccountDetailByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示账户明细新增页面
	**/
	@RequestMapping(value = "/base/BaseAccountDetail/initAddBaseAccountDetailPage", method = { RequestMethod.GET })
	public String initAddBaseAccountDetailPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/accountdetail/editbaseaccountdetail";
	}
	/**
	*显示账户明细修改页面
	**/
	@RequestMapping(value = "/base/BaseAccountDetail/initEditBaseAccountDetailPage", method = { RequestMethod.GET })
	public String initEditBaseAccountDetailPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/accountdetail/editbaseaccountdetail";
	}
	/**
	*显示账户明细详细页面
	**/
	@RequestMapping(value = "/base/BaseAccountDetail/initDetailBaseAccountDetailPage", method = { RequestMethod.GET })
	public String initDetailBaseAccountDetailPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/accountdetail/detailbaseaccountdetail";
	}
	/**
	*保存新增/修改账户明细
	**/
	@RequestMapping(value = "/base/BaseAccountDetail/saveAddEditBaseAccountDetail", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseAccountDetail(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseAccountDetail edit = (BaseAccountDetail) getEntityBean(request,BaseAccountDetail.class);
			baseaccountdetailService.saveAddEditBaseAccountDetail(edit);
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
	*删除账户明细
	**/
	@RequestMapping(value = "/base/BaseAccountDetail/delBaseAccountDetail", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseAccountDetail(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseAccountDetail.class);
			baseaccountdetailService.delBaseAccountDetailById(de);
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
	*根据主键查询账户明细
	**/
	@RequestMapping(value = "/base/BaseAccountDetail/getBaseAccountDetailById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseAccountDetailById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseAccountDetail bean = baseaccountdetailService.getBaseAccountDetailById(id);
		return JsonUtils.obj2json(bean);
	}
}