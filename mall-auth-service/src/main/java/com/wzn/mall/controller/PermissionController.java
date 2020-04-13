package com.wzn.mall.controller;

import com.wzn.mall.entity.Permission;
import com.wzn.mall.service.PermissionService;
import com.wzn.mall.entity.vo.PermissionVo;
import com.wzn.mall.entity.dto.PermissionDto;
import com.wzn.mall.controller.feign.PermissionFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-13 19:16:39
 */
@RestController
@RequestMapping("permission")
@Api(tags = "(Permission)服务") 
public class PermissionController implements PermissionFeignService{
   
    @Resource
    private PermissionService permissionService;
 
    @Override
    public PermissionVo queryPermissionById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.permissionService.queryPermissionById(id);
    }
    
    @Override
    public List<PermissionVo> queryPermissionByConditionPage(Object object,int pageNum, int pageSize){
        return this.permissionService.queryPermissionByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<PermissionVo> queryPermissionByCondition(Object object){
        return this.permissionService.queryPermissionByCondition(object);
    }

    @Override
    public PermissionVo add(PermissionDto permissionDto){
        return this.permissionService.add(permissionDto);
    }

    @Override
    public boolean edit(PermissionDto permissionDto){
        return this.permissionService.edit(permissionDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.permissionService.deleteById(id);
    }

}