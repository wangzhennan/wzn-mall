package com.wzn.mall.service.impl;

import com.wzn.mall.entity.AdminLog;
import com.wzn.mall.entity.vo.AdminLogVo;
import com.wzn.mall.entity.AdminLogExample;
import com.wzn.mall.entity.dto.*;
import com.wzn.mall.mapper.AdminLogMapper;
import com.wzn.mall.service.AdminLogService;
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
 * @since 2020-04-15 15:27:31
 */
@Service("adminLogService")
public class AdminLogServiceImpl implements AdminLogService {
    @Resource
    private AdminLogMapper adminLogMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminLogVo queryAdminLogById(Long id) {
        AdminLogExample example = new AdminLogExample();
        example.createCriteria().andIdEqualTo(id);
        AdminLog adminLog =this.adminLogMapper.selectOneByExample(id);
        AdminLogVo vo = new AdminLogVo();
        BeanUtils.copyProperties(adminLog,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminLogVo> queryAdminLogByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        AdminLogExample example = new AdminLogExample();
        List<AdminLog> adminLogList = this.adminLogMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(adminLogList)){
            return null;
        }
        List<AdminLogVo>  adminLogVoList= new ArrayList<>(adminLogList.size());
        adminLogList.stream().forEach(p->{
            AdminLogVo adminLogVo = new AdminLogVo();
            BeanUtils.copyProperties(p,adminLogVo);
            adminLogVoList.add(adminLogVo);
        });
        return adminLogVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<AdminLogVo> queryAdminLogByCondition(Object object) {
        AdminLogExample example = new AdminLogExample();
        List<AdminLog> adminLogList =this.adminLogMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(adminLogList)){
            return null;
        }
        List<AdminLogVo>  adminLogVoList= new ArrayList<>(adminLogList.size());
        adminLogList.stream().forEach(p->{
            AdminLogVo adminLogVo = new AdminLogVo();
            BeanUtils.copyProperties(p,adminLogVo);
            adminLogVoList.add(adminLogVo);
        });
        return adminLogVoList;
    }
    /**
     * 新增数据
     * @param adminLogDto 实例对象
     * @return 实例对象
     */
    @Override
    public AdminLogVo add(AdminLogDto adminLogDto) {
        AdminLog adminLog = new AdminLog();
        BeanUtils.copyProperties(adminLogDto,adminLog);
        this.adminLogMapper.insertUseGeneratedKeys(adminLog);
        AdminLogVo vo = new AdminLogVo();
        BeanUtils.copyProperties(adminLog,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param adminLogDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(AdminLogDto adminLogDto) {
     AdminLog adminLog = new AdminLog();
      BeanUtils.copyProperties(adminLogDto,adminLog);
     return this.adminLogMapper.updateByPrimaryKeySelective(adminLog)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        AdminLogExample example = new AdminLogExample();
        example.createCriteria().andIdEqualTo(id);
        return this.adminLogMapper.deleteByPrimaryKey(example) > 0;
    }
}