<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wql
  Date: 2021/1/11
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FQ</title>
</head>
<body>
<%
    ArrayList<String> a = new ArrayList<>();
    a.add("李四");
    a.add("王五");
    a.add("赵六");
    a.add("曹七");
    a.add("贺八");
session.setAttribute("list",a);
%>
<c:forEach items="${list}" var="wql" >
    ${wql} <br>

</c:forEach>
</body>
</html>
