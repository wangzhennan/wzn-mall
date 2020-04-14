package com.wzn.mall.service.impl;

import com.wzn.mall.entity.Manager;
import com.wzn.mall.entity.vo.ManagerVo;
import com.wzn.mall.entity.ManagerExample;
import com.wzn.mall.entity.dto.ManagerDto;
import com.wzn.mall.mapper.ManagerMapper;
import com.wzn.mall.service.ManagerService;
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
 * @since 2020-04-14 22:06:23
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ManagerVo queryManagerById(Long id) {
        ManagerExample example = new ManagerExample();
        example.createCriteria().andIdEqualTo(id);
        Manager manager =this.managerMapper.selectOneByExample(id);
        ManagerVo vo = new ManagerVo();
        BeanUtils.copyProperties(manager,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<ManagerVo> queryManagerByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ManagerExample example = new ManagerExample();
        List<Manager> managerList = this.managerMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(managerList)){
            return null;
        }
        List<ManagerVo>  managerVoList= new ArrayList<>(managerList.size());
        managerList.stream().forEach(p->{
            ManagerVo managerVo = new ManagerVo();
            BeanUtils.copyProperties(p,managerVo);
            managerVoList.add(managerVo);
        });
        return managerVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<ManagerVo> queryManagerByCondition(Object object) {
        ManagerExample example = new ManagerExample();
        List<Manager> managerList =this.managerMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(managerList)){
            return null;
        }
        List<ManagerVo>  managerVoList= new ArrayList<>(managerList.size());
        managerList.stream().forEach(p->{
            ManagerVo managerVo = new ManagerVo();
            BeanUtils.copyProperties(p,managerVo);
            managerVoList.add(managerVo);
        });
        return managerVoList;
    }
    /**
     * 新增数据
     * @param managerDto 实例对象
     * @return 实例对象
     */
    @Override
    public ManagerVo add(ManagerDto managerDto) {
        Manager manager = new Manager();
        BeanUtils.copyProperties(managerDto,manager);
        this.managerMapper.insertUseGeneratedKeys(manager);
        ManagerVo vo = new ManagerVo();
        BeanUtils.copyProperties(manager,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param managerDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(ManagerDto managerDto) {
     Manager manager = new Manager();
      BeanUtils.copyProperties(managerDto,manager);
     return this.managerMapper.updateByPrimaryKeySelective(manager)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        ManagerExample example = new ManagerExample();
        example.createCriteria().andIdEqualTo(id);
        return this.managerMapper.deleteByPrimaryKey(example) > 0;
    }
}