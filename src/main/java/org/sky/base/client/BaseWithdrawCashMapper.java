package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseWithdrawCash;
import org.sky.base.model.BaseWithdrawCashExample;

public interface BaseWithdrawCashMapper {
    long countByExample(BaseWithdrawCashExample example);

    int deleteByExample(BaseWithdrawCashExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseWithdrawCash record);

    int insertSelective(BaseWithdrawCash record);

    List<BaseWithdrawCash> selectByExample(BaseWithdrawCashExample example);

    BaseWithdrawCash selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseWithdrawCash record, @Param("example") BaseWithdrawCashExample example);

    int updateByExample(@Param("record") BaseWithdrawCash record, @Param("example") BaseWithdrawCashExample example);

    int updateByPrimaryKeySelective(BaseWithdrawCash record);

    int updateByPrimaryKey(BaseWithdrawCash record);
}