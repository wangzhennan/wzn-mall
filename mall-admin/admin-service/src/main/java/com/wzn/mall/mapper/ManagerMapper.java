package com.wzn.mall.mapper;

import com.wzn.mall.entity.Manager;
import com.wzn.mall.entity.ManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ManagerMapper extends Mapper<Manager>, MySqlMapper<Manager> {
    int countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    List<Manager> selectByExample(ManagerExample example);

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);
}