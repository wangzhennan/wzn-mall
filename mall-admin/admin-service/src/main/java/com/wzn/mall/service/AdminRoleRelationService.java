package com.wzn.mall.service;

import com.wzn.mall.entity.AdminRoleRelation;
import com.wzn.mall.entity.dto.AdminRoleRelationDto;
import com.wzn.mall.entity.vo.AdminRoleRelationVo;

import java.util.List;

/**
 * AdminRoleRelationService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
public interface AdminRoleRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    AdminRoleRelationVo queryAdminRoleRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<AdminRoleRelationVo> queryAdminRoleRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<AdminRoleRelationVo> queryAdminRoleRelationByCondition(AdminRoleRelationDto object);

    /**
     * 新增数据
     *
     * @param adminRoleRelationDto 实例对象
     * @return 实例对象
     */
    AdminRoleRelationVo add(AdminRoleRelationDto adminRoleRelationDto);

    /**
     * 修改数据
     *
     * @param adminRoleRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(AdminRoleRelationDto adminRoleRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量添加
     * @param relationList
     * @return
     */
    boolean addList(List<AdminRoleRelation> relationList);
}