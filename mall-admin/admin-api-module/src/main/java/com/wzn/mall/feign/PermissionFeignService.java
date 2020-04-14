package com.wzn.mall.feign;

import com.wzn.mall.entity.dto.PermissionDto;
import com.wzn.mall.entity.vo.PermissionVo;
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
public interface PermissionFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/Permission/detals")
    PermissionVo queryPermissionById(@RequestParam("id") Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/Permission/queryPage")
    List<PermissionVo> queryPermissionByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/Permission/query")
    List<PermissionVo> queryPermissionByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/Permission/add")
    PermissionVo add(@RequestBody PermissionDto permissionDto);

    @ApiOperation(value = "修改")
    @PostMapping("/Permission/edit")
    boolean edit(@RequestBody PermissionDto permissionDto);

    @ApiOperation(value = "删除")
    @PostMapping("/Permission/del")
    boolean deleteById(Long id);

}