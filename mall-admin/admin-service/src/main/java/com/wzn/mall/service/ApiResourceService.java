package com.wzn.mall.service;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.entity.dto.ApiResourceDto;
import com.wzn.mall.entity.dto.ApisResourceQueryParam;
import com.wzn.mall.entity.vo.ApiResourceVo;

import java.util.List;

/**
 * ApiResourceService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
public interface ApiResourceService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    ApiResourceVo queryApiResourceById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @return 对象列表
     */
    PageInfo<List<ApiResourceVo>> queryApiResourceByConditionPage(ApisResourceQueryParam apisResourceQueryParam);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<ApiResourceVo> queryApiResourceByCondition(ApisResourceQueryParam object);

    /**
     * 新增数据
     *
     * @param apiResourceDto 实例对象
     * @return 实例对象
     */
    ApiResourceVo add(ApiResourceDto apiResourceDto);

    /**
     * 修改数据
     *
     * @param apiResourceDto 实例对象
     * @return 实例对象
     */
    boolean edit(ApiResourceDto apiResourceDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}