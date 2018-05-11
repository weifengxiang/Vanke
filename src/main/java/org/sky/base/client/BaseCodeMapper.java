package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseCode;
import org.sky.base.model.BaseCodeExample;

public interface BaseCodeMapper {
    long countByExample(BaseCodeExample example);

    int deleteByExample(BaseCodeExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseCode record);

    int insertSelective(BaseCode record);

    List<BaseCode> selectByExample(BaseCodeExample example);

    BaseCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseCode record, @Param("example") BaseCodeExample example);

    int updateByExample(@Param("record") BaseCode record, @Param("example") BaseCodeExample example);

    int updateByPrimaryKeySelective(BaseCode record);

    int updateByPrimaryKey(BaseCode record);
}