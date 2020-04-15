package com.wzn.mall.controller;

import com.wzn.mall.ResultModel;
import com.wzn.mall.entity.dto.MenuDto;
import com.wzn.mall.entity.vo.MenuVo;
import com.wzn.mall.feign.MenuFeignService;
import com.wzn.mall.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@RestController
@Api(tags = "菜单")
public class MenuController implements MenuFeignService {
   
    @Resource
    private MenuService menuService;
 
    @Override
    public ResultModel<MenuVo> queryMenuById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return ResultModel.success(this.menuService.queryMenuById(id));
    }
    
    @Override
    public ResultModel<List<MenuVo>> queryMenuByConditionPage(Object object, int pageNum, int pageSize) {
        return ResultModel.success(this.menuService.queryMenuByConditionPage(object, pageNum, pageSize));
    }

    @Override
    public ResultModel<List<MenuVo>> queryMenuByCondition(Object object) {
        return ResultModel.success(this.menuService.queryMenuByCondition(object));
    }

    @Override
    public ResultModel<MenuVo> add(MenuDto menuDto) {
        return ResultModel.success(this.menuService.add(menuDto));
    }

    @Override
    public ResultModel<Boolean> edit(MenuDto menuDto) {
        return ResultModel.success(this.menuService.edit(menuDto));
    }

    @Override
    public ResultModel<Boolean> deleteById(Long id) {
        return ResultModel.success(this.menuService.deleteById(id));
    }

}