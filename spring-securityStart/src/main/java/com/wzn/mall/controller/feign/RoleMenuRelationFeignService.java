package com.wzn.mall.feign;

import com.wzn.mall.entity.vo.RoleMenuRelationVo;
import com.wzn.mall.entity.vo.dto.RoleMenuRelationDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-14 22:03:25
 */
public interface RoleMenuRelationFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/RoleMenuRelation/detals")
    RoleMenuRelationVo queryRoleMenuRelationById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/RoleMenuRelation/queryPage")
    List<RoleMenuRelationVo> queryRoleMenuRelationByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/RoleMenuRelation/query")
    List<RoleMenuRelationVo> queryRoleMenuRelationByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/RoleMenuRelation/add")
    RoleMenuRelationVo add(@RequestBody RoleMenuRelationDto roleMenuRelationDto);

    @ApiOperation(value = "修改")
    @PostMapping("/RoleMenuRelation/edit")
    boolean edit(@RequestBody RoleMenuRelationDto roleMenuRelationDto);

    @ApiOperation(value = "删除")
    @PostMapping("/RoleMenuRelation/del")
    boolean deleteById(Long id);

}