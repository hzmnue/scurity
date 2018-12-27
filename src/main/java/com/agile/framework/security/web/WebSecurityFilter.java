package com.agile.framework.security.web;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 1.实现自定义Session管理
 * */

@WebFilter(urlPatterns = "/*",filterName = "a_filter")
public class WebSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new WebSecurityRequest((HttpServletRequest) servletRequest),servletResponse);
    }

    @Override
    public void destroy() {

    }
}

