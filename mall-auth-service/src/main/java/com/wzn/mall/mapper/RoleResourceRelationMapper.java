package com.wzn.mall.mapper;

import com.wzn.mall.entity.RoleResourceRelation;
import com.wzn.mall.entity.RoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RoleResourceRelationMapper extends Mapper<RoleResourceRelation>, MySqlMapper<RoleResourceRelation> {
    int countByExample(RoleResourceRelationExample example);

    int deleteByExample(RoleResourceRelationExample example);

    List<RoleResourceRelation> selectByExample(RoleResourceRelationExample example);

    int updateByExampleSelective(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);

    int updateByExample(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);
}