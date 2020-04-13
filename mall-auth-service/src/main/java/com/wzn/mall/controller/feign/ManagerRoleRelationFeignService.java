package com.wzn.mall.controller.feign;

import com.wzn.mall.entity.vo.ManagerRoleRelationVo;
import com.wzn.mall.entity.dto.ManagerRoleRelationDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-13 19:16:39
 */
public interface ManagerRoleRelationFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/ManagerRoleRelation/detals")
    ManagerRoleRelationVo queryManagerRoleRelationById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/ManagerRoleRelation/queryPage")
    List<ManagerRoleRelationVo> queryManagerRoleRelationByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/ManagerRoleRelation/query")
    List<ManagerRoleRelationVo> queryManagerRoleRelationByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/ManagerRoleRelation/add")
    ManagerRoleRelationVo add(@RequestBody ManagerRoleRelationDto managerRoleRelationDto);

    @ApiOperation(value = "修改")
    @PostMapping("/ManagerRoleRelation/edit")
    boolean edit(@RequestBody ManagerRoleRelationDto managerRoleRelationDto);

    @ApiOperation(value = "删除")
    @PostMapping("/ManagerRoleRelation/del")
    boolean deleteById(Long id);

}