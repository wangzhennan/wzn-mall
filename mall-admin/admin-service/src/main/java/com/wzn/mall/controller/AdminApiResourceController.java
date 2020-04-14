package com.wzn.mall.controller;

import com.wzn.mall.entity.dto.ApiResourceDto;
import com.wzn.mall.entity.vo.ApiResourceVo;
import com.wzn.mall.feign.ApiResourceFeignService;
import com.wzn.mall.service.ApiResourceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wangzhennan
 * @since 2020-04-14 22:06:22
 */
@RestController
@Api(value = "api资源",tags = "api资源接口")
public class AdminApiResourceController implements ApiResourceFeignService{
   
    @Resource
    private ApiResourceService apiResourceService;
 
    @Override
    public ApiResourceVo queryApiResourceById( Long id) {
        return this.apiResourceService.queryApiResourceById(id);
    }
    
    @Override
    public List<ApiResourceVo> queryApiResourceByConditionPage(Object object,int pageNum, int pageSize){
        return this.apiResourceService.queryApiResourceByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<ApiResourceVo> queryApiResourceByCondition(Object object){
        return this.apiResourceService.queryApiResourceByCondition(object);
    }

    @Override
    public ApiResourceVo add(ApiResourceDto apiResourceDto){
        return this.apiResourceService.add(apiResourceDto);
    }

    @Override
    public boolean edit(ApiResourceDto apiResourceDto){
        return this.apiResourceService.edit(apiResourceDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.apiResourceService.deleteById(id);
    }

}