package com.wzn.mall.controller;

import com.wzn.mall.entity.Manager;
import com.wzn.mall.service.ManagerService;
import com.wzn.mall.entity.vo.ManagerVo;
import com.wzn.mall.entity.vo.dto.ManagerDto;
import com.wzn.mall.feign.ManagerFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-14 21:52:07
 */
@RestController
@RequestMapping("manager")
@Api(tags = "(Manager)服务") 
public class ManagerController implements ManagerFeignService{
   
    @Resource
    private ManagerService managerService;
 
    @Override
    public ManagerVo queryManagerById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.managerService.queryManagerById(id);
    }
    
    @Override
    public List<ManagerVo> queryManagerByConditionPage(Object object,int pageNum, int pageSize){
        return this.managerService.queryManagerByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<ManagerVo> queryManagerByCondition(Object object){
        return this.managerService.queryManagerByCondition(object);
    }

    @Override
    public ManagerVo add(ManagerDto managerDto){
        return this.managerService.add(managerDto);
    }

    @Override
    public boolean edit(ManagerDto managerDto){
        return this.managerService.edit(managerDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.managerService.deleteById(id);
    }

}