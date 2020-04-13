package com.wzn.mall.controller;

import com.wzn.mall.entity.RoleResourceRelation;
import com.wzn.mall.service.RoleResourceRelationService;
import com.wzn.mall.entity.vo.RoleResourceRelationVo;
import com.wzn.mall.entity.dto.RoleResourceRelationDto;
import com.wzn.mall.controller.feign.RoleResourceRelationFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
@RestController
@RequestMapping("roleResourceRelation")
@Api(tags = "(RoleResourceRelation)服务") 
public class RoleResourceRelationController implements RoleResourceRelationFeignService{
   
    @Resource
    private RoleResourceRelationService roleResourceRelationService;
 
    @Override
    public RoleResourceRelationVo queryRoleResourceRelationById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.roleResourceRelationService.queryRoleResourceRelationById(id);
    }
    
    @Override
    public List<RoleResourceRelationVo> queryRoleResourceRelationByConditionPage(Object object,int pageNum, int pageSize){
        return this.roleResourceRelationService.queryRoleResourceRelationByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<RoleResourceRelationVo> queryRoleResourceRelationByCondition(Object object){
        return this.roleResourceRelationService.queryRoleResourceRelationByCondition(object);
    }

    @Override
    public RoleResourceRelationVo add(RoleResourceRelationDto roleResourceRelationDto){
        return this.roleResourceRelationService.add(roleResourceRelationDto);
    }

    @Override
    public boolean edit(RoleResourceRelationDto roleResourceRelationDto){
        return this.roleResourceRelationService.edit(roleResourceRelationDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.roleResourceRelationService.deleteById(id);
    }

}