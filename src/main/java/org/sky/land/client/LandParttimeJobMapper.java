package org.sky.land.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.land.model.LandParttimeJob;
import org.sky.land.model.LandParttimeJobExample;

public interface LandParttimeJobMapper {
    long countByExample(LandParttimeJobExample example);

    int deleteByExample(LandParttimeJobExample example);

    int deleteByPrimaryKey(String id);

    int insert(LandParttimeJob record);

    int insertSelective(LandParttimeJob record);

    List<LandParttimeJob> selectByExample(LandParttimeJobExample example);

    LandParttimeJob selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LandParttimeJob record, @Param("example") LandParttimeJobExample example);

    int updateByExample(@Param("record") LandParttimeJob record, @Param("example") LandParttimeJobExample example);

    int updateByPrimaryKeySelective(LandParttimeJob record);

    int updateByPrimaryKey(LandParttimeJob record);
}