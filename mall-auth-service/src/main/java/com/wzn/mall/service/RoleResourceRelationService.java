package com.wzn.mall.service;

import com.wzn.mall.entity.vo.RoleResourceRelationVo;
import com.wzn.mall.entity.dto.RoleResourceRelationDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * RoleResourceRelationService服务
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
public interface RoleResourceRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    RoleResourceRelationVo queryRoleResourceRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<RoleResourceRelationVo> queryRoleResourceRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<RoleResourceRelationVo> queryRoleResourceRelationByCondition(Object object);

    /**
     * 新增数据
     *
     * @param roleResourceRelationDto 实例对象
     * @return 实例对象
     */
    RoleResourceRelationVo add(RoleResourceRelationDto roleResourceRelationDto);

    /**
     * 修改数据
     *
     * @param roleResourceRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(RoleResourceRelationDto roleResourceRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}