package com.wzn.mall.controller;

import com.wzn.mall.entity.ManagerLog;
import com.wzn.mall.service.ManagerLogService;
import com.wzn.mall.entity.vo.ManagerLogVo;
import com.wzn.mall.entity.dto.ManagerLogDto;
import com.wzn.mall.controller.feign.ManagerLogFeignService;
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
@RequestMapping("managerLog")
@Api(tags = "(ManagerLog)服务") 
public class ManagerLogController implements ManagerLogFeignService{
   
    @Resource
    private ManagerLogService managerLogService;
 
    @Override
    public ManagerLogVo queryManagerLogById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.managerLogService.queryManagerLogById(id);
    }
    
    @Override
    public List<ManagerLogVo> queryManagerLogByConditionPage(Object object,int pageNum, int pageSize){
        return this.managerLogService.queryManagerLogByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<ManagerLogVo> queryManagerLogByCondition(Object object){
        return this.managerLogService.queryManagerLogByCondition(object);
    }

    @Override
    public ManagerLogVo add(ManagerLogDto managerLogDto){
        return this.managerLogService.add(managerLogDto);
    }

    @Override
    public boolean edit(ManagerLogDto managerLogDto){
        return this.managerLogService.edit(managerLogDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.managerLogService.deleteById(id);
    }

}