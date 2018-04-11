package org.sky.reception.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.reception.model.BaseVisitor;
import org.sky.reception.model.BaseVisitorExample;
import org.sky.reception.model.BaseVisitorExample.Criteria;
import org.sky.reception.service.BaseVisitorService;
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
public class BaseVisitorController extends BaseController{
	@Autowired
	private BaseVisitorService basevisitorService;
	
	public BaseVisitorController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示01.来访信息列表页面
	**/
	@RequestMapping(value = "/reception/BaseVisitor/initBaseVisitorListPage", method = { RequestMethod.GET })
	public String initBaseVisitorListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/reception/dj/listbasevisitor";
	}
	/**
	 * 01.来访信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reception/BaseVisitor/getBaseVisitorByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseVisitorByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseVisitorExample pote= new BaseVisitorExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = basevisitorService.getBaseVisitorByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示01.来访信息新增页面
	**/
	@RequestMapping(value = "/reception/BaseVisitor/initAddBaseVisitorPage", method = { RequestMethod.GET })
	public String initAddBaseVisitorPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/reception/dj/editbasevisitor";
	}
	/**
	*显示01.来访信息修改页面
	**/
	@RequestMapping(value = "/reception/BaseVisitor/initEditBaseVisitorPage", method = { RequestMethod.GET })
	public String initEditBaseVisitorPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/reception/dj/editbasevisitor";
	}
	/**
	*显示01.来访信息详细页面
	**/
	@RequestMapping(value = "/reception/BaseVisitor/initDetailBaseVisitorPage", method = { RequestMethod.GET })
	public String initDetailBaseVisitorPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/reception/dj/detailbasevisitor";
	}
	/**
	*保存新增/修改01.来访信息
	**/
	@RequestMapping(value = "/reception/BaseVisitor/saveAddEditBaseVisitor", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseVisitor(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseVisitor edit = (BaseVisitor) getEntityBean(request,BaseVisitor.class);
			basevisitorService.saveAddEditBaseVisitor(edit);
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
	*删除01.来访信息
	**/
	@RequestMapping(value = "/reception/BaseVisitor/delBaseVisitor", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseVisitor(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseVisitor.class);
			basevisitorService.delBaseVisitorById(de);
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
	*根据主键查询01.来访信息
	**/
	@RequestMapping(value = "/reception/BaseVisitor/getBaseVisitorById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseVisitorById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseVisitor bean = basevisitorService.getBaseVisitorById(id);
		return JsonUtils.obj2json(bean);
	}
}