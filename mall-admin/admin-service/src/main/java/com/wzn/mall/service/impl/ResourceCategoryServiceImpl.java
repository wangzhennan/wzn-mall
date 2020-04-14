package com.wzn.mall.service.impl;

import com.wzn.mall.entity.ResourceCategory;
import com.wzn.mall.entity.vo.ResourceCategoryVo;
import com.wzn.mall.entity.ResourceCategoryExample;
import com.wzn.mall.entity.dto.ResourceCategoryDto;
import com.wzn.mall.mapper.ResourceCategoryMapper;
import com.wzn.mall.service.ResourceCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 * @author wangzhennan
 * @since 2020-04-14 22:06:23
 */
@Service("resourceCategoryService")
public class ResourceCategoryServiceImpl implements ResourceCategoryService {
    @Resource
    private ResourceCategoryMapper resourceCategoryMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResourceCategoryVo queryResourceCategoryById(Long id) {
        ResourceCategoryExample example = new ResourceCategoryExample();
        example.createCriteria().andIdEqualTo(id);
        ResourceCategory resourceCategory =this.resourceCategoryMapper.selectOneByExample(id);
        ResourceCategoryVo vo = new ResourceCategoryVo();
        BeanUtils.copyProperties(resourceCategory,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<ResourceCategoryVo> queryResourceCategoryByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ResourceCategoryExample example = new ResourceCategoryExample();
        List<ResourceCategory> resourceCategoryList = this.resourceCategoryMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(resourceCategoryList)){
            return null;
        }
        List<ResourceCategoryVo>  resourceCategoryVoList= new ArrayList<>(resourceCategoryList.size());
        resourceCategoryList.stream().forEach(p->{
            ResourceCategoryVo resourceCategoryVo = new ResourceCategoryVo();
            BeanUtils.copyProperties(p,resourceCategoryVo);
            resourceCategoryVoList.add(resourceCategoryVo);
        });
        return resourceCategoryVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<ResourceCategoryVo> queryResourceCategoryByCondition(Object object) {
        ResourceCategoryExample example = new ResourceCategoryExample();
        List<ResourceCategory> resourceCategoryList =this.resourceCategoryMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(resourceCategoryList)){
            return null;
        }
        List<ResourceCategoryVo>  resourceCategoryVoList= new ArrayList<>(resourceCategoryList.size());
        resourceCategoryList.stream().forEach(p->{
            ResourceCategoryVo resourceCategoryVo = new ResourceCategoryVo();
            BeanUtils.copyProperties(p,resourceCategoryVo);
            resourceCategoryVoList.add(resourceCategoryVo);
        });
        return resourceCategoryVoList;
    }
    /**
     * 新增数据
     * @param resourceCategoryDto 实例对象
     * @return 实例对象
     */
    @Override
    public ResourceCategoryVo add(ResourceCategoryDto resourceCategoryDto) {
        ResourceCategory resourceCategory = new ResourceCategory();
        BeanUtils.copyProperties(resourceCategoryDto,resourceCategory);
        this.resourceCategoryMapper.insertUseGeneratedKeys(resourceCategory);
        ResourceCategoryVo vo = new ResourceCategoryVo();
        BeanUtils.copyProperties(resourceCategory,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param resourceCategoryDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(ResourceCategoryDto resourceCategoryDto) {
     ResourceCategory resourceCategory = new ResourceCategory();
      BeanUtils.copyProperties(resourceCategoryDto,resourceCategory);
     return this.resourceCategoryMapper.updateByPrimaryKeySelective(resourceCategory)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        ResourceCategoryExample example = new ResourceCategoryExample();
        example.createCriteria().andIdEqualTo(id);
        return this.resourceCategoryMapper.deleteByPrimaryKey(example) > 0;
    }
}