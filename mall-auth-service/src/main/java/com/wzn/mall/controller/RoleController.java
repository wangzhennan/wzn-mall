package com.wzn.mall.controller;

import com.wzn.mall.entity.Role;
import com.wzn.mall.service.RoleService;
import com.wzn.mall.entity.vo.RoleVo;
import com.wzn.mall.entity.dto.RoleDto;
import com.wzn.mall.controller.feign.RoleFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-12 16:53:06
 */
@RestController
@RequestMapping("role")
@Api(tags = "(Role)服务") 
public class RoleController implements RoleFeignService{
   
    @Resource
    private RoleService roleService;
 
    @Override
    public RoleVo queryRoleById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.roleService.queryRoleById(id);
    }
    
    @Override
    public List<RoleVo> queryRoleByConditionPage(Object object,int pageNum, int pageSize){
        return this.roleService.queryRoleByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<RoleVo> queryRoleByCondition(Object object){
        return this.roleService.queryRoleByCondition(object);
    }

    @Override
    public RoleVo add(RoleDto roleDto){
        return this.roleService.add(roleDto);
    }

    @Override
    public boolean edit(RoleDto roleDto){
        return this.roleService.edit(roleDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.roleService.deleteById(id);
    }

}