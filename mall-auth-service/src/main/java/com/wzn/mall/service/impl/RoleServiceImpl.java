package com.wzn.mall.service.impl;

import com.wzn.mall.entity.Role;
import com.wzn.mall.entity.vo.RoleVo;
import com.wzn.mall.entity.RoleExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.RoleMapper;
import com.wzn.mall.service.RoleService;
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
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleVo queryRoleById(Long id) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdEqualTo(id);
        Role role =this.roleMapper.selectOneByExample(id);
        RoleVo vo = new RoleVo();
        BeanUtils.copyProperties(role,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleVo> queryRoleByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        RoleExample example = new RoleExample();
        List<Role> roleList = this.roleMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(roleList)){
            return null;
        }
        List<RoleVo>  roleVoList= new ArrayList<>(roleList.size());
        roleList.stream().forEach(p->{
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(p,roleVo);
            roleVoList.add(roleVo);
        });
        return roleVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<RoleVo> queryRoleByCondition(Object object) {
        RoleExample example = new RoleExample();
        List<Role> roleList =this.roleMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(roleList)){
            return null;
        }
        List<RoleVo>  roleVoList= new ArrayList<>(roleList.size());
        roleList.stream().forEach(p->{
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(p,roleVo);
            roleVoList.add(roleVo);
        });
        return roleVoList;
    }
    /**
     * 新增数据
     * @param roleDto 实例对象
     * @return 实例对象
     */
    @Override
    public RoleVo add(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto,role);
        this.roleMapper.insertUseGeneratedKeys(role);
        RoleVo vo = new RoleVo();
        BeanUtils.copyProperties(role,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param roleDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(RoleDto roleDto) {
     Role role = new Role();
      BeanUtils.copyProperties(roleDto,role);
     return this.roleMapper.updateByPrimaryKeySelective(role)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdEqualTo(id);
        return this.roleMapper.deleteByPrimaryKey(example) > 0;
    }
}