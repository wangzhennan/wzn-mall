package com.wzn.mall.feign;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.Apis;
import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.dto.RoleDto;
import com.wzn.mall.entity.dto.RoleQueryParam;
import com.wzn.mall.entity.vo.RoleVo;
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
public interface RoleFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping(Apis.ROLE_DETALS)
    RoleVo queryRoleById(@RequestParam("id") Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping(Apis.ROLE_QUERY_PAGE)
    PageInfo<List<RoleVo>> queryRoleByConditionPage(@RequestBody RoleQueryParam paramp);

    @ApiOperation(value = "根据条件查询")
    @PostMapping(Apis.ROLE_QUERY_CONDITION)
    ResultModel<List<RoleVo>> queryRoleByCondition(@RequestBody RoleQueryParam paramp);

    @ApiOperation(value = "添加")
    @PostMapping(Apis.ROLE_ADD)
    ResultModel<RoleVo> add(@RequestBody RoleDto roleDto);

    @ApiOperation(value = "修改")
    @PostMapping(Apis.ROLE_EDIT)
    ResultModel<Boolean> edit(@RequestBody RoleDto roleDto);

    @ApiOperation(value = "删除")
    @PostMapping(Apis.ROLE_DEL)
    ResultModel<Boolean> deleteById(Long id);

    @ApiOperation(value = "添加权限")
    @PostMapping(Apis.ROLE_BINDING_PERMISSION)
    ResultModel<Boolean> addPermission(BindingObjectDto bindingObjectDto);

}