package com.wzn.mall.controller.feign;

import com.wzn.mall.entity.vo.RoleVo;
import com.wzn.mall.entity.dto.RoleDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
public interface RoleFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/Role/detals")
    RoleVo queryRoleById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/Role/queryPage")
    List<RoleVo> queryRoleByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/Role/query")
    List<RoleVo> queryRoleByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/Role/add")
    RoleVo add(@RequestBody RoleDto roleDto);

    @ApiOperation(value = "修改")
    @PostMapping("/Role/edit")
    boolean edit(@RequestBody RoleDto roleDto);

    @ApiOperation(value = "删除")
    @PostMapping("/Role/del")
    boolean deleteById(Long id);

}