package org.sky.miniapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.utils.AppConst;
import org.sky.app.utils.ResultData;
import org.sky.miniapp.service.MiniBasePhoneVerficationService;
import org.sky.miniapp.utils.MiniAppUtils;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MiniBasePhoneVerficationController 
 * @Description: TODO(短信验证码接口) 
 * @author AK
 * @date 2018-5-9 下午9:27:36 
 *
 */
@RestController
public class MiniBasePhoneVerficationController {
	
	private Logger logger = Logger.getLogger(MiniBasePhoneVerficationController.class); 
	@Autowired
	private MiniBasePhoneVerficationService miniBasePhoneVerficationService;
	
	/**
	 * 获取短信验证码
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/miniapp/basephoneverification/getCode/{phoneNum}",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData tokenLogin(@PathVariable("phoneNum") String phoneNum, HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		try {
			if(StringUtils.isNull(phoneNum)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setResult(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			String vCode = miniBasePhoneVerficationService.getVerficationCode(phoneNum);
			rd.setCode(AppConst.SUCCESS);
			rd.setResult(vCode);
			return rd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			rd.setCode(AppConst.SYS_ERROR);
			rd.setResult(AppConst.SYS_ERROR_DESCRIPTION);
			return rd;
		}
	}

}
