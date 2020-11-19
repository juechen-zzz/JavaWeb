package com.komorebi.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    // 初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Already go");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter 执行前...");
        chain.doFilter(request, response);          // 让我们的请求继续走，如不写，程序到这里就被拦截停止
        System.out.println("CharacterEncodingFilter 执行后...");
    }

    // 销毁，web服务器关闭的时候，会被销毁
    @Override
    public void destroy() {
        System.out.println("Game Over");
    }
}
