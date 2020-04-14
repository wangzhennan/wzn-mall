package com.wzn.mall.controller;

import com.wzn.mall.entity.dto.MenuDto;
import com.wzn.mall.entity.vo.MenuVo;
import com.wzn.mall.feign.MenuFeignService;
import com.wzn.mall.service.MenuService;
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
@Api(value = "菜单",tags = "菜单")
public class MenuController implements MenuFeignService{
   
    @Resource
    private MenuService menuService;
 
    @Override
    public MenuVo queryMenuById(Long id) {
        return this.menuService.queryMenuById(id);
    }
    
    @Override
    public List<MenuVo> queryMenuByConditionPage(Object object,int pageNum, int pageSize){
        return this.menuService.queryMenuByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<MenuVo> queryMenuByCondition(Object object){
        return this.menuService.queryMenuByCondition(object);
    }

    @Override
    public MenuVo add(MenuDto menuDto){
        return this.menuService.add(menuDto);
    }

    @Override
    public boolean edit(MenuDto menuDto){
        return this.menuService.edit(menuDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.menuService.deleteById(id);
    }

}