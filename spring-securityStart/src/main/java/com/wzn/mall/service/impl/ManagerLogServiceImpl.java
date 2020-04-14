package com.wzn.mall.service.impl;

import com.wzn.mall.entity.ManagerLog;
import com.wzn.mall.entity.vo.ManagerLogVo;
import com.wzn.mall.entity.ManagerLogExample;
import com.wzn.mall.mapper.ManagerLogMapper;
import com.wzn.mall.service.ManagerLogService;
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
 * @since 2020-04-14 21:55:25
 */
@Service("managerLogService")
public class ManagerLogServiceImpl implements ManagerLogService {
    @Resource
    private ManagerLogMapper managerLogMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ManagerLogVo queryManagerLogById(Long id) {
        ManagerLogExample example = new ManagerLogExample();
        example.createCriteria().andIdEqualTo(id);
        ManagerLog managerLog =this.managerLogMapper.selectOneByExample(id);
        ManagerLogVo vo = new ManagerLogVo();
        BeanUtils.copyProperties(managerLog,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<ManagerLogVo> queryManagerLogByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ManagerLogExample example = new ManagerLogExample();
        List<ManagerLog> managerLogList = this.managerLogMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(managerLogList)){
            return null;
        }
        List<ManagerLogVo>  managerLogVoList= new ArrayList<>(managerLogList.size());
        managerLogList.stream().forEach(p->{
            ManagerLogVo managerLogVo = new ManagerLogVo();
            BeanUtils.copyProperties(p,managerLogVo);
            managerLogVoList.add(managerLogVo);
        });
        return managerLogVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<ManagerLogVo> queryManagerLogByCondition(Object object) {
        ManagerLogExample example = new ManagerLogExample();
        List<ManagerLog> managerLogList =this.managerLogMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(managerLogList)){
            return null;
        }
        List<ManagerLogVo>  managerLogVoList= new ArrayList<>(managerLogList.size());
        managerLogList.stream().forEach(p->{
            ManagerLogVo managerLogVo = new ManagerLogVo();
            BeanUtils.copyProperties(p,managerLogVo);
            managerLogVoList.add(managerLogVo);
        });
        return managerLogVoList;
    }
    /**
     * 新增数据
     * @param managerLogDto 实例对象
     * @return 实例对象
     */
    @Override
    public ManagerLogVo add(ManagerLogDto managerLogDto) {
        ManagerLog managerLog = new ManagerLog();
        BeanUtils.copyProperties(managerLogDto,managerLog);
        this.managerLogMapper.insertUseGeneratedKeys(managerLog);
        ManagerLogVo vo = new ManagerLogVo();
        BeanUtils.copyProperties(managerLog,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param managerLogDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(ManagerLogDto managerLogDto) {
     ManagerLog managerLog = new ManagerLog();
      BeanUtils.copyProperties(managerLogDto,managerLog);
     return this.managerLogMapper.updateByPrimaryKeySelective(managerLog)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        ManagerLogExample example = new ManagerLogExample();
        example.createCriteria().andIdEqualTo(id);
        return this.managerLogMapper.deleteByPrimaryKey(example) > 0;
    }
}