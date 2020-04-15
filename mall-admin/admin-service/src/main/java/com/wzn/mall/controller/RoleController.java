package com.wzn.mall.controller;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.dto.RoleDto;
import com.wzn.mall.entity.dto.RoleQueryParam;
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
 * @since 2020-04-15 14:51:36
 */
@RestController
@Api(tags = "角色")
public class RoleController implements RoleFeignService {
   
    @Resource
    private RoleService roleService;
 
    @Override
    public RoleVo queryRoleById(Long id) {
        return this.roleService.queryRoleById(id);
    }
    
    @Override
    public PageInfo<List<RoleVo>> queryRoleByConditionPage(RoleQueryParam paramp) {
        return this.roleService.queryRoleByConditionPage(paramp);
    }

    @Override
    public ResultModel<List<RoleVo>> queryRoleByCondition(RoleQueryParam paramp) {
        return ResultModel.success(this.roleService.queryRoleByCondition(paramp));
    }

    @Override
    public ResultModel<RoleVo> add(RoleDto roleDto) {
        return ResultModel.success(this.roleService.add(roleDto));
    }

    @Override
    public ResultModel<Boolean> edit(RoleDto roleDto) {
        return ResultModel.success(this.roleService.edit(roleDto));
    }

    @Override
    public ResultModel<Boolean> deleteById(Long id) {
        return ResultModel.success(this.roleService.deleteById(id));
    }

    @Override
    public ResultModel<Boolean> addPermission(BindingObjectDto bindingObjectDto) {
        return ResultModel.success(roleService.addPermission(bindingObjectDto));
    }
}