package com.wzn.mall.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父级ID
     */
    private Long pid;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单级别
     */
    private Integer level;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 前端名称
     */
    private String name;

    /**
     * 前端图标
     */
    private String icon;

    /**
     * 前端隐藏 1 隐藏 0不隐藏
     */
    @Column(name = "is_hidden")
    private Boolean isHidden;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父级ID
     *
     * @return pid - 父级ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父级ID
     *
     * @param pid 父级ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取创建时间
     *
     * @return ctime - 创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime 创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取菜单名称
     *
     * @return title - 菜单名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置菜单名称
     *
     * @param title 菜单名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取菜单级别
     *
     * @return level - 菜单级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置菜单级别
     *
     * @param level 菜单级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取菜单排序
     *
     * @return sort - 菜单排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置菜单排序
     *
     * @param sort 菜单排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取前端名称
     *
     * @return name - 前端名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置前端名称
     *
     * @param name 前端名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取前端图标
     *
     * @return icon - 前端图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置前端图标
     *
     * @param icon 前端图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取前端隐藏 1 隐藏 0不隐藏
     *
     * @return is_hidden - 前端隐藏 1 隐藏 0不隐藏
     */
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * 设置前端隐藏 1 隐藏 0不隐藏
     *
     * @param isHidden 前端隐藏 1 隐藏 0不隐藏
     */
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }
}