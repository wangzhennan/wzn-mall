package com.wzn.mall.mapper;

import com.wzn.mall.entity.ManagerLog;
import com.wzn.mall.entity.ManagerLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ManagerLogMapper extends Mapper<ManagerLog>, MySqlMapper<ManagerLog> {
    int countByExample(ManagerLogExample example);

    int deleteByExample(ManagerLogExample example);

    List<ManagerLog> selectByExample(ManagerLogExample example);

    int updateByExampleSelective(@Param("record") ManagerLog record, @Param("example") ManagerLogExample example);

    int updateByExample(@Param("record") ManagerLog record, @Param("example") ManagerLogExample example);
}