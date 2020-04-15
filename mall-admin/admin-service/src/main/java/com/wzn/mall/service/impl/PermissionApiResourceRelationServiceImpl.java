package com.wzn.mall.service.impl;

import com.wzn.mall.entity.PermissionApiResourceRelation;
import com.wzn.mall.entity.vo.PermissionApiResourceRelationVo;
import com.wzn.mall.entity.PermissionApiResourceRelationExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.PermissionApiResourceRelationMapper;
import com.wzn.mall.service.PermissionApiResourceRelationService;
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
 * @since 2020-04-15 14:51:35
 */
@Service("permissionApiResourceRelationService")
public class PermissionApiResourceRelationServiceImpl implements PermissionApiResourceRelationService {
    @Resource
    private PermissionApiResourceRelationMapper permissionApiResourceRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PermissionApiResourceRelationVo queryPermissionApiResourceRelationById(Long id) {
        PermissionApiResourceRelationExample example = new PermissionApiResourceRelationExample();
        example.createCriteria().andIdEqualTo(id);
        PermissionApiResourceRelation permissionApiResourceRelation =this.permissionApiResourceRelationMapper.selectOneByExample(id);
        PermissionApiResourceRelationVo vo = new PermissionApiResourceRelationVo();
        BeanUtils.copyProperties(permissionApiResourceRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<PermissionApiResourceRelationVo> queryPermissionApiResourceRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PermissionApiResourceRelationExample example = new PermissionApiResourceRelationExample();
        List<PermissionApiResourceRelation> permissionApiResourceRelationList = this.permissionApiResourceRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(permissionApiResourceRelationList)){
            return null;
        }
        List<PermissionApiResourceRelationVo>  permissionApiResourceRelationVoList= new ArrayList<>(permissionApiResourceRelationList.size());
        permissionApiResourceRelationList.stream().forEach(p->{
            PermissionApiResourceRelationVo permissionApiResourceRelationVo = new PermissionApiResourceRelationVo();
            BeanUtils.copyProperties(p,permissionApiResourceRelationVo);
            permissionApiResourceRelationVoList.add(permissionApiResourceRelationVo);
        });
        return permissionApiResourceRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<PermissionApiResourceRelationVo> queryPermissionApiResourceRelationByCondition(Object object) {
        PermissionApiResourceRelationExample example = new PermissionApiResourceRelationExample();
        List<PermissionApiResourceRelation> permissionApiResourceRelationList =this.permissionApiResourceRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(permissionApiResourceRelationList)){
            return null;
        }
        List<PermissionApiResourceRelationVo>  permissionApiResourceRelationVoList= new ArrayList<>(permissionApiResourceRelationList.size());
        permissionApiResourceRelationList.stream().forEach(p->{
            PermissionApiResourceRelationVo permissionApiResourceRelationVo = new PermissionApiResourceRelationVo();
            BeanUtils.copyProperties(p,permissionApiResourceRelationVo);
            permissionApiResourceRelationVoList.add(permissionApiResourceRelationVo);
        });
        return permissionApiResourceRelationVoList;
    }
    /**
     * 新增数据
     * @param permissionApiResourceRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public PermissionApiResourceRelationVo add(PermissionApiResourceRelationDto permissionApiResourceRelationDto) {
        PermissionApiResourceRelation permissionApiResourceRelation = new PermissionApiResourceRelation();
        BeanUtils.copyProperties(permissionApiResourceRelationDto,permissionApiResourceRelation);
        this.permissionApiResourceRelationMapper.insertUseGeneratedKeys(permissionApiResourceRelation);
        PermissionApiResourceRelationVo vo = new PermissionApiResourceRelationVo();
        BeanUtils.copyProperties(permissionApiResourceRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param permissionApiResourceRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(PermissionApiResourceRelationDto permissionApiResourceRelationDto) {
     PermissionApiResourceRelation permissionApiResourceRelation = new PermissionApiResourceRelation();
      BeanUtils.copyProperties(permissionApiResourceRelationDto,permissionApiResourceRelation);
     return this.permissionApiResourceRelationMapper.updateByPrimaryKeySelective(permissionApiResourceRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        PermissionApiResourceRelationExample example = new PermissionApiResourceRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.permissionApiResourceRelationMapper.deleteByPrimaryKey(example) > 0;
    }
}