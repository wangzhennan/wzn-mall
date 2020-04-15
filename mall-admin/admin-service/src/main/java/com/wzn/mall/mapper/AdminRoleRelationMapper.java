package com.wzn.mall.mapper;

import com.wzn.mall.entity.AdminRoleRelation;
import com.wzn.mall.entity.AdminRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface AdminRoleRelationMapper extends Mapper<AdminRoleRelation>, MySqlMapper<AdminRoleRelation> {
    int countByExample(AdminRoleRelationExample example);

    int deleteByExample(AdminRoleRelationExample example);

    List<AdminRoleRelation> selectByExample(AdminRoleRelationExample example);

    int updateByExampleSelective(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);

    int updateByExample(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);
}