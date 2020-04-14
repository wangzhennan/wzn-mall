package com.wzn.mall.service.impl;

import com.wzn.mall.entity.ManagerPermissionRelation;
import com.wzn.mall.entity.vo.ManagerPermissionRelationVo;
import com.wzn.mall.entity.ManagerPermissionRelationExample;
import com.wzn.mall.mapper.ManagerPermissionRelationMapper;
import com.wzn.mall.service.ManagerPermissionRelationService;
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
 * @since 2020-04-14 21:53:19
 */
@Service("managerPermissionRelationService")
public class ManagerPermissionRelationServiceImpl implements ManagerPermissionRelationService {
    @Resource
    private ManagerPermissionRelationMapper managerPermissionRelationMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ManagerPermissionRelationVo queryManagerPermissionRelationById(Long id) {
        ManagerPermissionRelationExample example = new ManagerPermissionRelationExample();
        example.createCriteria().andIdEqualTo(id);
        ManagerPermissionRelation managerPermissionRelation =this.managerPermissionRelationMapper.selectOneByExample(id);
        ManagerPermissionRelationVo vo = new ManagerPermissionRelationVo();
        BeanUtils.copyProperties(managerPermissionRelation,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<ManagerPermissionRelationVo> queryManagerPermissionRelationByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ManagerPermissionRelationExample example = new ManagerPermissionRelationExample();
        List<ManagerPermissionRelation> managerPermissionRelationList = this.managerPermissionRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(managerPermissionRelationList)){
            return null;
        }
        List<ManagerPermissionRelationVo>  managerPermissionRelationVoList= new ArrayList<>(managerPermissionRelationList.size());
        managerPermissionRelationList.stream().forEach(p->{
            ManagerPermissionRelationVo managerPermissionRelationVo = new ManagerPermissionRelationVo();
            BeanUtils.copyProperties(p,managerPermissionRelationVo);
            managerPermissionRelationVoList.add(managerPermissionRelationVo);
        });
        return managerPermissionRelationVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<ManagerPermissionRelationVo> queryManagerPermissionRelationByCondition(Object object) {
        ManagerPermissionRelationExample example = new ManagerPermissionRelationExample();
        List<ManagerPermissionRelation> managerPermissionRelationList =this.managerPermissionRelationMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(managerPermissionRelationList)){
            return null;
        }
        List<ManagerPermissionRelationVo>  managerPermissionRelationVoList= new ArrayList<>(managerPermissionRelationList.size());
        managerPermissionRelationList.stream().forEach(p->{
            ManagerPermissionRelationVo managerPermissionRelationVo = new ManagerPermissionRelationVo();
            BeanUtils.copyProperties(p,managerPermissionRelationVo);
            managerPermissionRelationVoList.add(managerPermissionRelationVo);
        });
        return managerPermissionRelationVoList;
    }
    /**
     * 新增数据
     * @param managerPermissionRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public ManagerPermissionRelationVo add(ManagerPermissionRelationDto managerPermissionRelationDto) {
        ManagerPermissionRelation managerPermissionRelation = new ManagerPermissionRelation();
        BeanUtils.copyProperties(managerPermissionRelationDto,managerPermissionRelation);
        this.managerPermissionRelationMapper.insertUseGeneratedKeys(managerPermissionRelation);
        ManagerPermissionRelationVo vo = new ManagerPermissionRelationVo();
        BeanUtils.copyProperties(managerPermissionRelation,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param managerPermissionRelationDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(ManagerPermissionRelationDto managerPermissionRelationDto) {
     ManagerPermissionRelation managerPermissionRelation = new ManagerPermissionRelation();
      BeanUtils.copyProperties(managerPermissionRelationDto,managerPermissionRelation);
     return this.managerPermissionRelationMapper.updateByPrimaryKeySelective(managerPermissionRelation)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        ManagerPermissionRelationExample example = new ManagerPermissionRelationExample();
        example.createCriteria().andIdEqualTo(id);
        return this.managerPermissionRelationMapper.deleteByPrimaryKey(example) > 0;
    }
}