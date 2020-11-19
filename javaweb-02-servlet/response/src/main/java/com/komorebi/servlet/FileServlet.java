package com.komorebi.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/*
 * 实现下载文件功能
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 要获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/dog.jpg");
        System.out.println("路径： " + realPath);
        //2 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
        System.out.println("filename: " + fileName);
        //3 设置让浏览器支持下载所需的东西，encode是为了中文文件名
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //4 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7 将FileOutputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
