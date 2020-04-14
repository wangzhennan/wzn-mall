package com.wzn.mall.feign;

import com.wzn.mall.entity.vo.ManagerPermissionRelationVo;
import com.wzn.mall.entity.vo.dto.ManagerPermissionRelationDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-14 21:53:19
 */
public interface ManagerPermissionRelationFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/ManagerPermissionRelation/detals")
    ManagerPermissionRelationVo queryManagerPermissionRelationById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/ManagerPermissionRelation/queryPage")
    List<ManagerPermissionRelationVo> queryManagerPermissionRelationByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/ManagerPermissionRelation/query")
    List<ManagerPermissionRelationVo> queryManagerPermissionRelationByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/ManagerPermissionRelation/add")
    ManagerPermissionRelationVo add(@RequestBody ManagerPermissionRelationDto managerPermissionRelationDto);

    @ApiOperation(value = "修改")
    @PostMapping("/ManagerPermissionRelation/edit")
    boolean edit(@RequestBody ManagerPermissionRelationDto managerPermissionRelationDto);

    @ApiOperation(value = "删除")
    @PostMapping("/ManagerPermissionRelation/del")
    boolean deleteById(Long id);

}