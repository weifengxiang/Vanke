package org.sky.app.service;

import java.util.List;

import org.sky.sys.client.SysUserMapper;
import org.sky.sys.model.SysUser;
import org.sky.sys.model.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @ClassName:  AppSysService   
 * @Description:TODO(App系统服务层)   
 * @author: weifx 
 * @date:   2018年4月11日 下午11:26:31   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Service
public class AppSysService {
	@Autowired
	public SysUserMapper sysUserMapper;
	/**
	 * 根据登录编号获取用户信息
	 * @param code
	 * @return
	 */
	public SysUser getSysUserByCode(String code) {
		SysUserExample sue = new SysUserExample();
		sue.createCriteria().andCodeEqualTo(code);
		List<SysUser> list = sysUserMapper.selectByExample(sue);
		if(list.size()==1) {
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * 根据主键获取用户信息
	 * @param userid
	 * @return
	 */
	public SysUser getSysUserById(String userid) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectByPrimaryKey(userid);
	}
	/**
	 * 根据查询条件获取用户列表
	 * @param auExample
	 * @return
	 */
	public List<SysUser> listSysUserByExample(SysUserExample auExample) {
		// TODO Auto-generated method stub
		List<SysUser> list = sysUserMapper.selectByExample(auExample);
		return list;
	}

}
