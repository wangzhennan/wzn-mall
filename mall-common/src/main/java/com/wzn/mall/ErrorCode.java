package com.wzn.mall;


import lombok.Getter;

import java.io.Serializable;

/**
 * @program: wzn-mall
 * @description: 错误码
 * @author: wangzhennan
 * @create: 2020-04-05 13:30
 **/
public class ErrorCode implements Serializable {

    @Getter
    private Integer code;
    @Getter
    private String message;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
