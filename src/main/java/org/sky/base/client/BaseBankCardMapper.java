package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseBankCard;
import org.sky.base.model.BaseBankCardExample;

public interface BaseBankCardMapper {
    long countByExample(BaseBankCardExample example);

    int deleteByExample(BaseBankCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseBankCard record);

    int insertSelective(BaseBankCard record);

    List<BaseBankCard> selectByExample(BaseBankCardExample example);

    BaseBankCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseBankCard record, @Param("example") BaseBankCardExample example);

    int updateByExample(@Param("record") BaseBankCard record, @Param("example") BaseBankCardExample example);

    int updateByPrimaryKeySelective(BaseBankCard record);

    int updateByPrimaryKey(BaseBankCard record);
}