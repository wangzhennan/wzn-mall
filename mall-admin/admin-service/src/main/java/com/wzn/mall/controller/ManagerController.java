package com.wzn.mall.controller;

import com.wzn.mall.entity.dto.ManagerDto;
import com.wzn.mall.entity.vo.ManagerVo;
import com.wzn.mall.feign.ManagerFeignService;
import com.wzn.mall.service.ManagerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
@RestController
@Api(value = "管理员",tags = "管理接口")
public class ManagerController implements ManagerFeignService{
   
    @Resource
    private ManagerService managerService;
 
    @Override
    public ManagerVo queryManagerById( Long id) {
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