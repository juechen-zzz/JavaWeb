<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--定义一个变量score，值为86--%>
<c:set var="score" value="86"/>

<c:choose>
    <c:when test="${score>=90}">
        你的成绩为优
    </c:when>
    <c:when test="${score<90}">
        你的成绩为良
    </c:when>
</c:choose>

</body>
</html>
