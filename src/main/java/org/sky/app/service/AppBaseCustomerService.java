package org.sky.app.service;

import java.util.List;

import org.sky.base.client.BaseCustomerMapper;
import org.sky.base.model.BaseCustomer;
import org.sky.base.model.BaseCustomerExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppBaseCustomerService {
	
	@Autowired
	private BaseCustomerMapper baseCustomerMapper;
	
	/**
	 * 客户分页查询
	 * @param example
	 * @return
	 */
	public PageListData listBaseCustomerByPage(BaseCustomerExample example) {
		// TODO Auto-generated method stub
		long totalCount = baseCustomerMapper.countByExample(example);
		List list = baseCustomerMapper.selectByExample(example);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}

}
