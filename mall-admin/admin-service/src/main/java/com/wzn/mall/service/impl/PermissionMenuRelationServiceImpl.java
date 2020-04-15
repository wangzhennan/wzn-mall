package com.wzn.mall.service.impl;

import com.wzn.mall.entity.PermissionMenuRelation;
import com.wzn.mall.entity.vo.PermissionMenuRelationVo;
import com.wzn.mall.entity.PermissionMenuRelationExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.PermissionMenuRelationMapper;
import com.wzn.mall.service.PermissionMenuRelationService;
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
 * @since 2020-04-15 14:51:36
 */
@Service("permissionMenuRelationService")
public class PermissionMenuRelationServiceImpl implements PermissionMenuRelationService {
    @Resource
    private PermissionMenuRelationMapper permissionMenuRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PermissionMenuRelationVo queryPermissionMenuRelationById(Long id) {
        PermissionMenuRelationExample example = new PermissionMenuRelationExample();
        example.createCriteria().andIdEqualTo(id);
        PermissionMenuRelation permissionMenuRelation =this.permissionMenuRelationMapper.selectOneByExample(id);
        PermissionMenuRelationVo vo = new PermissionMenuRelationVo();
        BeanUtils.copyProperties(permissionMenuRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<PermissionMenuRelationVo> queryPermissionMenuRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PermissionMenuRelationExample example = new PermissionMenuRelationExample();
        List<PermissionMenuRelation> permissionMenuRelationList = this.permissionMenuRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(permissionMenuRelationList)){
            return null;
        }
        List<PermissionMenuRelationVo>  permissionMenuRelationVoList= new ArrayList<>(permissionMenuRelationList.size());
        permissionMenuRelationList.stream().forEach(p->{
            PermissionMenuRelationVo permissionMenuRelationVo = new PermissionMenuRelationVo();
            BeanUtils.copyProperties(p,permissionMenuRelationVo);
            permissionMenuRelationVoList.add(permissionMenuRelationVo);
        });
        return permissionMenuRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<PermissionMenuRelationVo> queryPermissionMenuRelationByCondition(Object object) {
        PermissionMenuRelationExample example = new PermissionMenuRelationExample();
        List<PermissionMenuRelation> permissionMenuRelationList =this.permissionMenuRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(permissionMenuRelationList)){
            return null;
        }
        List<PermissionMenuRelationVo>  permissionMenuRelationVoList= new ArrayList<>(permissionMenuRelationList.size());
        permissionMenuRelationList.stream().forEach(p->{
            PermissionMenuRelationVo permissionMenuRelationVo = new PermissionMenuRelationVo();
            BeanUtils.copyProperties(p,permissionMenuRelationVo);
            permissionMenuRelationVoList.add(permissionMenuRelationVo);
        });
        return permissionMenuRelationVoList;
    }
    /**
     * 新增数据
     * @param permissionMenuRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public PermissionMenuRelationVo add(PermissionMenuRelationDto permissionMenuRelationDto) {
        PermissionMenuRelation permissionMenuRelation = new PermissionMenuRelation();
        BeanUtils.copyProperties(permissionMenuRelationDto,permissionMenuRelation);
        this.permissionMenuRelationMapper.insertUseGeneratedKeys(permissionMenuRelation);
        PermissionMenuRelationVo vo = new PermissionMenuRelationVo();
        BeanUtils.copyProperties(permissionMenuRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param permissionMenuRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(PermissionMenuRelationDto permissionMenuRelationDto) {
     PermissionMenuRelation permissionMenuRelation = new PermissionMenuRelation();
      BeanUtils.copyProperties(permissionMenuRelationDto,permissionMenuRelation);
     return this.permissionMenuRelationMapper.updateByPrimaryKeySelective(permissionMenuRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        PermissionMenuRelationExample example = new PermissionMenuRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.permissionMenuRelationMapper.deleteByPrimaryKey(example) > 0;
    }
}