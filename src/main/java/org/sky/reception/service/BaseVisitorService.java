package org.sky.reception.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.reception.client.BaseVisitorMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.reception.model.BaseVisitor;
import org.sky.reception.model.BaseVisitorExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class BaseVisitorService {
	private final Logger logger=Logger.getLogger(BaseVisitorService.class);
	@Autowired
	private BaseVisitorMapper basevisitormapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getBaseVisitorByPage(BaseVisitorExample ep){
		long totalCount = basevisitormapper.countByExample(ep);
		List list = basevisitormapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveBaseVisitor(List<BaseVisitor> addlist,
			List<BaseVisitor> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(BaseVisitor add:addlist){
					basevisitormapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(BaseVisitor update:updatelist){
					basevisitormapper.updateByPrimaryKeySelective(update);
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
	public void saveAddBaseVisitor(BaseVisitor add) throws ServiceException{
		try{
			basevisitormapper.insertSelective(add);
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
	public void saveAddEditBaseVisitor(BaseVisitor edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				basevisitormapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				basevisitormapper.updateByPrimaryKeySelective(edit);
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
	public void delBaseVisitorById(List<BaseVisitor> delList){
		for(BaseVisitor del:delList){
			basevisitormapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public BaseVisitor getBaseVisitorById(String id){
		BaseVisitor bean = basevisitormapper.selectByPrimaryKey(id);
		return bean;
	}
}