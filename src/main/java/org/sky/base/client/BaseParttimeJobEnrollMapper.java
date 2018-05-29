package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseParttimeJobEnroll;
import org.sky.base.model.BaseParttimeJobEnrollExample;

public interface BaseParttimeJobEnrollMapper {
    long countByExample(BaseParttimeJobEnrollExample example);

    int deleteByExample(BaseParttimeJobEnrollExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseParttimeJobEnroll record);

    int insertSelective(BaseParttimeJobEnroll record);

    List<BaseParttimeJobEnroll> selectByExample(BaseParttimeJobEnrollExample example);

    BaseParttimeJobEnroll selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseParttimeJobEnroll record, @Param("example") BaseParttimeJobEnrollExample example);

    int updateByExample(@Param("record") BaseParttimeJobEnroll record, @Param("example") BaseParttimeJobEnrollExample example);

    int updateByPrimaryKeySelective(BaseParttimeJobEnroll record);

    int updateByPrimaryKey(BaseParttimeJobEnroll record);
}