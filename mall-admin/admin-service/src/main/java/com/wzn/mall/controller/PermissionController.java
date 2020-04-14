package com.wzn.mall.controller;

import com.wzn.mall.entity.dto.PermissionDto;
import com.wzn.mall.entity.vo.PermissionVo;
import com.wzn.mall.feign.PermissionFeignService;
import com.wzn.mall.service.PermissionService;
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
@Api(value = "权限",tags = "权限接口")
public class PermissionController implements PermissionFeignService{
   
    @Resource
    private PermissionService permissionService;
 
    @Override
    public PermissionVo queryPermissionById( Long id) {
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