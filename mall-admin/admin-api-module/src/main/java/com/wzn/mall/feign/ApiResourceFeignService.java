package com.wzn.mall.feign;

import com.wzn.mall.Apis;
import com.wzn.mall.entity.dto.ApiResourceDto;
import com.wzn.mall.entity.vo.ApiResourceVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 资源feign服务
 * @author wangzhennan
 * @since 2020-04-14 22:06:22
 */
@FeignClient(name = "admin-service")
public interface ApiResourceFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping(Apis.APIRESOURCE_DETALS)
    ApiResourceVo queryApiResourceById(@RequestParam("id") Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping(Apis.APIRESOURCE_QUERY_PAGE)
    List<ApiResourceVo> queryApiResourceByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping(Apis.APIRESOURCE_QUERY_CONDITION)
    List<ApiResourceVo> queryApiResourceByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping(Apis.APIRESOURCE_ADD)
    ApiResourceVo add(@RequestBody ApiResourceDto apiResourceDto);

    @ApiOperation(value = "修改")
    @PostMapping(Apis.APIRESOURCE_EDIT)
    boolean edit(@RequestBody ApiResourceDto apiResourceDto);

    @ApiOperation(value = "删除")
    @PostMapping(Apis.APIRESOURCE_DEL)
    boolean deleteById(Long id);

}