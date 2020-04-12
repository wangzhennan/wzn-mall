package com.wzn.mall.mapper;

import com.wzn.mall.entity.RoleMenuRelation;
import com.wzn.mall.entity.RoleMenuRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RoleMenuRelationMapper extends Mapper<RoleMenuRelation>, MySqlMapper<RoleMenuRelation> {
    int countByExample(RoleMenuRelationExample example);

    int deleteByExample(RoleMenuRelationExample example);

    List<RoleMenuRelation> selectByExample(RoleMenuRelationExample example);

    int updateByExampleSelective(@Param("record") RoleMenuRelation record, @Param("example") RoleMenuRelationExample example);

    int updateByExample(@Param("record") RoleMenuRelation record, @Param("example") RoleMenuRelationExample example);
}