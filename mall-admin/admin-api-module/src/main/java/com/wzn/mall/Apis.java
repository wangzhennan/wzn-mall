package com.wzn.mall;

/**
 * @program: wzn-mall
 * @description: url定义类
 * @author: wangzhennan
 * @create: 2020-04-14 21:45
 **/
public interface Apis {
    /**
     * api资源
     */
    String APIRESOURCE = "/apiresource";

    /**
     * 管理员
     */
    String MANAGER = "/admin";

    /**
     * 菜单
     */
    String MENU = "/menu";

    String PERM = "/permission";

    /**
     * 角色
     */
    String ROLE = "/role";
    /**
     * 查询详情
     */
    String DETALS = "/query/detals";
    /**
     * 分页查询
     */
    String QUERY_PAGE = "/query/page";
    /**
     * 条件查询
     */
    String QUERY_CONDITION = "/condition/query";
    /**
     * 添加
     */
    String ADD = "/add";
    /**
     * 删除
     */
    String DEL = "/delete";
    /**
     * 修改
     */
    String EDIT = "/edit";

    //===========api资源================
    String APIRESOURCE_DETALS = APIRESOURCE + DETALS;
    String APIRESOURCE_QUERY_PAGE = APIRESOURCE + QUERY_PAGE;
    String APIRESOURCE_QUERY_CONDITION = APIRESOURCE + QUERY_CONDITION;
    String APIRESOURCE_ADD = APIRESOURCE + ADD;
    String APIRESOURCE_DEL = APIRESOURCE + DEL;
    String APIRESOURCE_EDIT = APIRESOURCE + EDIT;
    //===========api资源 end================

    //===========管理员 start================
    String MANAGER_DETALS = MANAGER + DETALS;
    String MANAGER_QUERY_PAGE = MANAGER + QUERY_PAGE;
    String MANAGER_QUERY_CONDITION = MANAGER + QUERY_CONDITION;
    String MANAGER_ADD = MANAGER + ADD;
    String MANAGER_DEL = MANAGER + DEL;
    String MANAGER_EDIT = MANAGER + EDIT;
    String MANAGER_BINDING = MANAGER + "/binding/role";
    //===========管理员 end ================

    //===========菜单 start================
    String MENU_DETALS = MENU + DETALS;
    String MENU_QUERY_PAGE = MENU + QUERY_PAGE;
    String MENU_QUERY_CONDITION = MENU + QUERY_CONDITION;
    String MENU_ADD = MENU + ADD;
    String MENU_DEL = MENU + DEL;
    String MENU_EDIT = MENU + EDIT;
    //===========菜单 end ================

    //===========角色 start ================
    String ROLE_DETALS = ROLE + DETALS;
    String ROLE_QUERY_PAGE = ROLE + QUERY_PAGE;
    String ROLE_QUERY_CONDITION = ROLE + QUERY_CONDITION;
    String ROLE_ADD = ROLE + ADD;
    String ROLE_DEL = ROLE + DEL;
    String ROLE_EDIT = ROLE + EDIT;
    /**
     * 绑定权限
     */
    String ROLE_BINDING_PERMISSION = ROLE + "/binding/resource";

    //===========角色 end ================
    //===========权限 start ================
    String PERM_DETALS = PERM + DETALS;
    String PERM_QUERY_PAGE = PERM + QUERY_PAGE;
    String PERM_QUERY_CONDITION = PERM + QUERY_CONDITION;
    String PERM_ADD = PERM + ADD;
    String PERM_DEL = PERM + DEL;
    String PERM_EDIT = PERM + EDIT;
    String PERM_BINDING = PERM + "/binding/resource";
    String PERM_BINDING_MENU = PERM + "/binding/menu";
    //===========权限 end ================

}
