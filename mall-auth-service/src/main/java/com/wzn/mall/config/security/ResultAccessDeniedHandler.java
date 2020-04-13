package com.wzn.mall.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzn.mall.ResultModel;
import com.wzn.mall.config.error.SysErrorCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: wzn-mall
 * @description: 权限异常
 * @author: wangzhennan
 * @create: 2020-04-13 16:34
 **/
public class ResultAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(ResultModel.error(SysErrorCode.IDENTITYERROR)));
        out.flush();
    }
}
