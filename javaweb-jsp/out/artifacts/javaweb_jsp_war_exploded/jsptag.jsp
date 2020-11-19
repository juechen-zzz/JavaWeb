<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
http://localhost:8080/jsptag.jsp?name=komorebi&age=12
--%>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="komorebi"/>
    <jsp:param name="age" value="12"/>
</jsp:forward>

</body>
</html>
