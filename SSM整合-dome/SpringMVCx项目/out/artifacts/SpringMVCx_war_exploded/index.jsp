<%--
  Created by IntelliJ IDEA.
  User: wql
  Date: 2020/11/13
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>FQ</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/wql">
    账号：<input type="text" name="account">
    密码：<input type="text" name="password">
    name:<input type="text" name="list[0]">
    map:<input type="text" name="map['age']">
    <input type="submit" value="提交">
  </form>
  </body>
</html>
