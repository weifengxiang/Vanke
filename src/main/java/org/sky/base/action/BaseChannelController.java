package org.sky.base.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.base.model.BaseChannelExample.Criteria;
import org.sky.base.model.BaseChannelImgWithBLOBs;
import org.sky.base.service.BaseChannelService;
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
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 
 * @ClassName:  BaseChannelController   
 * @Description:TODO(渠道人才信息管理)   
 * @author: weifx 
 * @date:   2018年4月28日 下午9:46:48   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class BaseChannelController extends BaseController{
	@Autowired
	private BaseChannelService basechannelService;
	
	public BaseChannelController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示渠道人才信息列表页面
	**/
	@RequestMapping(value = "/base/BaseChannel/initBaseChannelListPage", method = { RequestMethod.GET })
	public String initBaseChannelListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/channel/listbasechannel";
	}
	/**
	 * 渠道人才信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseChannel/getBaseChannelByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseChannelByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		BaseChannelExample pote= new BaseChannelExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = basechannelService.getBaseChannelByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示渠道人才信息新增页面
	**/
	@RequestMapping(value = "/base/BaseChannel/initAddBaseChannelPage", method = { RequestMethod.GET })
	public String initAddBaseChannelPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/channel/editbasechannel";
	}
	/**
	*显示渠道人才信息修改页面
	**/
	@RequestMapping(value = "/base/BaseChannel/initEditBaseChannelPage", method = { RequestMethod.GET })
	public String initEditBaseChannelPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/channel/editbasechannel";
	}
	/**
	*显示渠道人才信息详细页面
	**/
	@RequestMapping(value = "/base/BaseChannel/initDetailBaseChannelPage", method = { RequestMethod.GET })
	public String initDetailBaseChannelPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/base/channel/detailbasechannel";
	}
	/**
	*保存新增/修改渠道人才信息
	**/
	@RequestMapping(value = "/base/BaseChannel/saveAddEditBaseChannel", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditBaseChannel(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			BaseChannel edit = (BaseChannel) getEntityBean(request,BaseChannel.class);
			basechannelService.saveAddEditBaseChannel(edit);
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
	*删除渠道人才信息
	**/
	@RequestMapping(value = "/base/BaseChannel/delBaseChannel", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delBaseChannel(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, BaseChannel.class);
			basechannelService.delBaseChannelById(de);
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
	*根据主键查询渠道人才信息
	**/
	@RequestMapping(value = "/base/BaseChannel/getBaseChannelById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseChannelById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		BaseChannel bean = basechannelService.getBaseChannelById(id);
		return JsonUtils.obj2json(bean);
	}
	/**
	 * 获取渠道照片
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/base/BaseChannel/getBaseChannelImgByCode/{code}", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBaseChannelImgByCode(
			@PathVariable String code,
			HttpServletRequest request, 
			HttpServletResponse response){
		BaseChannelImgWithBLOBs bean = basechannelService.getBaseChannelImgByCode(code);
		return JsonUtils.obj2json(bean);
	}
}