package org.sky.bigscreen.action;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/** 
 * @ClassName: BigScreenController 
 * @Description: TODO(首页) 
 * @author weifengxiang911@163.com
 * @date 2017-5-12 上午11:25:02 
 * @version V1.0 
 */
@Controller  
public class BigScreenController {
	@RequestMapping(value = "/bigscreen/demo", method = { RequestMethod.GET })
	public ModelAndView demo(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/demo");
		return mv;
	}
	
	@RequestMapping(value = "/bigscreen/index", method = { RequestMethod.GET })
	public ModelAndView index(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/index");
		return mv;
	}
	@RequestMapping(value = "/bigscreen/index1", method = { RequestMethod.GET })
	public ModelAndView index1(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/index1");
		return mv;
	}
	@RequestMapping(value = "/bigscreen/index2", method = { RequestMethod.GET })
	public ModelAndView index2(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/index2");
		return mv;
	}
	@RequestMapping(value = "/bigscreen/index3", method = { RequestMethod.GET })
	public ModelAndView index3(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/index3");
		return mv;
	}
	@RequestMapping(value = "/bigscreen/index4", method = { RequestMethod.GET })
	public ModelAndView index4(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/index4");
		return mv;
	}
	@RequestMapping(value = "/bigscreen/index5", method = { RequestMethod.GET })
	public ModelAndView index5(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/index5");
		return mv;
	}
	@RequestMapping(value = "/bigscreen/index6", method = { RequestMethod.GET })
	public ModelAndView index6(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();	 
		mv.setViewName("jsp/bigscreen/index6");
		return mv;
	}
}


