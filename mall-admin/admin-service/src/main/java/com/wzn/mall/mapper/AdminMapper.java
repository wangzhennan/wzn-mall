package com.wzn.mall.mapper;

import com.wzn.mall.entity.Admin;
import com.wzn.mall.entity.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface AdminMapper extends Mapper<Admin>, MySqlMapper<Admin> {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    List<Admin> selectByExample(AdminExample example);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);
}