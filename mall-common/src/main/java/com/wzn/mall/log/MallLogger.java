package com.wzn.mall.log;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: wzn-mall
 * @description: 统一日志记录器
 * @author: wangzhennan
 * @create: 2020-04-05 14:51
 **/
public class MallLogger {

    private static final Logger debugLogger = LoggerFactory.getLogger(MallLogger.class);

    private static final Logger logger = LoggerFactory.getLogger(MallLogger.class);

    /**
     * 记录一条错误日志，主体内容仅包含MSG字段
     *
     * @param logId 日志标识，用于区分日志类别
     * @param value MSG字段内容值
     */
    public static void error(String logId, String value) {
        error(logId, LogFieldConst.CONT_MSG, value);
    }

    /**
     * 记录一条错误日志，主体内容仅包含MSG字段
     *
     * @param logId 日志标识，用于区分日志类别
     * @param value MSG字段内容值
     */
    public static void error(String logId, String value, Throwable thr) {
        error(logId, LogFieldConst.CONT_MSG, value, thr);
    }

    /**
     * 记录一条错误日志，主体内容仅包含单字段时用
     *
     * @param logId 日志标识，用于区分日志类别
     * @param key   单字段内容键
     * @param value 单字段内容值
     */
    public static void error(String logId, String key, String value) {
        error(logId, key, value, null);
    }

    /**
     * 记录一条错误日志，主体内容仅包含单字段时用
     *
     * @param logId 日志标识，用于区分日志类别
     * @param key   单字段内容键
     * @param value 单字段内容值
     */
    public static void error(String logId, String key, String value, Throwable thr) {
        String msg = format(logId, key, value, thr);
        logger.error(msg);
    }

    /**
     * 记录一条错误日志
     *
     * @param logId   日志标识，用于区分日志类别
     * @param contMap 主体内容Map
     */
    public static void error(String logId, Map<String, Object> contMap) {
        error(logId, contMap, null);
    }

    /**
     * 记录一条错误日志
     *
     * @param logId   日志标识，用于区分日志类别
     * @param contMap 主体内容Map
     * @param thr     异常信息
     */
    public static void error(String logId, Map<String, Object> contMap, Throwable thr) {
        String msg = format(logId, contMap, thr);
        logger.error(msg);
    }

    /**
     * 记录一条警告日志，主体内容仅包含MSG字段
     *
     * @param logId 日志标识，用于区分日志类别
     * @param value MSG字段内容值
     */
    public static void warn(String logId, String value) {
        warn(logId, LogFieldConst.CONT_MSG, value);
    }

    /**
     * 记录一条警告日志，主体内容仅包含MSG字段
     *
     * @param logId 日志标识，用于区分日志类别
     * @param value MSG字段内容值
     */
    public static void warn(String logId, String value, Throwable thr) {
        warn(logId, LogFieldConst.CONT_MSG, value, thr);
    }

    /**
     * 记录一条警告日志，主体内容仅包含单字段时用
     *
     * @param logId 日志标识，用于区分日志类别
     * @param key   单字段内容键
     * @param value 单字段内容值
     */
    public static void warn(String logId, String key, String value) {
        warn(logId, key, value, null);
    }

    /**
     * 记录一条警告日志，主体内容仅包含单字段时用
     *
     * @param logId 日志标识，用于区分日志类别
     * @param key   单字段内容键
     * @param value 单字段内容值
     */
    public static void warn(String logId, String key, String value, Throwable thr) {
        String msg = format(logId, key, value, thr);

        logger.warn(msg);
    }

    /**
     * 记录一条警告日志
     *
     * @param logId   日志标识，用于区分日志类别
     * @param contMap 主体内容Map
     */
    public static void warn(String logId, Map<String, Object> contMap) {
        warn(logId, contMap, null);
    }

    /**
     * 记录一条警告日志
     *
     * @param logId   日志标识，用于区分日志类别
     * @param contMap 主体内容Map
     * @param thr     异常信息
     */
    public static void warn(String logId, Map<String, Object> contMap, Throwable thr) {
        String msg = format(logId, contMap, thr);
        logger.warn(msg);
    }

    /**
     * 记录一条信息日志，主体内容仅包含MSG字段
     *
     * @param logId 日志标识，用于区分日志类别
     * @param value MSG字段内容值
     */
    public static void info(String logId, String value) {
        info(logId, LogFieldConst.CONT_MSG, value);
    }

    /**
     * 记录一条信息日志，主体内容仅包含单字段时用
     *
     * @param logId 日志标识，用于区分日志类别
     * @param key   单字段内容键
     * @param value 单字段内容值
     */
    public static void info(String logId, String key, String value) {
        String msg = format(logId, key, value, null);
        logger.info(msg);
    }

    /**
     * 记录一条信息日志
     *
     * @param logId   日志标识，用于区分日志类别
     * @param contMap 主体内容Map
     */
    public static void info(String logId, Map<String, Object> contMap) {
        String msg = format(logId, contMap, null);
        logger.info(msg);
    }

