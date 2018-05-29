package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseAccount;
import org.sky.base.model.BaseAccountExample;

public interface BaseAccountMapper {
    long countByExample(BaseAccountExample example);

    int deleteByExample(BaseAccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseAccount record);

    int insertSelective(BaseAccount record);

    List<BaseAccount> selectByExample(BaseAccountExample example);

    BaseAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseAccount record, @Param("example") BaseAccountExample example);

    int updateByExample(@Param("record") BaseAccount record, @Param("example") BaseAccountExample example);

    int updateByPrimaryKeySelective(BaseAccount record);

    int updateByPrimaryKey(BaseAccount record);
}