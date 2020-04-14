package com.wzn.mall.controller;

import com.wzn.mall.entity.RoleMenuRelation;
import com.wzn.mall.service.RoleMenuRelationService;
import com.wzn.mall.entity.vo.RoleMenuRelationVo;
import com.wzn.mall.entity.vo.dto.RoleMenuRelationDto;
import com.wzn.mall.feign.RoleMenuRelationFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-14 22:03:25
 */
@RestController
@RequestMapping("roleMenuRelation")
@Api(tags = "(RoleMenuRelation)服务") 
public class RoleMenuRelationController implements RoleMenuRelationFeignService{
   
    @Resource
    private RoleMenuRelationService roleMenuRelationService;
 
    @Override
    public RoleMenuRelationVo queryRoleMenuRelationById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.roleMenuRelationService.queryRoleMenuRelationById(id);
    }
    
    @Override
    public List<RoleMenuRelationVo> queryRoleMenuRelationByConditionPage(Object object,int pageNum, int pageSize){
        return this.roleMenuRelationService.queryRoleMenuRelationByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<RoleMenuRelationVo> queryRoleMenuRelationByCondition(Object object){
        return this.roleMenuRelationService.queryRoleMenuRelationByCondition(object);
    }

    @Override
    public RoleMenuRelationVo add(RoleMenuRelationDto roleMenuRelationDto){
        return this.roleMenuRelationService.add(roleMenuRelationDto);
    }

    @Override
    public boolean edit(RoleMenuRelationDto roleMenuRelationDto){
        return this.roleMenuRelationService.edit(roleMenuRelationDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.roleMenuRelationService.deleteById(id);
    }

}