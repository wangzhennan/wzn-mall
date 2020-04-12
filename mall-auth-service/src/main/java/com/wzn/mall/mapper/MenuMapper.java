package com.wzn.mall.mapper;

import com.wzn.mall.entity.Menu;
import com.wzn.mall.entity.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MenuMapper extends Mapper<Menu>, MySqlMapper<Menu> {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    List<Menu> selectByExample(MenuExample example);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);
}