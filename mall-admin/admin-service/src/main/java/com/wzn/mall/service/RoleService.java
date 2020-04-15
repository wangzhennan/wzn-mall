package com.wzn.mall.service;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.dto.RoleDto;
import com.wzn.mall.entity.dto.RoleQueryParam;
import com.wzn.mall.entity.vo.RoleVo;

import java.util.List;

/**
 * RoleService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
public interface RoleService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    RoleVo queryRoleById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @return 对象列表
     */
    PageInfo<List<RoleVo>> queryRoleByConditionPage(RoleQueryParam param);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<RoleVo> queryRoleByCondition(RoleQueryParam object);

    /**
     * 新增数据
     *
     * @param roleDto 实例对象
     * @return 实例对象
     */
    RoleVo add(RoleDto roleDto);

    /**
     * 修改数据
     *
     * @param roleDto 实例对象
     * @return 实例对象
     */
    boolean edit(RoleDto roleDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 添加 权限
     *
     * @param bindingObjectDto
     * @return
     */

    boolean addPermission(BindingObjectDto bindingObjectDto);
}