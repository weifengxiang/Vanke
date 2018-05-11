package org.sky.base.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.base.client.BaseChannelMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class BaseChannelService {
	private final Logger logger=Logger.getLogger(BaseChannelService.class);
	@Autowired
	private BaseChannelMapper basechannelmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	@Autowired
	private BaseCodeService bcService;
	/**
	*分页查询
	**/
	public PageListData getBaseChannelByPage(BaseChannelExample ep){
		long totalCount = basechannelmapper.countByExample(ep);
		List list = basechannelmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveBaseChannel(List<BaseChannel> addlist,
			List<BaseChannel> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(BaseChannel add:addlist){
					basechannelmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(BaseChannel update:updatelist){
					basechannelmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddBaseChannel(BaseChannel add) throws ServiceException{
		try{
			basechannelmapper.insertSelective(add);
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
	public void saveAddEditBaseChannel(BaseChannel edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCode(bcService.getNextBizCode("CHA"));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				basechannelmapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				basechannelmapper.updateByPrimaryKeySelective(edit);
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
	public void delBaseChannelById(List<BaseChannel> delList){
		for(BaseChannel del:delList){
			basechannelmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public BaseChannel getBaseChannelById(String id){
		BaseChannel bean = basechannelmapper.selectByPrimaryKey(id);
		return bean;
	}
}