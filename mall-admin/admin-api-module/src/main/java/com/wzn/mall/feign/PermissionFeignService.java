package com.wzn.mall.feign;

import com.wzn.mall.Apis;
import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.BindingObjectDto;
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
    @GetMapping(Apis.PERM_DETALS)
    ResultModel<PermissionVo> queryPermissionById(@RequestParam("id") Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping(Apis.PERM_QUERY_PAGE)
    ResultModel<List<PermissionVo>> queryPermissionByConditionPage(Object object, int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping(Apis.PERM_QUERY_CONDITION)
    ResultModel<List<PermissionVo>> queryPermissionByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping(Apis.PERM_ADD)
    ResultModel<PermissionVo> add(@RequestBody PermissionDto permissionDto);

    @ApiOperation(value = "修改")
    @PostMapping(Apis.PERM_EDIT)
    ResultModel<Boolean> edit(@RequestBody PermissionDto permissionDto);

    @ApiOperation(value = "删除")
    @PostMapping(Apis.PERM_DEL)
    ResultModel<Boolean> deleteById(Long id);

    @ApiOperation(value = "绑定菜单")
    @PostMapping(Apis.PERM_BINDING_MENU)
    ResultModel<Boolean> addMenu(@RequestBody BindingObjectDto roleAddObjectdto);

    @ApiOperation(value = "邦定资源")
    @PostMapping(Apis.PERM_BINDING)
    ResultModel<Boolean> addResource(@RequestBody BindingObjectDto roleAddObjectdto);
}