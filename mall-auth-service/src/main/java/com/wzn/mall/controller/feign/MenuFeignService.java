package com.wzn.mall.controller.feign;

import com.wzn.mall.entity.vo.MenuVo;
import com.wzn.mall.entity.dto.MenuDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-12 16:53:06
 */
public interface MenuFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/Menu/detals")
    MenuVo queryMenuById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/Menu/queryPage")
    List<MenuVo> queryMenuByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/Menu/query")
    List<MenuVo> queryMenuByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/Menu/add")
    MenuVo add(@RequestBody MenuDto menuDto);

    @ApiOperation(value = "修改")
    @PostMapping("/Menu/edit")
    boolean edit(@RequestBody MenuDto menuDto);

    @ApiOperation(value = "删除")
    @PostMapping("/Menu/del")
    boolean deleteById(Long id);

}