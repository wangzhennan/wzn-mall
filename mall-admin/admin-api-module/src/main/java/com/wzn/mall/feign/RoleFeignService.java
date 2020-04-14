package com.wzn.mall.feign;

import com.wzn.mall.Apis;
import com.wzn.mall.entity.dto.RoleDto;
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
    List<RoleVo> queryRoleByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping(Apis.ROLE_QUERY_CONDITION)
    List<RoleVo> queryRoleByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping(Apis.ROLE_ADD)
    RoleVo add(@RequestBody RoleDto roleDto);

    @ApiOperation(value = "修改")
    @PostMapping(Apis.ROLE_EDIT)
    boolean edit(@RequestBody RoleDto roleDto);

    @ApiOperation(value = "删除")
    @PostMapping(Apis.ROLE_DEL)
    boolean deleteById(Long id);

}