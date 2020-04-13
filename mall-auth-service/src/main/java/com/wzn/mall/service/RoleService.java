package com.wzn.mall.service;

import com.wzn.mall.entity.vo.RoleVo;
import com.wzn.mall.entity.dto.RoleDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * RoleService服务
 * @author wzn
 * @since 2020-04-13 19:16:41
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
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<RoleVo> queryRoleByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<RoleVo> queryRoleByCondition(Object object);

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

}