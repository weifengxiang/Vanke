package org.sky.sys.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.sys.model.SysArea;
import org.sky.sys.model.SysAreaExample;
import org.sky.sys.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: SysAreaController 
 * @Description: TODO(地区级联查询) 
 * @author AK
 * @date 2018-5-4 下午8:27:23 
 *
 */
@Controller
public class SysAreaController extends BaseController{
	
	@Autowired
	private SysAreaService sysAreaService;
	
	/**
	 * 根据上级地区id获取下级地区列表
	 * @param pid
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/sys/SysArea/listSysAreaByPid/{pid}",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List<SysArea> listSysAreaByPid(@PathVariable("pid") String pid, HttpServletRequest request,HttpServletResponse response){
		SysAreaExample example = new SysAreaExample();
		example.createCriteria().andPidEqualTo(pid);
		example.setOrderByClause("id asc");
		List<SysArea> list = sysAreaService.listSysAreaByExample(example);
		return list;
	}

}
