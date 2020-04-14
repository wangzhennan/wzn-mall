package com.wzn.mall.controller;

import com.wzn.mall.entity.dto.ResourceCategoryDto;
import com.wzn.mall.entity.vo.ResourceCategoryVo;
import com.wzn.mall.feign.ResourceCategoryFeignService;
import com.wzn.mall.service.ResourceCategoryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
@RestController
@Api(value = "资源类型",tags = "资源类型")
public class ResourceCategoryController implements ResourceCategoryFeignService{
   
    @Resource
    private ResourceCategoryService resourceCategoryService;
 
    @Override
    public ResourceCategoryVo queryResourceCategoryById(Long id) {
        return this.resourceCategoryService.queryResourceCategoryById(id);
    }
    
    @Override
    public List<ResourceCategoryVo> queryResourceCategoryByConditionPage(Object object,int pageNum, int pageSize){
        return this.resourceCategoryService.queryResourceCategoryByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<ResourceCategoryVo> queryResourceCategoryByCondition(Object object){
        return this.resourceCategoryService.queryResourceCategoryByCondition(object);
    }

    @Override
    public ResourceCategoryVo add(ResourceCategoryDto resourceCategoryDto){
        return this.resourceCategoryService.add(resourceCategoryDto);
    }

    @Override
    public boolean edit(ResourceCategoryDto resourceCategoryDto){
        return this.resourceCategoryService.edit(resourceCategoryDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.resourceCategoryService.deleteById(id);
    }

}