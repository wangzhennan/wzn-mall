package com.wzn.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzn.mall.entity.Admin;
import com.wzn.mall.entity.AdminExample;
import com.wzn.mall.entity.AdminRoleRelation;
import com.wzn.mall.entity.dto.AdminDto;
import com.wzn.mall.entity.dto.AdminQueryParam;
import com.wzn.mall.entity.dto.AdminRoleRelationDto;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.vo.AdminRoleRelationVo;
import com.wzn.mall.entity.vo.AdminVo;
import com.wzn.mall.mapper.AdminMapper;
import com.wzn.mall.service.AdminRoleRelationService;
import com.wzn.mall.service.AdminService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现类
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Autowired
    private AdminRoleRelationService adminRoleRelationService;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminVo queryAdminById(Long id) {

        AdminExample example = new AdminExample();
        example.createCriteria().andIdEqualTo(id);
        Admin admin =this.adminMapper.selectOneByExample(example);
        AdminVo vo = new AdminVo();
        if(null != admin){
            BeanUtils.copyProperties(admin,vo);
            return vo;
        }
        return null;
    }

    /**
     * 按条件查询分页
     * @param param
     * @return 对象列表
     */
    @Override
    public PageInfo<List<AdminVo>> queryAdminByConditionPage(AdminQueryParam param) {
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if( Strings.isNotEmpty(param.getName())){
            criteria.andUsernameLike("%"+param.getName());
        }
        if(null != param.getRoleId()){
            AdminRoleRelationDto dto = new AdminRoleRelationDto();
            dto.setRoleId(param.getRoleId());
            List<AdminRoleRelationVo> adminRoleRelationVos = adminRoleRelationService.queryAdminRoleRelationByCondition(dto);
            List<Long> adminIds = adminRoleRelationVos.stream().map(AdminRoleRelationVo::getAdminId).collect(Collectors.toList());
            criteria.andIdIn(adminIds);
        }
        List<Admin> adminList = this.adminMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(adminList)){
            return null;
        }
        List<AdminVo>  adminVoList= new ArrayList<>(adminList.size());
        adminList.stream().forEach(p->{
            AdminVo adminVo = new AdminVo();
            BeanUtils.copyProperties(p,adminVo);
            adminVoList.add(adminVo);
        });
        PageInfo pageInfo  = new PageInfo(adminList);
        pageInfo.setList(adminVoList);
        return pageInfo;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<AdminVo> queryAdminByCondition( AdminQueryParam param) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if( Strings.isNotEmpty(param.getName())){
            criteria.andUsernameLike("%"+param.getName());
        }
        if(null != param.getRoleId()){
            AdminRoleRelationDto dto = new AdminRoleRelationDto();
            dto.setRoleId(param.getRoleId());
            List<AdminRoleRelationVo> adminRoleRelationVos = adminRoleRelationService.queryAdminRoleRelationByCondition(dto);
            List<Long> adminIds = adminRoleRelationVos.stream().map(AdminRoleRelationVo::getAdminId).collect(Collectors.toList());
            criteria.andIdIn(adminIds);
        }
        List<Admin> adminList =this.adminMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(adminList)){
            return null;
        }
        List<AdminVo>  adminVoList= new ArrayList<>(adminList.size());
        adminList.stream().forEach(p->{
            AdminVo adminVo = new AdminVo();
            BeanUtils.copyProperties(p,adminVo);
            adminVoList.add(adminVo);
        });
        return adminVoList;
    }
    /**
     * 新增数据
     * @param adminDto 实例对象
     * @return 实例对象
     */
    @Override
    public AdminVo add(AdminDto adminDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto,admin);
        admin.setPassword(new BCryptPasswordEncoder().encode(adminDto.getPassword()));
        admin.setCtime(new Date());
        this.adminMapper.insertUseGeneratedKeys(admin);
        AdminVo vo = new AdminVo();
        BeanUtils.copyProperties(admin,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param adminDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(AdminDto adminDto) {
     Admin admin = new Admin();
      BeanUtils.copyProperties(adminDto,admin);
     return this.adminMapper.updateByPrimaryKeySelective(admin)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        AdminExample example = new AdminExample();
        example.createCriteria().andIdEqualTo(id);
        return this.adminMapper.deleteByExample(example) > 0;
    }

    @Override
    public boolean adminAddRole(BindingObjectDto bindingObjectDto) {

        if(null != bindingObjectDto && CollectionUtils.isEmpty(bindingObjectDto.getObjectList())){
            return false;
        }
        List<Long> objectList = bindingObjectDto.getObjectList();
        List<AdminRoleRelation> relationList = new ArrayList<>(objectList.size());
        objectList.stream().forEach(p->{
            AdminRoleRelation roleRelation = new AdminRoleRelation();
            roleRelation.setAdminId(bindingObjectDto.getId());
            roleRelation.setRoleId(p);
            relationList.add(roleRelation);
        });
        return adminRoleRelationService.addList(relationList);
    }
}