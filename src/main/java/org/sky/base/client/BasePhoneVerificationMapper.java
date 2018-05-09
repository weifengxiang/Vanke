package org.sky.base.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.base.model.BasePhoneVerification;
import org.sky.base.model.BasePhoneVerificationExample;

public interface BasePhoneVerificationMapper {
    long countByExample(BasePhoneVerificationExample example);

    int deleteByExample(BasePhoneVerificationExample example);

    int deleteByPrimaryKey(String recid);

    int insert(BasePhoneVerification record);

    int insertSelective(BasePhoneVerification record);

    List<BasePhoneVerification> selectByExample(BasePhoneVerificationExample example);

    BasePhoneVerification selectByPrimaryKey(String recid);

    int updateByExampleSelective(@Param("record") BasePhoneVerification record, @Param("example") BasePhoneVerificationExample example);

    int updateByExample(@Param("record") BasePhoneVerification record, @Param("example") BasePhoneVerificationExample example);

    int updateByPrimaryKeySelective(BasePhoneVerification record);

    int updateByPrimaryKey(BasePhoneVerification record);
}