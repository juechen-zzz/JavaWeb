<%--
  Created by IntelliJ IDEA.
  User: nihaopeng
  Date: 2020/10/10
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象--%>
<%
    pageContext.setAttribute("name1", "komorebi_1");        // 保存的数据只在一个页面中有效
    request.setAttribute("name2", "komorebi_2");            // 保存的数据只在一次请求中有效，请求转发会携带
    session.setAttribute("name3", "komorebi_3");            // 保存的数据在一次会话中有效，直到关闭浏览器
    application.setAttribute("name4", "komorebi_4");        // 在服务器中有效，直到关闭服务器

%>

<%
    //通过pageContext取出保存的值，通过寻找方式
    //从底层到高层（作用域）
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5");
%>

<%--使用el表达式输出.${}--%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>


</body>
</html>
