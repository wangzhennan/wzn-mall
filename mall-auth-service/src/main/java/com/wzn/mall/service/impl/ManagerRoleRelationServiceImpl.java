package com.wzn.mall.service.impl;

import com.wzn.mall.entity.ManagerRoleRelation;
import com.wzn.mall.entity.vo.ManagerRoleRelationVo;
import com.wzn.mall.entity.ManagerRoleRelationExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.ManagerRoleRelationMapper;
import com.wzn.mall.service.ManagerRoleRelationService;
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
@Service("managerRoleRelationService")
public class ManagerRoleRelationServiceImpl implements ManagerRoleRelationService {
    @Resource
    private ManagerRoleRelationMapper managerRoleRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ManagerRoleRelationVo queryManagerRoleRelationById(Long id) {
        ManagerRoleRelationExample example = new ManagerRoleRelationExample();
        example.createCriteria().andIdEqualTo(id);
        ManagerRoleRelation managerRoleRelation =this.managerRoleRelationMapper.selectOneByExample(id);
        ManagerRoleRelationVo vo = new ManagerRoleRelationVo();
        BeanUtils.copyProperties(managerRoleRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<ManagerRoleRelationVo> queryManagerRoleRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ManagerRoleRelationExample example = new ManagerRoleRelationExample();
        List<ManagerRoleRelation> managerRoleRelationList = this.managerRoleRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(managerRoleRelationList)){
            return null;
        }
        List<ManagerRoleRelationVo>  managerRoleRelationVoList= new ArrayList<>(managerRoleRelationList.size());
        managerRoleRelationList.stream().forEach(p->{
            ManagerRoleRelationVo managerRoleRelationVo = new ManagerRoleRelationVo();
            BeanUtils.copyProperties(p,managerRoleRelationVo);
            managerRoleRelationVoList.add(managerRoleRelationVo);
        });
        return managerRoleRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<ManagerRoleRelationVo> queryManagerRoleRelationByCondition(Object object) {
        ManagerRoleRelationExample example = new ManagerRoleRelationExample();
        List<ManagerRoleRelation> managerRoleRelationList =this.managerRoleRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(managerRoleRelationList)){
            return null;
        }
        List<ManagerRoleRelationVo>  managerRoleRelationVoList= new ArrayList<>(managerRoleRelationList.size());
        managerRoleRelationList.stream().forEach(p->{
            ManagerRoleRelationVo managerRoleRelationVo = new ManagerRoleRelationVo();
            BeanUtils.copyProperties(p,managerRoleRelationVo);
            managerRoleRelationVoList.add(managerRoleRelationVo);
        });
        return managerRoleRelationVoList;
    }
    /**
     * 新增数据
     * @param managerRoleRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public ManagerRoleRelationVo add(ManagerRoleRelationDto managerRoleRelationDto) {
        ManagerRoleRelation managerRoleRelation = new ManagerRoleRelation();
        BeanUtils.copyProperties(managerRoleRelationDto,managerRoleRelation);
        this.managerRoleRelationMapper.insertUseGeneratedKeys(managerRoleRelation);
        ManagerRoleRelationVo vo = new ManagerRoleRelationVo();
        BeanUtils.copyProperties(managerRoleRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param managerRoleRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(ManagerRoleRelationDto managerRoleRelationDto) {
     ManagerRoleRelation managerRoleRelation = new ManagerRoleRelation();
      BeanUtils.copyProperties(managerRoleRelationDto,managerRoleRelation);
     return this.managerRoleRelationMapper.updateByPrimaryKeySelective(managerRoleRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        ManagerRoleRelationExample example = new ManagerRoleRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.managerRoleRelationMapper.deleteByPrimaryKey(example) > 0;
    }
}