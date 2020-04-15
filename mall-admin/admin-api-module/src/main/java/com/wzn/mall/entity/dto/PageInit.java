package com.wzn.mall.entity.dto;

import lombok.Data;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-15 18:13
 **/
@Data
public class PageInit {

    private Integer pageNum;

    private Integer pageSize;


    PageInit() {
        pageNum = 0;
        pageSize = 10;
    }
}
