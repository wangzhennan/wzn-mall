package com.wzn.mall.config.error;

import com.wzn.mall.ErrorCode;

/**
 * @program: wzn-mall
 * @description: 异常
 * @author: wangzhennan
 * @create: 2020-04-13 16:45
 **/
public class SysErrorCode extends ErrorCode {

    public final static SysErrorCode AUTHENERROR = new SysErrorCode(200001, "权限不足(%)");
    public final static SysErrorCode IDENTITYERROR = new SysErrorCode(200002, "访问此资源需要完全身份验证（%)");

    public SysErrorCode(Integer code, String message) {
        super(code, message);
    }
}
