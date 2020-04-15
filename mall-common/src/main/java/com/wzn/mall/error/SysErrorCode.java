package com.wzn.mall.error;

import com.wzn.mall.ErrorCode;

/**
 * @program: wzn-mall
 * @description: 错误
 * @author: wangzhennan
 * @create: 2020-04-13 16:42
 **/
public class SysErrorCode extends ErrorCode {


    public static final ErrorCode SYS_ERROR = new ErrorCode(100000, "系统异常");

    public static final ErrorCode PARAM_ERROR = new ErrorCode(100001, "请求参数异常");

    public static final ErrorCode VIOLATION_ERROR = new ErrorCode(100002, "请求参数异常(%s)");

    public static final ErrorCode ADD_ERROR = new ErrorCode(100003, "添加异常");
    public static final ErrorCode EDIT_ERROR = new ErrorCode(100004, "修改异常");
    public static final ErrorCode DEL_ERROR = new ErrorCode(100005, "删除异常");

    public SysErrorCode(Integer code, String message) {
        super(code, message);
    }

}
