package com.wzn.mall.service.impl;

import com.wzn.mall.entity.Menu;
import com.wzn.mall.entity.vo.MenuVo;
import com.wzn.mall.entity.MenuExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.MenuMapper;
import com.wzn.mall.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 * @author wzn
 * @since 2020-04-13 19:16:39
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MenuVo queryMenuById(Long id) {
        MenuExample example = new MenuExample();
        example.createCriteria().andIdEqualTo(id);
        Menu menu =this.menuMapper.selectOneByExample(id);
        MenuVo vo = new MenuVo();
        BeanUtils.copyProperties(menu,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<MenuVo> queryMenuByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        MenuExample example = new MenuExample();
        List<Menu> menuList = this.menuMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(menuList)){
            return null;
        }
        List<MenuVo>  menuVoList= new ArrayList<>(menuList.size());
        menuList.stream().forEach(p->{
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(p,menuVo);
            menuVoList.add(menuVo);
        });
        return menuVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<MenuVo> queryMenuByCondition(Object object) {
        MenuExample example = new MenuExample();
        List<Menu> menuList =this.menuMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(menuList)){
            return null;
        }
        List<MenuVo>  menuVoList= new ArrayList<>(menuList.size());
        menuList.stream().forEach(p->{
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(p,menuVo);
            menuVoList.add(menuVo);
        });
        return menuVoList;
    }
    /**
     * 新增数据
     * @param menuDto 实例对象
     * @return 实例对象
     */
    @Override
    public MenuVo add(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto,menu);
        this.menuMapper.insertUseGeneratedKeys(menu);
        MenuVo vo = new MenuVo();
        BeanUtils.copyProperties(menu,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param menuDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(MenuDto menuDto) {
     Menu menu = new Menu();
      BeanUtils.copyProperties(menuDto,menu);
     return this.menuMapper.updateByPrimaryKeySelective(menu)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        MenuExample example = new MenuExample();
        example.createCriteria().andIdEqualTo(id);
        return this.menuMapper.deleteByPrimaryKey(example) > 0;
    }
}