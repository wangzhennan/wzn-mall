package com.wzn.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzn.mall.entity.Role;
import com.wzn.mall.entity.RoleExample;
import com.wzn.mall.entity.RolePermissionRelation;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.dto.RoleDto;
import com.wzn.mall.entity.dto.RoleQueryParam;
import com.wzn.mall.entity.vo.RoleVo;
import com.wzn.mall.mapper.RoleMapper;
import com.wzn.mall.service.RolePermissionRelationService;
import com.wzn.mall.service.RoleService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 实现类
 * @author wangzhennan
 * @since 2020-04-15 14:51:36
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionRelationService rolePermissionRelationService;

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
        if (null != role) {
            BeanUtils.copyProperties(role, vo);
            return vo;
        }
        return null;
    }

    /**
     * 按条件查询分页
     * @return 对象列表
     */
    @Override
    public PageInfo<List<RoleVo>> queryRoleByConditionPage(RoleQueryParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if (Strings.isNotEmpty(param.getRoleName())) {
            criteria.andNameEqualTo(param.getRoleName());
        }
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
        PageInfo info = new PageInfo(roleList);
        info.setList(roleVoList);
        return info;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<RoleVo> queryRoleByCondition(RoleQueryParam param) {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if (Strings.isNotEmpty(param.getRoleName())) {
            criteria.andNameEqualTo(param.getRoleName());
        }
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
        role.setCtime(new Date());
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
        return this.roleMapper.deleteByExample(example) > 0;
    }

    @Override
    public boolean addPermission(BindingObjectDto bindingObjectDto) {
        if (null == bindingObjectDto && CollectionUtils.isEmpty(bindingObjectDto.getObjectList())) {
            return false;
        }
        List<Long> objectList = bindingObjectDto.getObjectList();
        List<RolePermissionRelation> relationList = new ArrayList<>(objectList.size());
        objectList.stream().forEach(p -> {
            RolePermissionRelation rolePermissionRelation = new RolePermissionRelation();
            rolePermissionRelation.setRoleId(bindingObjectDto.getId());
            rolePermissionRelation.setPermissionId(p);
            relationList.add(rolePermissionRelation);
        });
        return rolePermissionRelationService.addList(relationList);
    }
}