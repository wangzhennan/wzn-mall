package com.wzn.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.wzn.mall.entity.AdminRoleRelation;
import com.wzn.mall.entity.AdminRoleRelationExample;
import com.wzn.mall.entity.dto.AdminRoleRelationDto;
import com.wzn.mall.entity.vo.AdminRoleRelationVo;
import com.wzn.mall.mapper.AdminRoleRelationMapper;
import com.wzn.mall.service.AdminRoleRelationService;
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
@Service("adminRoleRelationService")
public class AdminRoleRelationServiceImpl implements AdminRoleRelationService {
    @Resource
    private AdminRoleRelationMapper adminRoleRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminRoleRelationVo queryAdminRoleRelationById(Long id) {
        AdminRoleRelationExample example = new AdminRoleRelationExample();
        example.createCriteria().andIdEqualTo(id);
        AdminRoleRelation adminRoleRelation =this.adminRoleRelationMapper.selectOneByExample(id);
        AdminRoleRelationVo vo = new AdminRoleRelationVo();
        BeanUtils.copyProperties(adminRoleRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminRoleRelationVo> queryAdminRoleRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        AdminRoleRelationExample example = new AdminRoleRelationExample();
        List<AdminRoleRelation> adminRoleRelationList = this.adminRoleRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(adminRoleRelationList)){
            return null;
        }
        List<AdminRoleRelationVo>  adminRoleRelationVoList= new ArrayList<>(adminRoleRelationList.size());
        adminRoleRelationList.stream().forEach(p->{
            AdminRoleRelationVo adminRoleRelationVo = new AdminRoleRelationVo();
            BeanUtils.copyProperties(p,adminRoleRelationVo);
            adminRoleRelationVoList.add(adminRoleRelationVo);
        });
        return adminRoleRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<AdminRoleRelationVo> queryAdminRoleRelationByCondition(AdminRoleRelationDto object) {
        AdminRoleRelationExample example = new AdminRoleRelationExample();
        List<AdminRoleRelation> adminRoleRelationList =this.adminRoleRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(adminRoleRelationList)){
            return null;
        }
        List<AdminRoleRelationVo>  adminRoleRelationVoList= new ArrayList<>(adminRoleRelationList.size());
        adminRoleRelationList.stream().forEach(p->{
            AdminRoleRelationVo adminRoleRelationVo = new AdminRoleRelationVo();
            BeanUtils.copyProperties(p,adminRoleRelationVo);
            adminRoleRelationVoList.add(adminRoleRelationVo);
        });
        return adminRoleRelationVoList;
    }
    /**
     * 新增数据
     * @param adminRoleRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public AdminRoleRelationVo add(AdminRoleRelationDto adminRoleRelationDto) {
        AdminRoleRelation adminRoleRelation = new AdminRoleRelation();
        BeanUtils.copyProperties(adminRoleRelationDto,adminRoleRelation);
        this.adminRoleRelationMapper.insertUseGeneratedKeys(adminRoleRelation);
        AdminRoleRelationVo vo = new AdminRoleRelationVo();
        BeanUtils.copyProperties(adminRoleRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param adminRoleRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(AdminRoleRelationDto adminRoleRelationDto) {
     AdminRoleRelation adminRoleRelation = new AdminRoleRelation();
      BeanUtils.copyProperties(adminRoleRelationDto,adminRoleRelation);
     return this.adminRoleRelationMapper.updateByPrimaryKeySelective(adminRoleRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        AdminRoleRelationExample example = new AdminRoleRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.adminRoleRelationMapper.deleteByPrimaryKey(example) > 0;
    }

    @Override
    public boolean addList(List<AdminRoleRelation> relationList) {
        return adminRoleRelationMapper.insertList(relationList)>0;
    }
}