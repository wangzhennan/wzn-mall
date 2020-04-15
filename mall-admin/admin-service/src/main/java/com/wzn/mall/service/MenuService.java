package com.wzn.mall.service;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.entity.dto.MenuDto;
import com.wzn.mall.entity.dto.MenuQueryParam;
import com.wzn.mall.entity.vo.MenuVo;

import java.util.List;

/**
 * MenuService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
public interface MenuService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    MenuVo queryMenuById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @return 对象列表
     */
    PageInfo<List<MenuVo>> queryMenuByConditionPage(MenuQueryParam param);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<MenuVo> queryMenuByCondition(MenuQueryParam object);

    /**
     * 新增数据
     *
     * @param menuDto 实例对象
     * @return 实例对象
     */
    MenuVo add(MenuDto menuDto);

    /**
     * 修改数据
     *
     * @param menuDto 实例对象
     * @return 实例对象
     */
    boolean edit(MenuDto menuDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}