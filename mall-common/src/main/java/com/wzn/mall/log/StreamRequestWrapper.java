package com.wzn.mall.log;



import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  解决Spring自带的流只能读取一次，无法在doFilter前获取。
 * @author: wangzhennan
 * @create: 2020-04-05 14:23
 *
 **/
public class StreamRequestWrapper extends HttpServletRequestWrapper {

    private final String body;

    private final String characterEncoding;

    public StreamRequestWrapper(HttpServletRequest request) throws IOException {

        super(request);

        characterEncoding = request.getCharacterEncoding();
        body = IOUtils.toString(request.getInputStream(), characterEncoding);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes(characterEncoding));
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    public String getBody() {
        return this.body;
    }
}
