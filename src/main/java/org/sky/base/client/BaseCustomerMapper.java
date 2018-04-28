package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseCustomer;
import org.sky.base.model.BaseCustomerExample;

public interface BaseCustomerMapper {
    long countByExample(BaseCustomerExample example);

    int deleteByExample(BaseCustomerExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseCustomer record);

    int insertSelective(BaseCustomer record);

    List<BaseCustomer> selectByExample(BaseCustomerExample example);

    BaseCustomer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseCustomer record, @Param("example") BaseCustomerExample example);

    int updateByExample(@Param("record") BaseCustomer record, @Param("example") BaseCustomerExample example);

    int updateByPrimaryKeySelective(BaseCustomer record);

    int updateByPrimaryKey(BaseCustomer record);
}