package com.wzn.mall.controller;

import com.wzn.mall.entity.dto.RoleDto;
import com.wzn.mall.entity.vo.RoleVo;
import com.wzn.mall.feign.RoleFeignService;
import com.wzn.mall.service.RoleService;
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
@Api(value = "角色",tags = "角色")
public class RoleController implements RoleFeignService{
   
    @Resource
    private RoleService roleService;
 
    @Override
    public RoleVo queryRoleById(Long id) {
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