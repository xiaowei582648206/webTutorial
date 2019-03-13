package com.hnu.cloudmining.servletApp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2019/3/13.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if(session.getAttribute("userid")!=null){ // 如果当前session中有userid属性，则表示当前用户登录过
            filterChain.doFilter(servletRequest,servletResponse); // 自动判断过滤链中是否还有在web.xml中定义的过滤器还没有执行，最后才将request请求发送给目标
        }else{  //如果session中没有userid属性，则表示当前用户没有登录，需要重新登录
            System.out.println("当前用户没有登录，请重新登录!");
            request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse); //服务器跳转，将本次请求通过requestDispather请求转发器(在服务器上)，转发给login.jsp页面，此时所有的操作都是在同一个request中完成的，也都是在服务器上完成的，由于只有一个request，所以过滤器也只会作用一次。
//            response.sendRedirect("login.jsp"); //客户端跳转，重定向，两次请求，response.sendRedirect(),将响应头传给浏览器，让浏览器立刻重新发一次请求，请求login.jsp页面，而这个请求又会被过滤器拦截，然后浏览器再发第三次请求，再被拦截，再发……如此循环下去，始终无法访问
        }
    }

    @Override
    public void destroy() {

    }
}
