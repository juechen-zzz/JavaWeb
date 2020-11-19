<%--
  Created by IntelliJ IDEA.
  User: nihaopeng
  Date: 2020/10/8
  Time: 07:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>

<h1>登陆</h1>
<div style="text-align: center">
    <%--这里表单表示的意思，以post方式提交表单，提交到Login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名: <input type="text" name="username"> <br>
        密码: <input type="password" name="password"> <br>
        爱好:
        <input type="checkbox" name="hobby" value="女孩">女孩
        <input type="checkbox" name="hobby" value="代码">代码
        <input type="checkbox" name="hobby" value="唱歌">唱歌
        <input type="checkbox" name="hobby" value="电影">电影

        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
