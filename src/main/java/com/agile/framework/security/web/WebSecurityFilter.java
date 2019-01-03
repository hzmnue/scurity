package com.agile.framework.security.web;

import com.agile.framework.security.session.SessionDao;
import com.agile.framework.security.subject.Subject;
import com.agile.framework.security.subject.SubjectManager;
import com.agile.framework.security.verifyservice.VerifyService;
import com.agile.framework.security.verifyservice.impl.WebVerifyService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器最好设置在第一位过滤
 * */
public class WebSecurityFilter implements Filter {

    private SubjectManager subjectManager=new SubjectManager();

    public WebSecurityFilter(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        subjectManager.addVerifyServices(new WebVerifyService());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //通过cookie里面的sessionId获取subject
        HttpServletRequest httpServletRequest= (HttpServletRequest)request;
        HttpServletResponse httpServletResponse= (HttpServletResponse)response;
        Subject subject=null;
        for (Cookie cookie : httpServletRequest.getCookies()) {
            if(cookie.getName().equals("ASession")){
                 subject= subjectManager.getSubject(cookie.getValue());
                 break;
            }
        }
        //如果获取不到,那么创建一个subject,写入cookie
        if(subject==null){
            subject= subjectManager.createSubject();
            Cookie cookie=new Cookie("ASession",subject.getSesssion().getId());
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);
        }

        //把subject放入subjectUtils中,与线程绑定,方便获取
        WebSubjectUtils.setSubject(subject);
        if(subject.doAuthorize())
            chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }


}
