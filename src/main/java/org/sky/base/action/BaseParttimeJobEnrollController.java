package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseParttimeJobEnroll;
import org.sky.base.model.BaseParttimeJobEnrollExample;
import org.sky.base.model.BaseParttimeJobEnrollExample.Criteria;
import org.sky.base.service.BaseParttimeJobEnrollService;
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
public class BaseParttimeJobEnrollController extends BaseController{
	@Autowired
	private BaseParttimeJobEnrollService baseparttimejobenrollService;
	
	public BaseParttimeJobEnrollController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示兼职报名信息列表页面
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/initBaseParttimeJobEnrollListPage", method = { RequestMethod.GET })
	public String initBaseParttimeJobEnrollListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/parttimejobenroll/listbaseparttimejobenroll";
	}
	/**
	 * 兼职报名信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseParttimeJobEnrollByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseParttimeJobEnrollExample pote= new BaseParttimeJobEnrollExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = baseparttimejobenrollService.getBaseParttimeJobEnrollByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示兼职报名信息新增页面
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/initAddBaseParttimeJobEnrollPage", method = { RequestMethod.GET })
	public String initAddBaseParttimeJobEnrollPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/parttimejobenroll/editbaseparttimejobenroll";
	}
	/**
	*显示兼职报名信息修改页面
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/initEditBaseParttimeJobEnrollPage", method = { RequestMethod.GET })
	public String initEditBaseParttimeJobEnrollPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/parttimejobenroll/editbaseparttimejobenroll";
	}
	/**
	*显示兼职报名信息详细页面
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/initDetailBaseParttimeJobEnrollPage", method = { RequestMethod.GET })
	public String initDetailBaseParttimeJobEnrollPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/parttimejobenroll/detailbaseparttimejobenroll";
	}
	/**
	*保存新增/修改兼职报名信息
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/saveAddEditBaseParttimeJobEnroll", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseParttimeJobEnroll(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseParttimeJobEnroll edit = (BaseParttimeJobEnroll) getEntityBean(request,BaseParttimeJobEnroll.class);
			baseparttimejobenrollService.saveAddEditBaseParttimeJobEnroll(edit);
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
	*删除兼职报名信息
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/delBaseParttimeJobEnroll", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseParttimeJobEnroll(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseParttimeJobEnroll.class);
			baseparttimejobenrollService.delBaseParttimeJobEnrollById(de);
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
	*根据主键查询兼职报名信息
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseParttimeJobEnrollById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseParttimeJobEnroll bean = baseparttimejobenrollService.getBaseParttimeJobEnrollById(id);
		return JsonUtils.obj2json(bean);
	}
	/**
	*修改录用状态
	**/
	@RequestMapping(value = "/base/BaseParttimeJobEnroll/changeState", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String changeState(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			String state = request.getParameter("state");
			if(null==state||"".equals(state)){
				throw new ServiceException("参数的值不符合要求");
			}
			List de=JsonUtils.json2list(delRows, BaseParttimeJobEnroll.class);
			baseparttimejobenrollService.changeState(de,state);
			rd.setCode(ResultData.code_success);
			rd.setName("录用成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("录用失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
}