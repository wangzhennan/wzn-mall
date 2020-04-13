package com.wzn.mall.controller.feign;

import com.wzn.mall.entity.vo.ManagerVo;
import com.wzn.mall.entity.dto.ManagerDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-13 19:16:38
 */
public interface ManagerFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/Manager/detals")
    ManagerVo queryManagerById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/Manager/queryPage")
    List<ManagerVo> queryManagerByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/Manager/query")
    List<ManagerVo> queryManagerByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/Manager/add")
    ManagerVo add(@RequestBody ManagerDto managerDto);

    @ApiOperation(value = "修改")
    @PostMapping("/Manager/edit")
    boolean edit(@RequestBody ManagerDto managerDto);

    @ApiOperation(value = "删除")
    @PostMapping("/Manager/del")
    boolean deleteById(Long id);

}