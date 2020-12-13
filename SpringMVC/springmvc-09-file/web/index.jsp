<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/upload2" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>

<a href="${pageContext.request.contextPath}/download">点击下载</a>

<a href="${pageContext.request.contextPath}/statics/dog_and_cat.jpeg">点击下载2</a>
</body>
</html>
