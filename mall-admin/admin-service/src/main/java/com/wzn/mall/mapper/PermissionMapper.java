package com.wzn.mall.mapper;

import com.wzn.mall.entity.Permission;
import com.wzn.mall.entity.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PermissionMapper extends Mapper<Permission>, MySqlMapper<Permission> {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    List<Permission> selectByExample(PermissionExample example);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);
}