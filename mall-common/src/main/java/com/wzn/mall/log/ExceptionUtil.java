package com.wzn.mall.log;

/**
 * @program: wzn-mall
 * @description: 异常格式处理
 * @author: wangzhennan
 * @create: 2020-04-05 14:59
 **/
public class ExceptionUtil {
    /** 异常堆栈信息分隔串 */
    private static final String EX_ST_SEP = " --> ";
    private static final int MAX_TRACE_COUNT_LIMIT = 8;
    /**
     * 获取异常堆栈信息串
     */
    public static String getExStackTraceStr(Throwable thr){
        StringBuilder stsb = new StringBuilder();
        stsb.append(thr.toString());
        StackTraceElement[] trace = thr.getStackTrace();
        int limit = Math.min(MAX_TRACE_COUNT_LIMIT, trace.length);
        for (int i = 0; i < limit; i++) {
            stsb.append(EX_ST_SEP);
            stsb.append("at ");
            stsb.append(trace[i].toString());
        }

        Throwable ourCause = thr.getCause();
        if (ourCause != null){
            doFillExStackTraceAsCause(stsb, ourCause, trace);
        }

        return stsb.toString();
    }

    /**
     * 填充异常cause堆栈信息
     */
    private static void doFillExStackTraceAsCause(StringBuilder sb, Throwable cause, StackTraceElement[] causedTrace) {
        // Compute number of frames in common between this and caused
        StackTraceElement[] trace = cause.getStackTrace();
        int m = trace.length - 1;
        int n = causedTrace.length - 1;
        while (m >= 0 && n >= 0 && trace[m].equals(causedTrace[n])) {
            m--;
            n--;
        }
        int framesInCommon = trace.length - 1 - m;

        sb.append(EX_ST_SEP);
        sb.append("Caused by: ");
        sb.append(cause.toString());
        for (int i = 0; i <= m; i++){
            sb.append(EX_ST_SEP);
            sb.append("at ");
            sb.append(trace[i]);
        }
        if (framesInCommon != 0){
            sb.append(EX_ST_SEP);
            sb.append("... ");
            sb.append(framesInCommon);
            sb.append(" more");
        }
        // Recurse if we have a cause
        Throwable ourCause = cause.getCause();
        if (ourCause != null){
            doFillExStackTraceAsCause(sb, ourCause, trace);
        }
    }
}
