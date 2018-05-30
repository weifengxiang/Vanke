package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseMsg;
import org.sky.base.model.BaseMsgExample;
import org.sky.base.model.BaseMsgExample.Criteria;
import org.sky.base.service.BaseMsgService;
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
public class BaseMsgController extends BaseController{
	@Autowired
	private BaseMsgService basemsgService;
	
	public BaseMsgController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示我的消息列表页面
	**/
	@RequestMapping(value = "/base/BaseMsg/initBaseMsgListPage", method = { RequestMethod.GET })
	public String initBaseMsgListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/msg/listbasemsg";
	}
	/**
	 * 我的消息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseMsg/getBaseMsgByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseMsgByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseMsgExample pote= new BaseMsgExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = basemsgService.getBaseMsgByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示我的消息新增页面
	**/
	@RequestMapping(value = "/base/BaseMsg/initAddBaseMsgPage", method = { RequestMethod.GET })
	public String initAddBaseMsgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/msg/editbasemsg";
	}
	/**
	*显示我的消息修改页面
	**/
	@RequestMapping(value = "/base/BaseMsg/initEditBaseMsgPage", method = { RequestMethod.GET })
	public String initEditBaseMsgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/msg/editbasemsg";
	}
	/**
	*显示我的消息详细页面
	**/
	@RequestMapping(value = "/base/BaseMsg/initDetailBaseMsgPage", method = { RequestMethod.GET })
	public String initDetailBaseMsgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/msg/detailbasemsg";
	}
	/**
	*保存新增/修改我的消息
	**/
	@RequestMapping(value = "/base/BaseMsg/saveAddEditBaseMsg", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseMsg(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseMsg edit = (BaseMsg) getEntityBean(request,BaseMsg.class);
			basemsgService.saveAddEditBaseMsg(edit);
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
	*删除我的消息
	**/
	@RequestMapping(value = "/base/BaseMsg/delBaseMsg", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseMsg(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseMsg.class);
			basemsgService.delBaseMsgById(de);
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
	*根据主键查询我的消息
	**/
	@RequestMapping(value = "/base/BaseMsg/getBaseMsgById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseMsgById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseMsg bean = basemsgService.getBaseMsgById(id);
		return JsonUtils.obj2json(bean);
	}
}