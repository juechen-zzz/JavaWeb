package com.komorebi.filter;

import com.komorebi.util.constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getSession().getAttribute(constant.USER_SESSION) == null) {
            response.sendRedirect("/error.jsp");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
