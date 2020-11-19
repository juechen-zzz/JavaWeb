package com.komorebi.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.komorebi.pojo.Role;
import com.komorebi.pojo.User;
import com.komorebi.service.role.RoleServiceImpl;
import com.komorebi.service.user.UserServiceImpl;
import com.komorebi.util.Constants;
import com.komorebi.util.PageSupport;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 实现Servlet复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("savepwd")){
            this.updatePwd(req, resp);
        } else if (method != null && method.equals("pwdmodify")) {
            this.pwdmodify(req, resp);
        } else if (method != null && method.equals("query")){
            this.query(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    // 修改密码savepwd
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        // 从Session里面拿ID
        User o = (User) req.getSession().getAttribute(Constants.USER_SESSION);

        String newpassword = req.getParameter("newpassword");

        boolean flag = false;

        if (o != null && !StringUtils.isNullOrEmpty(newpassword)){
            UserServiceImpl userService = new UserServiceImpl();
            flag = userService.updatePwd(o.getId(), newpassword);
            if (flag){
                req.setAttribute("massage", "修改成功，请退出，使用新密码登录");
                // 密码修改成功，移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("massage", "修改失败");
            }
        } else {
            req.setAttribute("massage", "修改失败");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 验证旧密码，Session中有密码
    public void pwdmodify(HttpServletRequest req, HttpServletResponse resp){
        // 从Session里面拿ID
        User o = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        // 万能Map:结果集
        Map<String, String> resultMap = new HashMap<String, String>();
        if (o == null) { // Session过期
            resultMap.put("result", "sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldpassword)){ // 输入的旧密码为空
            resultMap.put("result", "error");
        } else {
            String userPassword = o.getUserPassword();      // Session中用户的密码
            if (oldpassword.equals(userPassword)){
                resultMap.put("result", "true");
            } else {
                resultMap.put("result", "false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            // JSONArray 阿里的工具类
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // query
    public void query(HttpServletRequest req, HttpServletResponse resp) {
        // 查询用户列表
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;

        // 获取用户列表
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;
        List<Role> roleList = null;

        // 第一次走这个请求，一定是第一页，页面大小固定的
        int pageSize = 5;
        int currentPageNo = 1;

        if (queryUserName == null) {
            queryUserName = "";
        }
        if (temp != null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);
        }
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }

        // 获取用户的总数(分页：上一页和下一页)
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);

        // 总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();       // 页数

        // 控制首页和尾页,如果页面要小于1，就显示第一页
        if (totalPageCount < 1){
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        // 获取用户列表展示
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        req.setAttribute("userList", userList);

        // 获取角色列表展示
        RoleServiceImpl roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        req.setAttribute("roleList", roleList);

        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRole);

        // 返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
