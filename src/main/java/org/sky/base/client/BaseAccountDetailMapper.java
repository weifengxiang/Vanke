package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BaseAccountDetail;
import org.sky.base.model.BaseAccountDetailExample;

public interface BaseAccountDetailMapper {
    long countByExample(BaseAccountDetailExample example);

    int deleteByExample(BaseAccountDetailExample example);

    int insert(BaseAccountDetail record);

    int insertSelective(BaseAccountDetail record);

    List<BaseAccountDetail> selectByExample(BaseAccountDetailExample example);

    int updateByExampleSelective(@Param("record") BaseAccountDetail record, @Param("example") BaseAccountDetailExample example);

    int updateByExample(@Param("record") BaseAccountDetail record, @Param("example") BaseAccountDetailExample example);
}