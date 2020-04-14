package com.wzn.mall.feign;

import com.wzn.mall.Apis;
import com.wzn.mall.entity.dto.ManagerDto;
import com.wzn.mall.entity.vo.ManagerVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 管理员feign服务
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
public interface ManagerFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping(Apis.MANAGER_DETALS)
    ManagerVo queryManagerById(@RequestParam("id") Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping(Apis.MANAGER_QUERY_PAGE)
    List<ManagerVo> queryManagerByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping(Apis.MANAGER_QUERY_CONDITION)
    List<ManagerVo> queryManagerByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping(Apis.MANAGER_ADD)
    ManagerVo add(@RequestBody ManagerDto managerDto);

    @ApiOperation(value = "修改")
    @PostMapping(Apis.MANAGER_EDIT)
    boolean edit(@RequestBody ManagerDto managerDto);

    @ApiOperation(value = "删除")
    @PostMapping(Apis.MANAGER_DEL)
    boolean deleteById(Long id);

}