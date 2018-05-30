package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseBankCard;
import org.sky.base.model.BaseBankCardExample;
import org.sky.base.model.BaseBankCardExample.Criteria;
import org.sky.base.service.BaseBankCardService;
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
public class BaseBankCardController extends BaseController{
	@Autowired
	private BaseBankCardService basebankcardService;
	
	public BaseBankCardController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示银行卡信息列表页面
	**/
	@RequestMapping(value = "/base/BaseBankCard/initBaseBankCardListPage", method = { RequestMethod.GET })
	public String initBaseBankCardListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/bankcard/listbasebankcard";
	}
	/**
	 * 银行卡信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseBankCard/getBaseBankCardByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseBankCardByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseBankCardExample pote= new BaseBankCardExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = basebankcardService.getBaseBankCardByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示银行卡信息新增页面
	**/
	@RequestMapping(value = "/base/BaseBankCard/initAddBaseBankCardPage", method = { RequestMethod.GET })
	public String initAddBaseBankCardPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/bankcard/editbasebankcard";
	}
	/**
	*显示银行卡信息修改页面
	**/
	@RequestMapping(value = "/base/BaseBankCard/initEditBaseBankCardPage", method = { RequestMethod.GET })
	public String initEditBaseBankCardPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/bankcard/editbasebankcard";
	}
	/**
	*显示银行卡信息详细页面
	**/
	@RequestMapping(value = "/base/BaseBankCard/initDetailBaseBankCardPage", method = { RequestMethod.GET })
	public String initDetailBaseBankCardPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/bankcard/detailbasebankcard";
	}
	/**
	*保存新增/修改银行卡信息
	**/
	@RequestMapping(value = "/base/BaseBankCard/saveAddEditBaseBankCard", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseBankCard(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseBankCard edit = (BaseBankCard) getEntityBean(request,BaseBankCard.class);
			basebankcardService.saveAddEditBaseBankCard(edit);
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
	*删除银行卡信息
	**/
	@RequestMapping(value = "/base/BaseBankCard/delBaseBankCard", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseBankCard(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseBankCard.class);
			basebankcardService.delBaseBankCardById(de);
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
	*根据主键查询银行卡信息
	**/
	@RequestMapping(value = "/base/BaseBankCard/getBaseBankCardById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseBankCardById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseBankCard bean = basebankcardService.getBaseBankCardById(id);
		return JsonUtils.obj2json(bean);
	}
}