package org.sky.base.service;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;

import org.sky.base.client.BaseCodeMapper;
import org.sky.base.model.BaseCode;
import org.sky.base.model.BaseCodeExample;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @ClassName:  BaseCodeService   
 * @Description:TODO(业务编号服务层)   
 * @author: weifx 
 * @date:   2018年5月11日 下午2:58:47   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Service
public class BaseCodeService {
	@Autowired
	private BaseCodeMapper baseCodeMapper;
	@Autowired
	private SysCommonMapper comMapper;
	/**
	 * 获取业务编号
	 * @param biz
	 * @return
	 */
	@Transactional
	public synchronized String getNextBizCode(String biz) {
		long code=1;
		DecimalFormat df = new DecimalFormat("#00000");
		BaseCodeExample e = new BaseCodeExample();
		e.createCriteria().andBizEqualTo(biz);
		List<BaseCode> list = baseCodeMapper.selectByExample(e);
		Timestamp ts = comMapper.queryTimestamp();
		if(list.size()==0||list.isEmpty()) {
			BaseCode bc = new BaseCode();
			bc.setId(CommonUtils.getUUID(32));
			bc.setBiz(biz);
			bc.setCode(new Long(code));
			bc.setCreateTime(ts);
			bc.setUpdateTime(ts);
			baseCodeMapper.insert(bc);
			return biz+df.format(code);
		}else {
			BaseCode bc = list.get(0);
			code = bc.getCode();
			bc.setCode(code+1);
			bc.setUpdateTime(ts);
			baseCodeMapper.updateByPrimaryKey(bc);
			return biz+df.format(code);
		}
	}

}
