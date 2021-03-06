package org.sky.sys.service;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.client.SysDictItemMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysDictItem;
import org.sky.sys.model.SysDictItemExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class SysDictItemService {
	private final Logger logger=Logger.getLogger(SysDictItemService.class);
	@Autowired
	private SysDictItemMapper sysdictitemmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getSysDictItemByPage(SysDictItemExample ep){
		long totalCount = sysdictitemmapper.countByExample(ep);
		List list = sysdictitemmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveSysDictItem(List<SysDictItem> addlist,
			List<SysDictItem> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(SysDictItem add:addlist){
					sysdictitemmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(SysDictItem update:updatelist){
					sysdictitemmapper.updateByPrimaryKeySelective(update);
				}
			}
		}catch(Exception e){
			logger.error(e);
			if(e.getMessage().contains("的值太大")){
				throw new ServiceException("输入的字段值过长！");
			}
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*保存添加单个对象
	**/
	@Transactional
	public void saveAddSysDictItem(SysDictItem add) throws ServiceException{
		try{
			sysdictitemmapper.insertSelective(add);
		}catch(Exception e){
			logger.error(e);
			if(e.getMessage().contains("违反唯一约束条件")){
				throw new ServiceException("违反唯一约束条件");
			}else{
				throw new ServiceException(e.getMessage());
			}
		}
	}
	/**
	*保存新增/编辑单个对象
	**/
	@Transactional
	public void saveAddEditSysDictItem(SysDictItem edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				sysdictitemmapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				sysdictitemmapper.updateByPrimaryKeySelective(edit);
			}
		}catch(Exception e){
			logger.error(e);
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*根据主键批量删除对象
	**/
	@Transactional
	public void delSysDictItemById(List<SysDictItem> delList){
		for(SysDictItem del:delList){
			sysdictitemmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public SysDictItem getSysDictItemById(String id){
		SysDictItem bean = sysdictitemmapper.selectByPrimaryKey(id);
		return bean;
	}
}