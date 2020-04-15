package com.wzn.mall.controller;

import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.dto.PermissionDto;
import com.wzn.mall.entity.vo.PermissionVo;
import com.wzn.mall.feign.PermissionFeignService;
import com.wzn.mall.service.PermissionService;
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
@Api(tags = "权限")
public class PermissionController implements PermissionFeignService {
   
    @Resource
    private PermissionService permissionService;
 
    @Override
    public ResultModel<PermissionVo> queryPermissionById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return ResultModel.success(this.permissionService.queryPermissionById(id));
    }

    @Override
    public ResultModel<List<PermissionVo>> queryPermissionByConditionPage(Object object, int pageNum, int pageSize) {
        return ResultModel.success(this.permissionService.queryPermissionByConditionPage(object, pageNum, pageSize));
    }

    @Override
    public ResultModel<List<PermissionVo>> queryPermissionByCondition(Object object) {
        return ResultModel.success(this.permissionService.queryPermissionByCondition(object));
    }

    @Override
    public ResultModel<PermissionVo> add(PermissionDto permissionDto) {
        return ResultModel.success(this.permissionService.add(permissionDto));
    }

    @Override
    public ResultModel<Boolean> edit(PermissionDto permissionDto) {
        return ResultModel.success(this.permissionService.edit(permissionDto));
    }

    @Override
    public ResultModel<Boolean> deleteById(Long id) {
        return ResultModel.success(this.permissionService.deleteById(id));
    }

    @Override
    public ResultModel<Boolean> addMenu(BindingObjectDto roleAddObjectdto) {
        return ResultModel.success(false);
    }

    @Override
    public ResultModel<Boolean> addResource(BindingObjectDto roleAddObjectdto) {
        return ResultModel.success(false);
    }
}