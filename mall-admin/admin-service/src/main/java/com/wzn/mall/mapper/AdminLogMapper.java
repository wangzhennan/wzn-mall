package com.wzn.mall.mapper;

import com.wzn.mall.entity.AdminLog;
import com.wzn.mall.entity.AdminLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface AdminLogMapper extends Mapper<AdminLog>, MySqlMapper<AdminLog> {
    int countByExample(AdminLogExample example);

    int deleteByExample(AdminLogExample example);

    List<AdminLog> selectByExample(AdminLogExample example);

    int updateByExampleSelective(@Param("record") AdminLog record, @Param("example") AdminLogExample example);

    int updateByExample(@Param("record") AdminLog record, @Param("example") AdminLogExample example);
}