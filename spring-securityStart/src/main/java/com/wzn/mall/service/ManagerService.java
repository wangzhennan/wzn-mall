package com.wzn.mall.service;

import com.wzn.mall.entity.vo.ManagerVo;
import com.wzn.mall.entity.vo.dto.ManagerDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * ManagerService服务
 * @author wzn
 * @since 2020-04-14 21:52:07
 */
public interface ManagerService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    ManagerVo queryManagerById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<ManagerVo> queryManagerByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<ManagerVo> queryManagerByCondition(Object object);

    /**
     * 新增数据
     *
     * @param managerDto 实例对象
     * @return 实例对象
     */
    ManagerVo add(ManagerDto managerDto);

    /**
     * 修改数据
     *
     * @param managerDto 实例对象
     * @return 实例对象
     */
    boolean edit(ManagerDto managerDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}