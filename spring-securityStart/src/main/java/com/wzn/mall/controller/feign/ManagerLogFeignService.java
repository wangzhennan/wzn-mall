package com.wzn.mall.feign;

import com.wzn.mall.entity.vo.ManagerLogVo;
import com.wzn.mall.entity.vo.dto.ManagerLogDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-14 21:55:25
 */
public interface ManagerLogFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/ManagerLog/detals")
    ManagerLogVo queryManagerLogById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/ManagerLog/queryPage")
    List<ManagerLogVo> queryManagerLogByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/ManagerLog/query")
    List<ManagerLogVo> queryManagerLogByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/ManagerLog/add")
    ManagerLogVo add(@RequestBody ManagerLogDto managerLogDto);

    @ApiOperation(value = "修改")
    @PostMapping("/ManagerLog/edit")
    boolean edit(@RequestBody ManagerLogDto managerLogDto);

    @ApiOperation(value = "删除")
    @PostMapping("/ManagerLog/del")
    boolean deleteById(Long id);

}