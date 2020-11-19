package com.komorebi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

// 传递中文数据
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        // Cookie，服务器端从客户端获取
        Cookie[] cookies = req.getCookies();        // 这里返回数组，说明cookie可能存在多个
        PrintWriter out = resp.getWriter();

        out.write("上一次访问的时间是：");
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            // 获取cookie的名字
            if (cookie.getName().equals("name")) {
                // 解码
                URLDecoder.decode(cookie.getValue(), "utf-8");
                out.write(cookie.getValue());
            }
        }

        // 编码
        Cookie cookie = new Cookie("name", URLEncoder.encode("程序", "utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
