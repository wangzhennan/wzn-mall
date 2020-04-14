package com.wzn.mall.mapper;

import com.wzn.mall.entity.ManagerRoleRelation;
import com.wzn.mall.entity.ManagerRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ManagerRoleRelationMapper extends Mapper<ManagerRoleRelation>, MySqlMapper<ManagerRoleRelation> {
    int countByExample(ManagerRoleRelationExample example);

    int deleteByExample(ManagerRoleRelationExample example);

    List<ManagerRoleRelation> selectByExample(ManagerRoleRelationExample example);

    int updateByExampleSelective(@Param("record") ManagerRoleRelation record, @Param("example") ManagerRoleRelationExample example);

    int updateByExample(@Param("record") ManagerRoleRelation record, @Param("example") ManagerRoleRelationExample example);
}