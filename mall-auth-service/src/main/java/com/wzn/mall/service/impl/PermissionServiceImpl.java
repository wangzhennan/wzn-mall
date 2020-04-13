package com.wzn.mall.service.impl;

import com.wzn.mall.entity.Permission;
import com.wzn.mall.entity.vo.PermissionVo;
import com.wzn.mall.entity.PermissionExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.PermissionMapper;
import com.wzn.mall.service.PermissionService;
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
 * @since 2020-04-13 19:16:39
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PermissionVo queryPermissionById(Long id) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andIdEqualTo(id);
        Permission permission =this.permissionMapper.selectOneByExample(id);
        PermissionVo vo = new PermissionVo();
        BeanUtils.copyProperties(permission,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<PermissionVo> queryPermissionByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PermissionExample example = new PermissionExample();
        List<Permission> permissionList = this.permissionMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(permissionList)){
            return null;
        }
        List<PermissionVo>  permissionVoList= new ArrayList<>(permissionList.size());
        permissionList.stream().forEach(p->{
            PermissionVo permissionVo = new PermissionVo();
            BeanUtils.copyProperties(p,permissionVo);
            permissionVoList.add(permissionVo);
        });
        return permissionVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<PermissionVo> queryPermissionByCondition(Object object) {
        PermissionExample example = new PermissionExample();
        List<Permission> permissionList =this.permissionMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(permissionList)){
            return null;
        }
        List<PermissionVo>  permissionVoList= new ArrayList<>(permissionList.size());
        permissionList.stream().forEach(p->{
            PermissionVo permissionVo = new PermissionVo();
            BeanUtils.copyProperties(p,permissionVo);
            permissionVoList.add(permissionVo);
        });
        return permissionVoList;
    }
    /**
     * 新增数据
     * @param permissionDto 实例对象
     * @return 实例对象
     */
    @Override
    public PermissionVo add(PermissionDto permissionDto) {
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionDto,permission);
        this.permissionMapper.insertUseGeneratedKeys(permission);
        PermissionVo vo = new PermissionVo();
        BeanUtils.copyProperties(permission,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param permissionDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(PermissionDto permissionDto) {
     Permission permission = new Permission();
      BeanUtils.copyProperties(permissionDto,permission);
     return this.permissionMapper.updateByPrimaryKeySelective(permission)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andIdEqualTo(id);
        return this.permissionMapper.deleteByPrimaryKey(example) > 0;
    }
}