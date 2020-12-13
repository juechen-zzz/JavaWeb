<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--  JSP表达式
  作用：用来将程序的输出，输出到客户端
  --%>
<%= new java.util.Date()%>

<hr>

<%--  JSP脚本片段  --%>
<%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
%>

<%--  在代码中嵌入HTML元素--%>
<%
    for (int i = 0; i < 3; i++) {
%>
<h2>hello, komorebi <%= i%>
</h2>
<%
    }
%>
<p>这是一个JSP文档</p>

<%!
    static {
        System.out.println("loading servlet");
    }

    private int globalVar = 0;

    public void komorebi() {
        System.out.println("进入了方法komorebi");
    }
%>
</body>
</html>
