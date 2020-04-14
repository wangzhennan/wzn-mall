package com.wzn.mall.mapper;

import com.wzn.mall.entity.ResourceCategory;
import com.wzn.mall.entity.ResourceCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ResourceCategoryMapper extends Mapper<ResourceCategory>, MySqlMapper<ResourceCategory> {
    int countByExample(ResourceCategoryExample example);

    int deleteByExample(ResourceCategoryExample example);

    List<ResourceCategory> selectByExample(ResourceCategoryExample example);

    int updateByExampleSelective(@Param("record") ResourceCategory record, @Param("example") ResourceCategoryExample example);

    int updateByExample(@Param("record") ResourceCategory record, @Param("example") ResourceCategoryExample example);
}