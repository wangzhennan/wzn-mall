package com.wzn.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.wzn.mall.entity.RolePermissionRelation;
import com.wzn.mall.entity.RolePermissionRelationExample;
import com.wzn.mall.entity.dto.RolePermissionRelationDto;
import com.wzn.mall.entity.vo.RolePermissionRelationVo;
import com.wzn.mall.mapper.RolePermissionRelationMapper;
import com.wzn.mall.service.RolePermissionRelationService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
@Service("rolePermissionRelationService")
public class RolePermissionRelationServiceImpl implements RolePermissionRelationService {
    @Resource
    private RolePermissionRelationMapper rolePermissionRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RolePermissionRelationVo queryRolePermissionRelationById(Long id) {
        RolePermissionRelationExample example = new RolePermissionRelationExample();
        example.createCriteria().andIdEqualTo(id);
        RolePermissionRelation rolePermissionRelation =this.rolePermissionRelationMapper.selectOneByExample(id);
        RolePermissionRelationVo vo = new RolePermissionRelationVo();
        BeanUtils.copyProperties(rolePermissionRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<RolePermissionRelationVo> queryRolePermissionRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        RolePermissionRelationExample example = new RolePermissionRelationExample();
        List<RolePermissionRelation> rolePermissionRelationList = this.rolePermissionRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(rolePermissionRelationList)){
            return null;
        }
        List<RolePermissionRelationVo>  rolePermissionRelationVoList= new ArrayList<>(rolePermissionRelationList.size());
        rolePermissionRelationList.stream().forEach(p->{
            RolePermissionRelationVo rolePermissionRelationVo = new RolePermissionRelationVo();
            BeanUtils.copyProperties(p,rolePermissionRelationVo);
            rolePermissionRelationVoList.add(rolePermissionRelationVo);
        });
        return rolePermissionRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<RolePermissionRelationVo> queryRolePermissionRelationByCondition(Object object) {
        RolePermissionRelationExample example = new RolePermissionRelationExample();
        List<RolePermissionRelation> rolePermissionRelationList =this.rolePermissionRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(rolePermissionRelationList)){
            return null;
        }
        List<RolePermissionRelationVo>  rolePermissionRelationVoList= new ArrayList<>(rolePermissionRelationList.size());
        rolePermissionRelationList.stream().forEach(p->{
            RolePermissionRelationVo rolePermissionRelationVo = new RolePermissionRelationVo();
            BeanUtils.copyProperties(p,rolePermissionRelationVo);
            rolePermissionRelationVoList.add(rolePermissionRelationVo);
        });
        return rolePermissionRelationVoList;
    }
    /**
     * 新增数据
     * @param rolePermissionRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public RolePermissionRelationVo add(RolePermissionRelationDto rolePermissionRelationDto) {
        RolePermissionRelation rolePermissionRelation = new RolePermissionRelation();
        BeanUtils.copyProperties(rolePermissionRelationDto,rolePermissionRelation);
        this.rolePermissionRelationMapper.insertUseGeneratedKeys(rolePermissionRelation);
        RolePermissionRelationVo vo = new RolePermissionRelationVo();
        BeanUtils.copyProperties(rolePermissionRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param rolePermissionRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(RolePermissionRelationDto rolePermissionRelationDto) {
     RolePermissionRelation rolePermissionRelation = new RolePermissionRelation();
      BeanUtils.copyProperties(rolePermissionRelationDto,rolePermissionRelation);
     return this.rolePermissionRelationMapper.updateByPrimaryKeySelective(rolePermissionRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        RolePermissionRelationExample example = new RolePermissionRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.rolePermissionRelationMapper.deleteByPrimaryKey(example) > 0;
    }

    @Override
    public boolean addList(List<RolePermissionRelation> relationList) {
        return rolePermissionRelationMapper.insertList(relationList)>0;
    }
}