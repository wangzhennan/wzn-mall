package com.wzn.mall.log;


import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: wzn-mall
 * @description: 统一日志中请求数据管理器
 * @author: wangzhennan
 * @create: 2020-04-05 14:22
 **/
public class ReqLogManager {
    /**
     * 请求信息
     */
    private static final TransmittableThreadLocal<ReqInfo> REQ_INFO_HOLDER = new TransmittableThreadLocal<>();

    /**
     * 初始化请求的日志数据
     */
    public static void reqInit() {
        ReqInfo reqInfo = new ReqInfo();
        reqInfo.setStartTime(System.currentTimeMillis());
        reqInfo.setTraceId(StringUtils.EMPTY);
        REQ_INFO_HOLDER.set(reqInfo);
    }

    /**
     * 设置追踪标识
     */
    public static void setTraceId(String traceId) {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        REQ_INFO_HOLDER.get().setTraceId(traceId);
    }

    /**
     * 缓存请求中的信息
     */
    public static void fetch(HttpServletRequest request) {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        REQ_INFO_HOLDER.get().setMethod(request.getMethod());
        REQ_INFO_HOLDER.get().setUrl(request.getRequestURI());
        REQ_INFO_HOLDER.get().setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        REQ_INFO_HOLDER.get().setReferer(request.getHeader(HttpHeaders.REFERER));

        Map<String, String> istioMap = new HashMap<>(7);
        if(request.getHeader(CommReqParamKeyConst.ISTIO_X_REQUEST_ID) != null) {
            istioMap.put(CommReqParamKeyConst.ISTIO_X_REQUEST_ID, request.getHeader(CommReqParamKeyConst.ISTIO_X_REQUEST_ID));
        }
        REQ_INFO_HOLDER.get().setIstioMap(istioMap);
    }

    /**
     * 获取请求的istio信息
     */
    public static Map<String, String> getIstioMap() {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        return REQ_INFO_HOLDER.get().getIstioMap();
    }

    /**
     * 获取请求的method
     */
    public static String getMethod() {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        return REQ_INFO_HOLDER.get().getMethod();
    }

    /**
     * 获取请求的url
     */
    public static String getUrl() {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        return REQ_INFO_HOLDER.get().getUrl();
    }

    /**
     * 获取请求的userAgent
     */
    public static String getUserAgent() {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        return REQ_INFO_HOLDER.get().getUserAgent();
    }

    /**
     * 获取请求的referer
     */
    public static String getReferer() {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        return REQ_INFO_HOLDER.get().getReferer();
    }

    /**
     * 获取追踪标识
     */
    public static String getTraceId() {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        return REQ_INFO_HOLDER.get().getTraceId();
    }

    /**
     * 请求已经处理的时长（从请求开始到当前时间点）
     *
     * @return 耗时，如果请求信息未缓存，则返回0
     */
    public static long getReqDealTime() {

        if(REQ_INFO_HOLDER.get() == null) {
            reqInit();
        }

        long len = 0;
        Long start = REQ_INFO_HOLDER.get().getStartTime();
        if (start != null) {
            len = System.currentTimeMillis() - start;
        }
        return len;
    }

    /**
     * 清除请求的日志数据
     */
    public static void remove() {
        REQ_INFO_HOLDER.remove();
    }

    @Data
    private static class ReqInfo {
        private Long startTime;
        private String traceId;
        private String operatorRole;
        private String operatorUserId;
        private String userAgent;
        private String referer;
        private String method;
        private String url;
        private Map<String, String> istioMap;
    }
}
