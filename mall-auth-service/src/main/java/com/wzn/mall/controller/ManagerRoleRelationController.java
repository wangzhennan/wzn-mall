package com.wzn.mall.controller;

import com.wzn.mall.entity.ManagerRoleRelation;
import com.wzn.mall.service.ManagerRoleRelationService;
import com.wzn.mall.entity.vo.ManagerRoleRelationVo;
import com.wzn.mall.entity.dto.ManagerRoleRelationDto;
import com.wzn.mall.controller.feign.ManagerRoleRelationFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-12 16:53:06
 */
@RestController
@RequestMapping("managerRoleRelation")
@Api(tags = "(ManagerRoleRelation)服务") 
public class ManagerRoleRelationController implements ManagerRoleRelationFeignService{
   
    @Resource
    private ManagerRoleRelationService managerRoleRelationService;
 
    @Override
    public ManagerRoleRelationVo queryManagerRoleRelationById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.managerRoleRelationService.queryManagerRoleRelationById(id);
    }
    
    @Override
    public List<ManagerRoleRelationVo> queryManagerRoleRelationByConditionPage(Object object,int pageNum, int pageSize){
        return this.managerRoleRelationService.queryManagerRoleRelationByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<ManagerRoleRelationVo> queryManagerRoleRelationByCondition(Object object){
        return this.managerRoleRelationService.queryManagerRoleRelationByCondition(object);
    }

    @Override
    public ManagerRoleRelationVo add(ManagerRoleRelationDto managerRoleRelationDto){
        return this.managerRoleRelationService.add(managerRoleRelationDto);
    }

    @Override
    public boolean edit(ManagerRoleRelationDto managerRoleRelationDto){
        return this.managerRoleRelationService.edit(managerRoleRelationDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.managerRoleRelationService.deleteById(id);
    }

}