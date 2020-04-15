package com.wzn.mall.service;

import com.wzn.mall.entity.vo.AdminLogVo;
import com.wzn.mall.entity.dto.AdminLogDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * AdminLogService服务
 * @author wangzhennan
 * @since 2020-04-15 15:27:31
 */
public interface AdminLogService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    AdminLogVo queryAdminLogById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<AdminLogVo> queryAdminLogByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<AdminLogVo> queryAdminLogByCondition(Object object);

    /**
     * 新增数据
     *
     * @param adminLogDto 实例对象
     * @return 实例对象
     */
    AdminLogVo add(AdminLogDto adminLogDto);

    /**
     * 修改数据
     *
     * @param adminLogDto 实例对象
     * @return 实例对象
     */
    boolean edit(AdminLogDto adminLogDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}