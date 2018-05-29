package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseMsg;
import org.sky.base.model.BaseMsgExample;

public interface BaseMsgMapper {
    long countByExample(BaseMsgExample example);

    int deleteByExample(BaseMsgExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseMsg record);

    int insertSelective(BaseMsg record);

    List<BaseMsg> selectByExample(BaseMsgExample example);

    BaseMsg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseMsg record, @Param("example") BaseMsgExample example);

    int updateByExample(@Param("record") BaseMsg record, @Param("example") BaseMsgExample example);

    int updateByPrimaryKeySelective(BaseMsg record);

    int updateByPrimaryKey(BaseMsg record);
}