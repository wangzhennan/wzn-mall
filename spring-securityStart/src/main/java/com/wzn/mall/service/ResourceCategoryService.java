package com.wzn.mall.service;

import com.wzn.mall.entity.vo.ResourceCategoryVo;
import com.wzn.mall.entity.vo.dto.ResourceCategoryDto;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * ResourceCategoryService服务
 * @author wzn
 * @since 2020-04-14 22:02:11
 */
public interface ResourceCategoryService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    ResourceCategoryVo queryResourceCategoryById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<ResourceCategoryVo> queryResourceCategoryByConditionPage(Object object,int pageNum, int pageSize);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<ResourceCategoryVo> queryResourceCategoryByCondition(Object object);

    /**
     * 新增数据
     *
     * @param resourceCategoryDto 实例对象
     * @return 实例对象
     */
    ResourceCategoryVo add(ResourceCategoryDto resourceCategoryDto);

    /**
     * 修改数据
     *
     * @param resourceCategoryDto 实例对象
     * @return 实例对象
     */
    boolean edit(ResourceCategoryDto resourceCategoryDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}