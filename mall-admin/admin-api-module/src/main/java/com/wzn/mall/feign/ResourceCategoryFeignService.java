package com.wzn.mall.feign;

import com.wzn.mall.entity.dto.ResourceCategoryDto;
import com.wzn.mall.entity.vo.ResourceCategoryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * feign服务
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
public interface ResourceCategoryFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/ResourceCategory/detals")
    ResourceCategoryVo queryResourceCategoryById(@RequestParam("id") Long id);
   
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