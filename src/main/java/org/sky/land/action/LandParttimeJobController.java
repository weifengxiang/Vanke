package org.sky.land.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.land.model.LandParttimeJob;
import org.sky.land.model.LandParttimeJobExample;
import org.sky.land.model.LandParttimeJobExample.Criteria;
import org.sky.land.service.LandParttimeJobService;
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
public class LandParttimeJobController extends BaseController{
	@Autowired
	private LandParttimeJobService landparttimejobService;
	
	public LandParttimeJobController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示兼职任务信息列表页面
	**/
	@RequestMapping(value = "/land/LandParttimeJob/initLandParttimeJobListPage", method = { RequestMethod.GET })
	public String initLandParttimeJobListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/land/parttimejob/listlandparttimejob";
	}
	/**
	 * 兼职任务信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/land/LandParttimeJob/getLandParttimeJobByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getLandParttimeJobByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		LandParttimeJobExample pote= new LandParttimeJobExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = landparttimejobService.getLandParttimeJobByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示兼职任务信息新增页面
	**/
	@RequestMapping(value = "/land/LandParttimeJob/initAddLandParttimeJobPage", method = { RequestMethod.GET })
	public String initAddLandParttimeJobPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/land/parttimejob/editlandparttimejob";
	}
	/**
	*显示兼职任务信息修改页面
	**/
	@RequestMapping(value = "/land/LandParttimeJob/initEditLandParttimeJobPage", method = { RequestMethod.GET })
	public String initEditLandParttimeJobPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/land/parttimejob/editlandparttimejob";
	}
	/**
	*显示兼职任务信息详细页面
	**/
	@RequestMapping(value = "/land/LandParttimeJob/initDetailLandParttimeJobPage", method = { RequestMethod.GET })
	public String initDetailLandParttimeJobPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/land/parttimejob/detaillandparttimejob";
	}
	/**
	*保存新增/修改兼职任务信息
	**/
	@RequestMapping(value = "/land/LandParttimeJob/saveAddEditLandParttimeJob", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditLandParttimeJob(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			LandParttimeJob edit = (LandParttimeJob) getEntityBean(request,LandParttimeJob.class);
			landparttimejobService.saveAddEditLandParttimeJob(edit);
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
	*删除兼职任务信息
	**/
	@RequestMapping(value = "/land/LandParttimeJob/delLandParttimeJob", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delLandParttimeJob(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, LandParttimeJob.class);
			landparttimejobService.delLandParttimeJobById(de);
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
	*根据主键查询兼职任务信息
	**/
	@RequestMapping(value = "/land/LandParttimeJob/getLandParttimeJobById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getLandParttimeJobById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		LandParttimeJob bean = landparttimejobService.getLandParttimeJobById(id);
		return JsonUtils.obj2json(bean);
	}
}