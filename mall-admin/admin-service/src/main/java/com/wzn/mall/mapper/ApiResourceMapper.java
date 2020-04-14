package com.wzn.mall.mapper;

import com.wzn.mall.entity.ApiResource;
import com.wzn.mall.entity.ApiResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ApiResourceMapper extends Mapper<ApiResource>, MySqlMapper<ApiResource> {
    int countByExample(ApiResourceExample example);

    int deleteByExample(ApiResourceExample example);

    List<ApiResource> selectByExample(ApiResourceExample example);

    int updateByExampleSelective(@Param("record") ApiResource record, @Param("example") ApiResourceExample example);

    int updateByExample(@Param("record") ApiResource record, @Param("example") ApiResourceExample example);
}