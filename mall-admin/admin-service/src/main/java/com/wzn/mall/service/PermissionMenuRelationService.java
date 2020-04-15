package com.wzn.mall.service;

import com.wzn.mall.entity.vo.PermissionMenuRelationVo;
import com.wzn.mall.entity.dto.PermissionMenuRelationDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * PermissionMenuRelationService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
public interface PermissionMenuRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    PermissionMenuRelationVo queryPermissionMenuRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<PermissionMenuRelationVo> queryPermissionMenuRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<PermissionMenuRelationVo> queryPermissionMenuRelationByCondition(Object object);

    /**
     * 新增数据
     *
     * @param permissionMenuRelationDto 实例对象
     * @return 实例对象
     */
    PermissionMenuRelationVo add(PermissionMenuRelationDto permissionMenuRelationDto);

    /**
     * 修改数据
     *
     * @param permissionMenuRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(PermissionMenuRelationDto permissionMenuRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}