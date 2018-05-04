package org.sky.sys.service;

import java.util.List;

import org.sky.sys.client.SysAreaMapper;
import org.sky.sys.model.SysArea;
import org.sky.sys.model.SysAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysAreaService {
	
	@Autowired
	private SysAreaMapper sysAreaMapper;

	public List<SysArea> listSysAreaByExample(SysAreaExample example) {
		// TODO Auto-generated method stub
		return sysAreaMapper.selectByExample(example);
	}

}
