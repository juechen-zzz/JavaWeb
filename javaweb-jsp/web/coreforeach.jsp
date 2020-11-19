<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nihaopeng
  Date: 2020/10/10
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ArrayList<String> people = new ArrayList<>();
    people.add(0, "a");
    people.add(1, "b");
    people.add(2, "c");
    people.add(3, "d");
    request.setAttribute("list", people);
%>

<c:forEach var="people" items="${list}">
    <c:out value="${people}"/> <br>
</c:forEach>

</body>
</html>
