package com.wzn.mall.service.impl;

import com.wzn.mall.entity.RoleResourceRelation;
import com.wzn.mall.entity.vo.RoleResourceRelationVo;
import com.wzn.mall.entity.RoleResourceRelationExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.RoleResourceRelationMapper;
import com.wzn.mall.service.RoleResourceRelationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 * @author wzn
 * @since 2020-04-13 19:16:41
 */
@Service("roleResourceRelationService")
public class RoleResourceRelationServiceImpl implements RoleResourceRelationService {
    @Resource
    private RoleResourceRelationMapper roleResourceRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleResourceRelationVo queryRoleResourceRelationById(Long id) {
        RoleResourceRelationExample example = new RoleResourceRelationExample();
        example.createCriteria().andIdEqualTo(id);
        RoleResourceRelation roleResourceRelation =this.roleResourceRelationMapper.selectOneByExample(id);
        RoleResourceRelationVo vo = new RoleResourceRelationVo();
        BeanUtils.copyProperties(roleResourceRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleResourceRelationVo> queryRoleResourceRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        RoleResourceRelationExample example = new RoleResourceRelationExample();
        List<RoleResourceRelation> roleResourceRelationList = this.roleResourceRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(roleResourceRelationList)){
            return null;
        }
        List<RoleResourceRelationVo>  roleResourceRelationVoList= new ArrayList<>(roleResourceRelationList.size());
        roleResourceRelationList.stream().forEach(p->{
            RoleResourceRelationVo roleResourceRelationVo = new RoleResourceRelationVo();
            BeanUtils.copyProperties(p,roleResourceRelationVo);
            roleResourceRelationVoList.add(roleResourceRelationVo);
        });
        return roleResourceRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<RoleResourceRelationVo> queryRoleResourceRelationByCondition(Object object) {
        RoleResourceRelationExample example = new RoleResourceRelationExample();
        List<RoleResourceRelation> roleResourceRelationList =this.roleResourceRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(roleResourceRelationList)){
            return null;
        }
        List<RoleResourceRelationVo>  roleResourceRelationVoList= new ArrayList<>(roleResourceRelationList.size());
        roleResourceRelationList.stream().forEach(p->{
            RoleResourceRelationVo roleResourceRelationVo = new RoleResourceRelationVo();
            BeanUtils.copyProperties(p,roleResourceRelationVo);
            roleResourceRelationVoList.add(roleResourceRelationVo);
        });
        return roleResourceRelationVoList;
    }
    /**
     * 新增数据
     * @param roleResourceRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public RoleResourceRelationVo add(RoleResourceRelationDto roleResourceRelationDto) {
        RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
        BeanUtils.copyProperties(roleResourceRelationDto,roleResourceRelation);
        this.roleResourceRelationMapper.insertUseGeneratedKeys(roleResourceRelation);
        RoleResourceRelationVo vo = new RoleResourceRelationVo();
        BeanUtils.copyProperties(roleResourceRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param roleResourceRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(RoleResourceRelationDto roleResourceRelationDto) {
     RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
      BeanUtils.copyProperties(roleResourceRelationDto,roleResourceRelation);
     return this.roleResourceRelationMapper.updateByPrimaryKeySelective(roleResourceRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        RoleResourceRelationExample example = new RoleResourceRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.roleResourceRelationMapper.deleteByPrimaryKey(example) > 0;
    }
}