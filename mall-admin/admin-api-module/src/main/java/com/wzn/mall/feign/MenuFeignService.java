package com.wzn.mall.feign;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.Apis;
import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.MenuDto;
import com.wzn.mall.entity.dto.MenuQueryParam;
import com.wzn.mall.entity.vo.MenuVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * feign服务
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
public interface MenuFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping(Apis.MENU_DETALS)
    ResultModel<MenuVo> queryMenuById(@RequestParam("id") Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping(Apis.MENU_QUERY_PAGE)
    ResultModel<PageInfo<List<MenuVo>>> queryMenuByConditionPage(@RequestBody MenuQueryParam param);

    @ApiOperation(value = "根据条件查询")
    @PostMapping(Apis.MENU_QUERY_CONDITION)
    ResultModel<List<MenuVo>> queryMenuByCondition(@RequestBody MenuQueryParam param);

    @ApiOperation(value = "添加")
    @PostMapping(Apis.MENU_ADD)
    ResultModel<MenuVo> add(@RequestBody MenuDto menuDto);

    @ApiOperation(value = "修改")
    @PostMapping(Apis.MENU_EDIT)
    ResultModel<Boolean> edit(@RequestBody MenuDto menuDto);

    @ApiOperation(value = "删除")
    @PostMapping(Apis.MENU_DEL)
    ResultModel<Boolean> deleteById(Long id);

}