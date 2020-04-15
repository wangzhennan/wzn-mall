package com.wzn.mall.feign;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.Apis;
import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.AdminDto;
import com.wzn.mall.entity.dto.AdminQueryParam;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.vo.AdminVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 管理员feign服务
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
public interface AdminFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping(Apis.MANAGER_DETALS)
    ResultModel<AdminVo> queryAdminById(@RequestParam("id") Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping(Apis.MANAGER_QUERY_PAGE)
    ResultModel<PageInfo<List<AdminVo>>> queryAdminByConditionPage(@RequestBody AdminQueryParam param);

    @ApiOperation(value = "根据条件查询")
    @PostMapping(Apis.MANAGER_QUERY_CONDITION)
    ResultModel<List<AdminVo>> queryAdminByCondition(@RequestBody AdminQueryParam param);

    @ApiOperation(value = "添加")
    @PostMapping(Apis.MANAGER_ADD)
    ResultModel<AdminVo> add(@RequestBody @Validated AdminDto adminDto);

    @ApiOperation(value = "修改")
    @PostMapping(Apis.MANAGER_EDIT)
    ResultModel<Boolean> edit(@RequestBody @Validated AdminDto adminDto);

    @ApiOperation(value = "删除")
    @PostMapping(Apis.MANAGER_DEL)
    ResultModel<Boolean> deleteById(Long id);

    @ApiOperation(value = "绑定角色")
    @PostMapping(Apis.MANAGER_BINDING)
    ResultModel<Boolean> adminAddRole(@RequestBody BindingObjectDto objectdto);

}