package com.wzn.mall.controller;

import com.wzn.mall.entity.ManagerPermissionRelation;
import com.wzn.mall.service.ManagerPermissionRelationService;
import com.wzn.mall.entity.vo.ManagerPermissionRelationVo;
import com.wzn.mall.entity.dto.ManagerPermissionRelationDto;
import com.wzn.mall.controller.feign.ManagerPermissionRelationFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-13 19:16:39
 */
@RestController
@RequestMapping("managerPermissionRelation")
@Api(tags = "(ManagerPermissionRelation)服务") 
public class ManagerPermissionRelationController implements ManagerPermissionRelationFeignService{
   
    @Resource
    private ManagerPermissionRelationService managerPermissionRelationService;
 
    @Override
    public ManagerPermissionRelationVo queryManagerPermissionRelationById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.managerPermissionRelationService.queryManagerPermissionRelationById(id);
    }
    
    @Override
    public List<ManagerPermissionRelationVo> queryManagerPermissionRelationByConditionPage(Object object,int pageNum, int pageSize){
        return this.managerPermissionRelationService.queryManagerPermissionRelationByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<ManagerPermissionRelationVo> queryManagerPermissionRelationByCondition(Object object){
        return this.managerPermissionRelationService.queryManagerPermissionRelationByCondition(object);
    }

    @Override
    public ManagerPermissionRelationVo add(ManagerPermissionRelationDto managerPermissionRelationDto){
        return this.managerPermissionRelationService.add(managerPermissionRelationDto);
    }

    @Override
    public boolean edit(ManagerPermissionRelationDto managerPermissionRelationDto){
        return this.managerPermissionRelationService.edit(managerPermissionRelationDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.managerPermissionRelationService.deleteById(id);
    }

}