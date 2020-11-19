<%--
  Created by IntelliJ IDEA.
  User: nihaopeng
  Date: 2020/10/10
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JspTag2</h1>

<%--取出参数--%>
名字：<%=request.getParameter("name")%>
年龄：<%=request.getParameter("age")%>

</body>
</html>
