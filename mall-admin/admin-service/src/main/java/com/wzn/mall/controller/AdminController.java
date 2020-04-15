package com.wzn.mall.controller;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.AdminDto;
import com.wzn.mall.entity.dto.AdminQueryParam;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.vo.AdminVo;
import com.wzn.mall.error.SysErrorCode;
import com.wzn.mall.feign.AdminFeignService;
import com.wzn.mall.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@RestController
@Api(tags = "管理员")
public class AdminController implements AdminFeignService {
   
    @Resource
    private AdminService adminService;

    @Override
    public ResultModel<AdminVo> queryAdminById(Long id) {
        return ResultModel.success(adminService.queryAdminById(id));
    }

    @Override
    public ResultModel<PageInfo<List<AdminVo>>> queryAdminByConditionPage(@RequestBody AdminQueryParam param) {
        return ResultModel.success(adminService.queryAdminByConditionPage(param));
    }

    @Override
    public ResultModel<List<AdminVo>> queryAdminByCondition(@RequestBody AdminQueryParam param) {
        return ResultModel.success(adminService.queryAdminByCondition(param));
    }

    @Override
    public ResultModel<AdminVo> add(AdminDto adminDto) {
        return ResultModel.success(adminService.add(adminDto));
    }

    @Override
    public ResultModel<Boolean> edit(AdminDto adminDto) {
         if(adminService.edit(adminDto)){
             return ResultModel.success();
        }else {
             return ResultModel.error(SysErrorCode.EDIT_ERROR);
         }
    }

    @Override
    public ResultModel<Boolean> deleteById(Long id) {
        if(adminService.deleteById(id)){
            return ResultModel.success();
        } else {
            return ResultModel.error(SysErrorCode.DEL_ERROR);
        }
    }

    @Override
    public ResultModel<Boolean> adminAddRole(BindingObjectDto objectdto) {
        if(adminService.adminAddRole(objectdto)){
            return ResultModel.success();
        }else{
            return ResultModel.error(SysErrorCode.ADD_ERROR);
        }
    }
}