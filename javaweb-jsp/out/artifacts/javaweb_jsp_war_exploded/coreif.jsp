<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--引入JSTL核心标签库，才能使用--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>if测试</h4>
<hr>
<form action="coreif.jsp" method="get">
    <%--EL表达式获取表单中的数据，${param.参数名}--%>
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>

<%--判断如果提交的用户名是管理员则登录成功--%>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="欢迎"/>
</c:if>

<%--自闭合标签--%>
<c:out value="${isAdmin}"/>
</body>
</html>
