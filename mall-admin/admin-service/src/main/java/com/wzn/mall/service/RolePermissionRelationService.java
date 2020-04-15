package com.wzn.mall.service;

import com.wzn.mall.entity.RolePermissionRelation;
import com.wzn.mall.entity.dto.RolePermissionRelationDto;
import com.wzn.mall.entity.vo.RolePermissionRelationVo;

import java.util.List;

/**
 * RolePermissionRelationService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
public interface RolePermissionRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    RolePermissionRelationVo queryRolePermissionRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<RolePermissionRelationVo> queryRolePermissionRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<RolePermissionRelationVo> queryRolePermissionRelationByCondition(Object object);

    /**
     * 新增数据
     *
     * @param rolePermissionRelationDto 实例对象
     * @return 实例对象
     */
    RolePermissionRelationVo add(RolePermissionRelationDto rolePermissionRelationDto);

    /**
     * 修改数据
     *
     * @param rolePermissionRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(RolePermissionRelationDto rolePermissionRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 添加权限
     * @param relationList
     * @return
     */
    boolean addList(List<RolePermissionRelation> relationList);
}