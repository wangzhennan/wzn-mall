package com.wzn.mall.service;

import com.wzn.mall.entity.dto.PermissionDto;
import com.wzn.mall.entity.vo.PermissionVo;

import java.util.List;

/**
 * PermissionService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
public interface PermissionService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    PermissionVo queryPermissionById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<PermissionVo> queryPermissionByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<PermissionVo> queryPermissionByCondition(Object object);

    /**
     * 新增数据
     *
     * @param permissionDto 实例对象
     * @return 实例对象
     */
    PermissionVo add(PermissionDto permissionDto);

    /**
     * 修改数据
     *
     * @param permissionDto 实例对象
     * @return 实例对象
     */
    boolean edit(PermissionDto permissionDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}