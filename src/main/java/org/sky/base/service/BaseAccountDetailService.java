package org.sky.base.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.base.client.BaseAccountDetailMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseAccountDetail;
import org.sky.base.model.BaseAccountDetailExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class BaseAccountDetailService {
	private final Logger logger=Logger.getLogger(BaseAccountDetailService.class);
	@Autowired
	private BaseAccountDetailMapper baseaccountdetailmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getBaseAccountDetailByPage(BaseAccountDetailExample ep){
		long totalCount = baseaccountdetailmapper.countByExample(ep);
		List list = baseaccountdetailmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveBaseAccountDetail(List<BaseAccountDetail> addlist,
			List<BaseAccountDetail> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(BaseAccountDetail add:addlist){
					baseaccountdetailmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(BaseAccountDetail update:updatelist){
//					baseaccountdetailmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddBaseAccountDetail(BaseAccountDetail add) throws ServiceException{
		try{
			baseaccountdetailmapper.insertSelective(add);
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
	public void saveAddEditBaseAccountDetail(BaseAccountDetail edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				baseaccountdetailmapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
//				baseaccountdetailmapper.updateByPrimaryKeySelective(edit);
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
	public void delBaseAccountDetailById(List<BaseAccountDetail> delList){
		for(BaseAccountDetail del:delList){
//			baseaccountdetailmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public BaseAccountDetail getBaseAccountDetailById(String id){
//		BaseAccountDetail bean = baseaccountdetailmapper.selectByPrimaryKey(id);
//		return bean;
		return null;
	}
}