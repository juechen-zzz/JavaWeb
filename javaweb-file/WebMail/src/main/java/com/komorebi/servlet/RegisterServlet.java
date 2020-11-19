package com.komorebi.servlet;

import com.komorebi.pojo.User;
import com.komorebi.utils.SendMail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收用户请求，封装成对象
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(username, password, email);

        SendMail send = new SendMail(user);
        // 用线程来减少耗时
        send.start();

        // 注册用户
        request.setAttribute("message", "注册成功！");
        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
