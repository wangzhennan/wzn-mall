package com.wzn.mall.service;

import com.wzn.mall.entity.vo.ManagerPermissionRelationVo;
import com.wzn.mall.entity.dto.ManagerPermissionRelationDto;
import java.util.List;

/**
 * ManagerPermissionRelationService服务
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
public interface ManagerPermissionRelationService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    ManagerPermissionRelationVo queryManagerPermissionRelationById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<ManagerPermissionRelationVo> queryManagerPermissionRelationByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<ManagerPermissionRelationVo> queryManagerPermissionRelationByCondition(Object object);

    /**
     * 新增数据
     *
     * @param managerPermissionRelationDto 实例对象
     * @return 实例对象
     */
    ManagerPermissionRelationVo add(ManagerPermissionRelationDto managerPermissionRelationDto);

    /**
     * 修改数据
     *
     * @param managerPermissionRelationDto 实例对象
     * @return 实例对象
     */
    boolean edit(ManagerPermissionRelationDto managerPermissionRelationDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}