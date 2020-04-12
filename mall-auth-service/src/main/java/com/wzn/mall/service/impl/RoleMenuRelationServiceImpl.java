package com.wzn.mall.service.impl;

import com.wzn.mall.entity.RoleMenuRelation;
import com.wzn.mall.entity.vo.RoleMenuRelationVo;
import com.wzn.mall.entity.RoleMenuRelationExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.RoleMenuRelationMapper;
import com.wzn.mall.service.RoleMenuRelationService;
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
 * @since 2020-04-12 16:48:31
 */
@Service("roleMenuRelationService")
public class RoleMenuRelationServiceImpl implements RoleMenuRelationService {
    @Resource
    private RoleMenuRelationMapper roleMenuRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleMenuRelationVo queryRoleMenuRelationById(Long id) {
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        example.createCriteria().andIdEqualTo(id);
        RoleMenuRelation roleMenuRelation =this.roleMenuRelationMapper.selectOneByExample(id);
        RoleMenuRelationVo vo = new RoleMenuRelationVo();
        BeanUtils.copyProperties(roleMenuRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleMenuRelationVo> queryRoleMenuRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        List<RoleMenuRelation> roleMenuRelationList = this.roleMenuRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(roleMenuRelationList)){
            return null;
        }
        List<RoleMenuRelationVo>  roleMenuRelationVoList= new ArrayList<>(roleMenuRelationList.size());
        roleMenuRelationList.stream().forEach(p->{
            RoleMenuRelationVo roleMenuRelationVo = new RoleMenuRelationVo();
            BeanUtils.copyProperties(p,roleMenuRelationVo);
            roleMenuRelationVoList.add(roleMenuRelationVo);
        });
        return roleMenuRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<RoleMenuRelationVo> queryRoleMenuRelationByCondition(Object object) {
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        List<RoleMenuRelation> roleMenuRelationList =this.roleMenuRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(roleMenuRelationList)){
            return null;
        }
        List<RoleMenuRelationVo>  roleMenuRelationVoList= new ArrayList<>(roleMenuRelationList.size());
        roleMenuRelationList.stream().forEach(p->{
            RoleMenuRelationVo roleMenuRelationVo = new RoleMenuRelationVo();
            BeanUtils.copyProperties(p,roleMenuRelationVo);
            roleMenuRelationVoList.add(roleMenuRelationVo);
        });
        return roleMenuRelationVoList;
    }
    /**
     * 新增数据
     * @param roleMenuRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenuRelationVo add(RoleMenuRelationDto roleMenuRelationDto) {
        RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
        BeanUtils.copyProperties(roleMenuRelationDto,roleMenuRelation);
        this.roleMenuRelationMapper.insertUseGeneratedKeys(roleMenuRelation);
        RoleMenuRelationVo vo = new RoleMenuRelationVo();
        BeanUtils.copyProperties(roleMenuRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param roleMenuRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(RoleMenuRelationDto roleMenuRelationDto) {
     RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
      BeanUtils.copyProperties(roleMenuRelationDto,roleMenuRelation);
     return this.roleMenuRelationMapper.updateByPrimaryKeySelective(roleMenuRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.roleMenuRelationMapper.deleteByPrimaryKey(example) > 0;
    }
}