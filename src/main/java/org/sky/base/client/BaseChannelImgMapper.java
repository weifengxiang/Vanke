package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseChannelImg;
import org.sky.base.model.BaseChannelImgExample;
import org.sky.base.model.BaseChannelImgWithBLOBs;

public interface BaseChannelImgMapper {
    long countByExample(BaseChannelImgExample example);

    int deleteByExample(BaseChannelImgExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseChannelImgWithBLOBs record);

    int insertSelective(BaseChannelImgWithBLOBs record);

    List<BaseChannelImgWithBLOBs> selectByExampleWithBLOBs(BaseChannelImgExample example);

    List<BaseChannelImg> selectByExample(BaseChannelImgExample example);

    BaseChannelImgWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseChannelImgWithBLOBs record, @Param("example") BaseChannelImgExample example);

    int updateByExampleWithBLOBs(@Param("record") BaseChannelImgWithBLOBs record, @Param("example") BaseChannelImgExample example);

    int updateByExample(@Param("record") BaseChannelImg record, @Param("example") BaseChannelImgExample example);

    int updateByPrimaryKeySelective(BaseChannelImgWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BaseChannelImgWithBLOBs record);

    int updateByPrimaryKey(BaseChannelImg record);
}