package com.wzn.mall.log;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-05 14:57
 **/
public class LogUtil {

    public static final String BASE_OUT_REQUEST_LOG_ID = "request";

    public static final String BASE_OUT_RESPONSE_LOG_ID = "response";

    public static final String BASE_INNER_REQUEST_LOG_ID = "base_inner_request";

    public static final String BASE_INNER_RESPONSE_LOG_ID = "base_inner_response";

    public static final String BASE_INNER_EXCEPTION_LOG_ID = "base_inner_exception";

    /**
     * 根据方法的全路径生成logId
     * @return logId
     */
    public static String getLogId() {
        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[2];
        return stackTrace.getClassName().toLowerCase().replace('.', '_') + "_" + stackTrace.getMethodName().toLowerCase();
    }

    /**
     * 填充字段
     * @param info 日志内容
     * @param key 字段键
     * @param value 字段值
     */
    public static void fillField(StringBuilder info, String key, String value){
        if(value == null) {
            value = StringUtils.EMPTY;
        }
        if(info == null) {
            info = new StringBuilder();
        }
        info.append(LogFormatConst.FIELD_BEGIN);
        info.append(key);
        info.append(LogFormatConst.FIELD_KV_SEP);
        info.append(value);
        info.append(LogFormatConst.FIELD_END);
    }
}
