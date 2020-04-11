package com.wzn.mall.log;


import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-05 14:16
 **/
@Order(1)
@WebFilter(filterName = "reqLogFilter", urlPatterns = "/*")
@Configuration
public class ReqLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //初始化请求日志数据
        reqLogDataInit(request);

        Map<String, Object> logMap = new HashMap<>(4);
        //表单参数
        Map<String, String[]> map = request.getParameterMap();
        logMap.put("formParams", map);
        //body参数
        StreamRequestWrapper reqWrapper = new StreamRequestWrapper(request);
        if(isPrintBody(reqWrapper.getContentType())) {
            logMap.put("bodyParams", reqWrapper.getBody());
        }

        MallLogger.info(LogUtil.BASE_OUT_REQUEST_LOG_ID, logMap);

        ContentCachingResponseWrapper resWrapper = new ContentCachingResponseWrapper(response);

        try {
            filterChain.doFilter(reqWrapper, resWrapper);
        } finally {
            //path参数
            Object pathParams = reqWrapper.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            logMap.put("pathParams", pathParams);

            String responseBody = new String(resWrapper.getContentAsByteArray(), resWrapper.getCharacterEncoding());
            resWrapper.copyBodyToResponse();
            //响应结果
            if(isPrintBody(resWrapper.getContentType())) {
                logMap.put("return", responseBody);
            }

            MallLogger.info(LogUtil.BASE_OUT_RESPONSE_LOG_ID, logMap);

            ReqLogManager.remove();
        }
    }

    /**
     * 防止打印上传或下载的文件流
     */
    private boolean isPrintBody(String contentType) {
        return contentType != null
                && (contentType.startsWith(MediaType.APPLICATION_JSON_VALUE)
                || contentType.startsWith(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                || contentType.startsWith(MediaType.TEXT_PLAIN_VALUE));
    }

    /**
     * 初始化请求日志数据
     */
    private void reqLogDataInit(HttpServletRequest request){
        ReqLogManager.reqInit();
        //初始化traceId
        String traceId = request.getHeader(CommReqParamKeyConst.PARAM_TRACEID);
        if(StringUtils.isBlank(traceId)){
            traceId = CharMatcher.is('-').removeFrom(UUID.randomUUID().toString());
        }
        ReqLogManager.setTraceId(traceId);
        //生成请求信息
        ReqLogManager.fetch(request);
    }
}
