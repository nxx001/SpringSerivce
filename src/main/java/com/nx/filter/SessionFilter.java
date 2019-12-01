package com.nx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String loginUrl = httpRequest.getContextPath() + "/login";

        String url = httpRequest.getRequestURI();
        if (!url.contains("login") && httpRequest.getSession(false) == null) {//index是我的登录页的路径
            String str = "<script language='javascript'>alert('会话过期,请重新登录');"
                    + "window.top.location.href='"
                    + loginUrl
                    + "';</script>";
            httpResponse.setContentType("text/html;charset=UTF-8");// 解决中文乱码
            PrintWriter writer = httpResponse.getWriter();
            writer.write(str);
            writer.flush();
            return;
        }

        filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
