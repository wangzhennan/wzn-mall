package com.wzn.mall.error;

import com.wzn.mall.ErrorCode;

/**
 * @program: wzn-mall
 * @description: 错误
 * @author: wangzhennan
 * @create: 2020-04-13 16:42
 **/
public class SysErrorCode extends ErrorCode {

    public static final ErrorCode PARAM_ERROR = new ErrorCode(100001, "请求参数异常");


    public SysErrorCode(Integer code, String message) {
        super(code, message);
    }
}
