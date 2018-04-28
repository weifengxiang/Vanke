package org.sky.base.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.base.client.BaseCustomerMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseCustomer;
import org.sky.base.model.BaseCustomerExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class BaseCustomerService {
	private final Logger logger=Logger.getLogger(BaseCustomerService.class);
	@Autowired
	private BaseCustomerMapper basecustomermapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getBaseCustomerByPage(BaseCustomerExample ep){
		long totalCount = basecustomermapper.countByExample(ep);
		List list = basecustomermapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveBaseCustomer(List<BaseCustomer> addlist,
			List<BaseCustomer> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(BaseCustomer add:addlist){
					basecustomermapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(BaseCustomer update:updatelist){
					basecustomermapper.updateByPrimaryKeySelective(update);
				}
			}
		}catch(Exception e){
			logger.error("保存列表新增及修改执行失败",e);
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
	public void saveAddBaseCustomer(BaseCustomer add) throws ServiceException{
		try{
			basecustomermapper.insertSelective(add);
		}catch(Exception e){
			logger.error("保存添加单个对象执行失败",e);
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
	public void saveAddEditBaseCustomer(BaseCustomer edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				basecustomermapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				basecustomermapper.updateByPrimaryKeySelective(edit);
			}
		}catch(Exception e){
			logger.error("保存新增/编辑单个对象执行失败",e);
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*根据主键批量删除对象
	**/
	@Transactional
	public void delBaseCustomerById(List<BaseCustomer> delList){
		for(BaseCustomer del:delList){
			basecustomermapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public BaseCustomer getBaseCustomerById(String id){
		BaseCustomer bean = basecustomermapper.selectByPrimaryKey(id);
		return bean;
	}
}