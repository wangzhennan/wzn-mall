package com.wzn.mall.mapper;

import com.wzn.mall.entity.PermissionApiResourceRelation;
import com.wzn.mall.entity.PermissionApiResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PermissionApiResourceRelationMapper extends Mapper<PermissionApiResourceRelation>, MySqlMapper<PermissionApiResourceRelation> {
    int countByExample(PermissionApiResourceRelationExample example);

    int deleteByExample(PermissionApiResourceRelationExample example);

    List<PermissionApiResourceRelation> selectByExample(PermissionApiResourceRelationExample example);

    int updateByExampleSelective(@Param("record") PermissionApiResourceRelation record, @Param("example") PermissionApiResourceRelationExample example);

    int updateByExample(@Param("record") PermissionApiResourceRelation record, @Param("example") PermissionApiResourceRelationExample example);
}