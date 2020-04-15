package com.wzn.mall.controller;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.ApiResourceDto;
import com.wzn.mall.entity.dto.ApisResourceQueryParam;
import com.wzn.mall.entity.vo.ApiResourceVo;
import com.wzn.mall.feign.ApiResourceFeignService;
import com.wzn.mall.service.ApiResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@RestController
@Api(tags = "资源")
public class ApiResourcesController implements ApiResourceFeignService {
   
    @Resource
    private ApiResourceService apiResourceService;
 
    @Override
    public ResultModel<ApiResourceVo> queryApiResourceById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return ResultModel.success(this.apiResourceService.queryApiResourceById(id));
    }
    
    @Override
    public ResultModel<PageInfo<List<ApiResourceVo>>> queryApiResourceByConditionPage(ApisResourceQueryParam apisResourceQueryParam) {
        return ResultModel.success(this.apiResourceService.queryApiResourceByConditionPage(apisResourceQueryParam));
    }

    @Override
    public ResultModel<List<ApiResourceVo>> queryApiResourceByCondition(ApisResourceQueryParam apisResourceQueryParam) {
        return ResultModel.success(this.apiResourceService.queryApiResourceByCondition(apisResourceQueryParam));
    }

    @Override
    public ResultModel<ApiResourceVo> add(ApiResourceDto apiResourceDto){
        return ResultModel.success(this.apiResourceService.add(apiResourceDto));
    }

    @Override
    public ResultModel<Boolean> edit(ApiResourceDto apiResourceDto){
        return ResultModel.success(this.apiResourceService.edit(apiResourceDto));
    }

    @Override
    public ResultModel<Boolean> deleteById(Long id){
       return ResultModel.success(this.apiResourceService.deleteById(id));
    }

}