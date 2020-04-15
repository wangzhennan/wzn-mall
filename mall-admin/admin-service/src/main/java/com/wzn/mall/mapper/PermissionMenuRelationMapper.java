package com.wzn.mall.mapper;

import com.wzn.mall.entity.PermissionMenuRelation;
import com.wzn.mall.entity.PermissionMenuRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PermissionMenuRelationMapper extends Mapper<PermissionMenuRelation>, MySqlMapper<PermissionMenuRelation> {
    int countByExample(PermissionMenuRelationExample example);

    int deleteByExample(PermissionMenuRelationExample example);

    List<PermissionMenuRelation> selectByExample(PermissionMenuRelationExample example);

    int updateByExampleSelective(@Param("record") PermissionMenuRelation record, @Param("example") PermissionMenuRelationExample example);

    int updateByExample(@Param("record") PermissionMenuRelation record, @Param("example") PermissionMenuRelationExample example);
}