package com.wzn.mall.service;

import com.wzn.mall.entity.vo.ManagerRoleRelationVo;
import com.wzn.mall.entity.dto.ManagerRoleRelationDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * ManagerRoleRelationService服务
 * @author wzn
 * @since 2020-04-12 16:48:31
 */
public interface ManagerRoleRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    ManagerRoleRelationVo queryManagerRoleRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<ManagerRoleRelationVo> queryManagerRoleRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<ManagerRoleRelationVo> queryManagerRoleRelationByCondition(Object object);

    /**
     * 新增数据
     *
     * @param managerRoleRelationDto 实例对象
     * @return 实例对象
     */
    ManagerRoleRelationVo add(ManagerRoleRelationDto managerRoleRelationDto);

    /**
     * 修改数据
     *
     * @param managerRoleRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(ManagerRoleRelationDto managerRoleRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}