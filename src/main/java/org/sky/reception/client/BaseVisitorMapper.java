package org.sky.reception.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.reception.model.BaseVisitor;
import org.sky.reception.model.BaseVisitorExample;

public interface BaseVisitorMapper {
    long countByExample(BaseVisitorExample example);

    int deleteByExample(BaseVisitorExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseVisitor record);

    int insertSelective(BaseVisitor record);

    List<BaseVisitor> selectByExample(BaseVisitorExample example);

    BaseVisitor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseVisitor record, @Param("example") BaseVisitorExample example);

    int updateByExample(@Param("record") BaseVisitor record, @Param("example") BaseVisitorExample example);

    int updateByPrimaryKeySelective(BaseVisitor record);

    int updateByPrimaryKey(BaseVisitor record);
}