package com.wzn.mall.controller.feign;

import com.wzn.mall.entity.vo.ResourceCategoryVo;
import com.wzn.mall.entity.dto.ResourceCategoryDto;
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
public interface ResourceCategoryFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/ResourceCategory/detals")
    ResourceCategoryVo queryResourceCategoryById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/ResourceCategory/queryPage")
    List<ResourceCategoryVo> queryResourceCategoryByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/ResourceCategory/query")
    List<ResourceCategoryVo> queryResourceCategoryByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/ResourceCategory/add")
    ResourceCategoryVo add(@RequestBody ResourceCategoryDto resourceCategoryDto);

    @ApiOperation(value = "修改")
    @PostMapping("/ResourceCategory/edit")
    boolean edit(@RequestBody ResourceCategoryDto resourceCategoryDto);

    @ApiOperation(value = "删除")
    @PostMapping("/ResourceCategory/del")
    boolean deleteById(Long id);

}