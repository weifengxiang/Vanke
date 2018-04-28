package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;

public interface BaseChannelMapper {
    long countByExample(BaseChannelExample example);

    int deleteByExample(BaseChannelExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseChannel record);

    int insertSelective(BaseChannel record);

    List<BaseChannel> selectByExample(BaseChannelExample example);

    BaseChannel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseChannel record, @Param("example") BaseChannelExample example);

    int updateByExample(@Param("record") BaseChannel record, @Param("example") BaseChannelExample example);

    int updateByPrimaryKeySelective(BaseChannel record);

    int updateByPrimaryKey(BaseChannel record);
}