package com.wzn.mall.log;

/**
 * @program: wzn-mall
 * @description: 日志常量池
 * @author: wangzhennan
 * @create: 2020-04-05 14:52
 *
 */
public class LogFieldConst {
    /** 日志级别 */
    public static final String COMM_LOGLEVEL = "LOGLEVEL";
    /** 日志时间 */
    public static final String COMM_LOGTIME = "LOGTIME";
    /** 日志格式类型 */
    public static final String COMM_LOGTYPE = "LOGTYPE";
    /** 日志标识 */
    public static final String COMM_LOGID = "LOGID";
    /** 报警标识 */
    public static final String COMM_ALARMID = "ALARMID";
    /** 追踪标识 */
    public static final String COMM_TRACEID = "TRACEID";
    /** 主体内容 */
    public static final String COMM_CONT = "CONTENT";

    /** 请求的方法名 */
    public static final String REQ_C_METHOD = "METHOD";
    /** 请求的URI */
    public static final String REQ_C_URI = "URI";
    /** 请求的用户代理 */
    public static final String REQ_C_UA = "UA";
    /** 请求的来源链接 */
    public static final String REQ_C_REFERER = "REFERER";
    /** 请求的客户端IP */
    public static final String REQ_C_IP = "IP";
    /** 请求的参数串 */
    public static final String REQ_C_REQPARAMS = "REQPARAMS";
    /** 请求的平台信息 */
    public static final String REQ_U_PLATFORM = "PLATFORM";
    /** 请求的设备信息 */
    public static final String REQ_U_DEVICE = "DEVICE";
    /** 请求的渠道来源 */
    public static final String REQ_U_BDSOURCE = "BDSOURCE";
    /** 请求用户唯一ID */
    public static final String REQ_USERROLE = "USERROLE";
    /** 请求的登录用户名 */
    public static final String REQ_USERID = "USERID";
    /** 请求的入口渠道号 */
    public static final String REQ_U_FROM = "FROM";
    /** 请求的供应商标识 */
    public static final String REQ_V_VENDERID = "VENDERID";

    /** 主体内容-消息 */
    public static final String CONT_MSG = "MSG";
    /** 主体内容-订单信息 */
    public static final String CONT_ORDERINFO = "ORDERINFO";
    /** 主体内容-HTTP调用信息 */
    public static final String CONT_HTTPINVOKE = "HTTPINVOKE";
    /** 主体内容-方法参数 */
    public static final String CONT_FUNPARAMS = "FUNPARAMS";
    /** 主体内容-方法返回值 */
    public static final String CONT_FUNRETURN = "FUNRETURN";
}