    /**
     * 记录一条调试日志，主体内容仅包含MSG字段
     *
     * @param logId 日志标识，用于区分日志类别
     * @param value MSG字段内容值
     */
    public static void debug(String logId, String value) {
        if (!debugLogger.isDebugEnabled()) {
            return;
        }
        debug(logId, LogFieldConst.CONT_MSG, value);
    }

    /**
     * 记录一条调试日志，主体内容仅包含单字段时用
     *
     * @param logId 日志标识，用于区分日志类别
     * @param key   单字段内容键
     * @param value 单字段内容值
     */
    public static void debug(String logId, String key, String value) {
        if (!debugLogger.isDebugEnabled()) {
            return;
        }
        String msg = format(logId, key, value, null);
        debugLogger.debug(msg);
    }

    /**
     * 记录一条调试日志
     *
     * @param logId   日志标识，用于区分日志类别
     * @param contMap 主体内容Map
     */
    public static void debug(String logId, Map<String, Object> contMap) {
        if (!debugLogger.isDebugEnabled()) {
            return;
        }
        String msg = format(logId, contMap, null);
        debugLogger.debug(msg);
    }

    /**
     * 记录一条调试日志，主体内容仅包含MSG字段
     *
     * @param logId 日志标识，用于区分日志类别
     * @param value MSG字段内容值
     * @param thr   异常信息
     */
    public static void debug(String logId, String value, Throwable thr) {
        if (!debugLogger.isDebugEnabled()) {
            return;
        }
        String msg = format(logId, LogFieldConst.CONT_MSG, value, null);
        debugLogger.debug(msg, thr);
    }

    /**
     * 格式化日志信息，主体内容仅包含单字段时用
     *
     * @param logId 日志标识
     * @param key   单字段内容键
     * @param value 单字段内容值
     * @return 日志内容
     */
    private static String format(String logId, String key, String value, Throwable thr) {

        StringBuilder msgsb = formatCommInfo(logId);

        Map<String, String> contMap = new HashMap<>(2);
        if (StringUtils.isNotBlank(key)) {
            contMap.put(key, value);
        }
        if (thr != null) {
            contMap.put("Exception", ExceptionUtil.getExStackTraceStr(thr));
        }
        LogUtil.fillField(msgsb, LogFieldConst.COMM_CONT, JSON.toJSONString(contMap));
        return msgsb.toString();
    }

    /**
     * 格式化日志信息
     *
     * @param logId   日志标识
     * @param contMap 主体内容Map
     * @return 日志内容
     */
    private static String format(String logId, Map<String, Object> contMap, Throwable thr) {

        StringBuilder msgsb = formatCommInfo(logId);

        //content
        if (contMap == null) {
            contMap = new HashMap<>(2);
        }
        if (thr != null) {
            contMap.put("Exception", ExceptionUtil.getExStackTraceStr(thr));
        }
        LogUtil.fillField(msgsb, LogFieldConst.COMM_CONT, JSON.toJSONString(contMap));
        return msgsb.toString();
    }

    /**
     * 格式化日志通用部分信息
     *
     * @param logId 日志标识
     * @return  日志内容
     */
    private static StringBuilder formatCommInfo(String logId) {
        StringBuilder msgsb = new StringBuilder();
        //locationInfo
        fetchLocationInfo(msgsb);
        //reqDealTime
        fetchReqDealTime(msgsb);
        //logId
        LogUtil.fillField(msgsb, LogFieldConst.COMM_LOGID, logId);
        //traceId
        LogUtil.fillField(msgsb, LogFieldConst.COMM_TRACEID, ReqLogManager.getTraceId());
        //METHOD:URI
        LogUtil.fillField(msgsb, ReqLogManager.getMethod(), ReqLogManager.getUrl());
        //UA 请求头
        //LogUtil.fillField(msgsb, LogFieldConst.REQ_C_UA, ReqLogManager.getUserAgent());
        //REFERER
        LogUtil.fillField(msgsb, LogFieldConst.REQ_C_REFERER, ReqLogManager.getReferer());
        return msgsb;
    }

    /**
     * 获取日志位置信息
     *
     * @param msgsb 日志内容
     */
    private static void fetchLocationInfo(StringBuilder msgsb) {
        msgsb.append(LogFormatConst.FIELD_BEGIN);
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        for (StackTraceElement ste : stacks) {
            if (!MallLogger.class.getName().equals(ste.getClassName())) {
                msgsb.append(ste.getClassName());
                msgsb.append(".");
                msgsb.append(ste.getMethodName());
                break;
            }
        }
        msgsb.append(LogFormatConst.FIELD_END);
    }

    /**
     * 获取请求处理时长
     *
     * @param msgsb 日志内容
     */
    private static void fetchReqDealTime(StringBuilder msgsb) {
        msgsb.append(LogFormatConst.FIELD_BEGIN+CommReqParamKeyConst.TIME+LogFormatConst.FIELD_KV_SEP);
        msgsb.append(ReqLogManager.getReqDealTime());
        msgsb.append(LogFormatConst.FIELD_END);
    }

}
