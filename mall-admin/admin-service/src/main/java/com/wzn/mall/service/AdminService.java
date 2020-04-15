package com.wzn.mall.service;

import com.github.pagehelper.PageInfo;
import com.wzn.mall.entity.dto.AdminDto;
import com.wzn.mall.entity.dto.AdminQueryParam;
import com.wzn.mall.entity.dto.BindingObjectDto;
import com.wzn.mall.entity.vo.AdminVo;

import java.util.List;

/**
 * AdminService服务
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
public interface AdminService {

    /**
     * 通过ID查询详情
     * @param id 主键
     * @return 实例对象
     */
    AdminVo queryAdminById(Long id);

    /**
     * 分页查
     * @paramObject object 条件
     * @return 对象列表
     */
    PageInfo<List<AdminVo>> queryAdminByConditionPage(AdminQueryParam param);

    /**
     * 条件查询无分页
     * @paramObject object 条件
     * @return 对象列表
     */
    List<AdminVo> queryAdminByCondition( AdminQueryParam param);

    /**
     * 新增数据
     *
     * @param adminDto 实例对象
     * @return 实例对象
     */
    AdminVo add(AdminDto adminDto);

    /**
     * 修改数据
     *
     * @param adminDto 实例对象
     * @return 实例对象
     */
    boolean edit(AdminDto adminDto);

    /**
     * 主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 绑定角色
     *
     * @param objectdto
     * @return
     */
    boolean adminAddRole(BindingObjectDto objectdto);
}