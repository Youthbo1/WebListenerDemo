package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * \Date: 2018/1/17
 * \
 * \Description:
 * \
 */
@WebFilter(urlPatterns = "/main.jsp")
public class SessionFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponse hresponse = (HttpServletResponse)servletResponse;

        String loginUser = (String)hrequest.getSession().getAttribute("loginUser");//从session对象中获取登录用户名

        if(loginUser==null){//登录用户名不存在，用户未登录，强制重定向至登陆页面
            hresponse.sendRedirect(hrequest.getContextPath()+"/index.jsp?flag=1");
            return;

        }else{
            filterChain.doFilter(servletRequest, servletResponse);//已登录，转入相应的请求处理
            return;
        }
    }

    public void destroy() {

    }
}
