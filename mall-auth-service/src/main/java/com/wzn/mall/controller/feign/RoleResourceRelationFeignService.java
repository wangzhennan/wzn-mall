package com.wzn.mall.controller.feign;

import com.wzn.mall.entity.vo.RoleResourceRelationVo;
import com.wzn.mall.entity.dto.RoleResourceRelationDto;
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
public interface RoleResourceRelationFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/RoleResourceRelation/detals")
    RoleResourceRelationVo queryRoleResourceRelationById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/RoleResourceRelation/queryPage")
    List<RoleResourceRelationVo> queryRoleResourceRelationByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/RoleResourceRelation/query")
    List<RoleResourceRelationVo> queryRoleResourceRelationByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/RoleResourceRelation/add")
    RoleResourceRelationVo add(@RequestBody RoleResourceRelationDto roleResourceRelationDto);

    @ApiOperation(value = "修改")
    @PostMapping("/RoleResourceRelation/edit")
    boolean edit(@RequestBody RoleResourceRelationDto roleResourceRelationDto);

    @ApiOperation(value = "删除")
    @PostMapping("/RoleResourceRelation/del")
    boolean deleteById(Long id);

}