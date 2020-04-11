package com.wzn.mall.log;

/**
 * @program: wzn-mall
 * @description:
 * @author: wangzhennan
 * @create: 2020-04-05 14:55
 **/
public class CommReqParamKeyConst {


    public static final String TIME="time";
    /** traceId 参数名 */
    public static final String PARAM_TRACEID = "Ht-Trace-Id";
    /**
     * istio所需的参数
     */
    public static final String ISTIO_X_REQUEST_ID = "x-request-id";
    public static final String ISTIO_X_B3_TRACEID = "x-b3-traceid";
    public static final String ISTIO_X_B3_SPANID = "x-b3-spanid";
    public static final String ISTIO_X_B3_PARENTSPANID = "x-b3-parentspanid";
    public static final String ISTIO_X_B3_SAMPLED = "x-b3-sampled";
    public static final String ISTIO_X_B3_FLAGS = "x-b3-flags";
    public static final String ISTIO_X_OT_SPAN_CONTEXT = "x-ot-span-context";
}
