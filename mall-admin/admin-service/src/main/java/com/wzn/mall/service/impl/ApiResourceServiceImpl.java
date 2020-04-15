package com.wzn.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzn.mall.entity.ApiResource;
import com.wzn.mall.entity.ApiResourceExample;
import com.wzn.mall.entity.dto.ApiResourceDto;
import com.wzn.mall.entity.dto.ApisResourceQueryParam;
import com.wzn.mall.entity.vo.ApiResourceVo;
import com.wzn.mall.mapper.ApiResourceMapper;
import com.wzn.mall.service.ApiResourceService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Service("apiResourceService")
public class ApiResourceServiceImpl implements ApiResourceService {
    @Resource
    private ApiResourceMapper apiResourceMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ApiResourceVo queryApiResourceById(Long id) {
        ApiResourceExample example = new ApiResourceExample();
        example.createCriteria().andIdEqualTo(id);
        ApiResource apiResource =this.apiResourceMapper.selectOneByExample(id);
        ApiResourceVo vo = new ApiResourceVo();
        BeanUtils.copyProperties(apiResource,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @return 对象列表
     */
    @Override
    public PageInfo<List<ApiResourceVo>> queryApiResourceByConditionPage(ApisResourceQueryParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        ApiResourceExample example = new ApiResourceExample();
        ApiResourceExample.Criteria criteria = example.createCriteria();

        if (null != param && Strings.isNotEmpty(param.getName())) {
            criteria.andNameEqualTo(param.getName());
        }
        if (null != param && null != param.getType()) {
            criteria.andPidEqualTo(param.getType());
        }
        List<ApiResource> apiResourceList = this.apiResourceMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(apiResourceList)){
            return null;
        }
        List<ApiResourceVo>  apiResourceVoList= new ArrayList<>(apiResourceList.size());
        apiResourceList.stream().forEach(p->{
            ApiResourceVo apiResourceVo = new ApiResourceVo();
            BeanUtils.copyProperties(p,apiResourceVo);
            apiResourceVoList.add(apiResourceVo);
        });
        PageInfo pageInfo = new PageInfo(apiResourceList);
        pageInfo.setList(apiResourceVoList);
        return pageInfo;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<ApiResourceVo> queryApiResourceByCondition(ApisResourceQueryParam param) {
        ApiResourceExample example = new ApiResourceExample();
        ApiResourceExample.Criteria criteria = example.createCriteria();

        if (null != param && Strings.isNotEmpty(param.getName())) {
            criteria.andNameEqualTo(param.getName());
        }
        if (null != param && null != param.getType()) {
            criteria.andPidEqualTo(param.getType());
        }
        List<ApiResource> apiResourceList =this.apiResourceMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(apiResourceList)){
            return null;
        }
        List<ApiResourceVo>  apiResourceVoList= new ArrayList<>(apiResourceList.size());
        apiResourceList.stream().forEach(p->{
            ApiResourceVo apiResourceVo = new ApiResourceVo();
            BeanUtils.copyProperties(p,apiResourceVo);
            apiResourceVoList.add(apiResourceVo);
        });
        return apiResourceVoList;
    }
    /**
     * 新增数据
     * @param apiResourceDto 实例对象
     * @return 实例对象
     */
    @Override
    public ApiResourceVo add(ApiResourceDto apiResourceDto) {
        ApiResource apiResource = new ApiResource();
        BeanUtils.copyProperties(apiResourceDto,apiResource);
        this.apiResourceMapper.insertUseGeneratedKeys(apiResource);
        ApiResourceVo vo = new ApiResourceVo();
        BeanUtils.copyProperties(apiResource,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param apiResourceDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(ApiResourceDto apiResourceDto) {
     ApiResource apiResource = new ApiResource();
      BeanUtils.copyProperties(apiResourceDto,apiResource);
     return this.apiResourceMapper.updateByPrimaryKeySelective(apiResource)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        ApiResourceExample example = new ApiResourceExample();
        example.createCriteria().andIdEqualTo(id);
        return this.apiResourceMapper.deleteByPrimaryKey(example) > 0;
    }
}