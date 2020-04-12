package com.wzn.mall.service;

import com.wzn.mall.entity.vo.RoleMenuRelationVo;
import com.wzn.mall.entity.dto.RoleMenuRelationDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * RoleMenuRelationService服务
 * @author wzn
 * @since 2020-04-12 16:48:31
 */
public interface RoleMenuRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    RoleMenuRelationVo queryRoleMenuRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<RoleMenuRelationVo> queryRoleMenuRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<RoleMenuRelationVo> queryRoleMenuRelationByCondition(Object object);

    /**
     * 新增数据
     *
     * @param roleMenuRelationDto 实例对象
     * @return 实例对象
     */
    RoleMenuRelationVo add(RoleMenuRelationDto roleMenuRelationDto);

    /**
     * 修改数据
     *
     * @param roleMenuRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(RoleMenuRelationDto roleMenuRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}