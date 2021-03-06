package com.wzn.mall.service;

import com.wzn.mall.entity.vo.PermissionApiResourceRelationVo;
import com.wzn.mall.entity.dto.PermissionApiResourceRelationDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * PermissionApiResourceRelationService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
public interface PermissionApiResourceRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    PermissionApiResourceRelationVo queryPermissionApiResourceRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<PermissionApiResourceRelationVo> queryPermissionApiResourceRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<PermissionApiResourceRelationVo> queryPermissionApiResourceRelationByCondition(Object object);

    /**
     * 新增数据
     *
     * @param permissionApiResourceRelationDto 实例对象
     * @return 实例对象
     */
    PermissionApiResourceRelationVo add(PermissionApiResourceRelationDto permissionApiResourceRelationDto);

    /**
     * 修改数据
     *
     * @param permissionApiResourceRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(PermissionApiResourceRelationDto permissionApiResourceRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}