package com.wzn.mall.mapper;

import com.wzn.mall.entity.ManagerPermissionRelation;
import com.wzn.mall.entity.ManagerPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ManagerPermissionRelationMapper extends Mapper<ManagerPermissionRelation>, MySqlMapper<ManagerPermissionRelation> {
    int countByExample(ManagerPermissionRelationExample example);

    int deleteByExample(ManagerPermissionRelationExample example);

    List<ManagerPermissionRelation> selectByExample(ManagerPermissionRelationExample example);

    int updateByExampleSelective(@Param("record") ManagerPermissionRelation record, @Param("example") ManagerPermissionRelationExample example);

    int updateByExample(@Param("record") ManagerPermissionRelation record, @Param("example") ManagerPermissionRelationExample example);
}