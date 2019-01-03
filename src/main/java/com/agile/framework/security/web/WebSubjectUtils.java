package com.agile.framework.security.web;

import com.agile.framework.security.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebSubjectUtils {
    private static ThreadLocal<Subject> localSubject=new ThreadLocal<>();
    private static ThreadLocal<HttpServletRequest> localRequest=new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> localResponse=new ThreadLocal<>();

    public static Subject getSubject(){
       return localSubject.get();
    }

    public static HttpServletRequest getRequest(){
        return localRequest.get();
    }

    public static HttpServletResponse getResponse(){
        return localResponse.get();
    }

    public static void setSubject(Subject subject) {
        localSubject.set(subject);
    }

    public static void setRequest(HttpServletRequest request) {
        localRequest.set(request);
    }

    public static void setResponse(HttpServletResponse response) {
        localResponse.set(response);
    }
}
