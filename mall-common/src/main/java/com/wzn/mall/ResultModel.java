package com.wzn.mall;

import lombok.Data;

/**
 * @program: wzn-mall
 * @description: 返回类
 * @author: wangzhennan
 * @create: 2020-04-05 13:25
 **/
@Data
public class ResultModel<T> {

    public static final Integer CODE_SUCCESS = 100000;
    public static final String MESSAGE_SUCCESS = "success";

    /**
     * 状态码
     */
    private Integer errcode;
    /**
     * 状态信息
     */
    private String errmsg;

    /**
     * 数据对象
     */
    private T data;

    private ResultModel(int code, String msg, T data) {
        this.errcode = code;
        this.errmsg = msg;
        this.data = data;
    }
    public ResultModel(T data) {
        this.errcode = CODE_SUCCESS;
        this.errmsg = MESSAGE_SUCCESS;
        this.data = data;
    }


    public static <T> ResultModel<T> success(T data) {
        return new ResultModel<T>(CODE_SUCCESS, MESSAGE_SUCCESS, data);
    }

    public ResultModel<T> successData(T data) {
        return new ResultModel<T>(CODE_SUCCESS, MESSAGE_SUCCESS, data);
    }

    public static <T> ResultModel<T> success() {
        return new ResultModel<T>(CODE_SUCCESS, MESSAGE_SUCCESS, null);
    }

    public static <T> ResultModel<T> success(String msg) {
        return new ResultModel<T>(CODE_SUCCESS, msg, null);
    }


    public static <T> ResultModel<T> error(ErrorCode errorCode, String... message) {
        return new ResultModel<T>(errorCode.getCode(), String.format(errorCode.getMessage(), message), null);
    }

    public static <T> ResultModel<T> error(Integer code, String message) {
        return new ResultModel<T>(code, message, null);
    }

    public static <T> ResultModel<T> error(ErrorCode errorCode, T data) {
        return new ResultModel<T>(errorCode.getCode(), errorCode.getMessage(), data);
    }

    public static <T> ResultModel<T> error(ErrorCode code) {
        return new ResultModel<T>(code.getCode(), code.getMessage(), null);
    }

    public boolean respIsSuccess() {
        return CODE_SUCCESS.equals(this.errcode);
    }
    public boolean isSuccess() {
        return CODE_SUCCESS.equals(this.errcode);
    }
    public ResultModel() {
    }

}
