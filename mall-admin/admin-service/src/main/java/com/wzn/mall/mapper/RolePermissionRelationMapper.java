package com.wzn.mall.mapper;

import com.wzn.mall.entity.RolePermissionRelation;
import com.wzn.mall.entity.RolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RolePermissionRelationMapper extends Mapper<RolePermissionRelation>, MySqlMapper<RolePermissionRelation> {
    int countByExample(RolePermissionRelationExample example);

    int deleteByExample(RolePermissionRelationExample example);

    List<RolePermissionRelation> selectByExample(RolePermissionRelationExample example);

    int updateByExampleSelective(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);

    int updateByExample(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);
}