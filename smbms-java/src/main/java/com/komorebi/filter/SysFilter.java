package com.komorebi.filter;

import com.komorebi.pojo.User;
import com.komorebi.util.Constants;

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

        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        if (user == null) {
            response.sendRedirect("/smbms/error.jsp");
        }else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
