<%--
  Created by IntelliJ IDEA.
  User: wql
  Date: 2021/1/10
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/WQL.jsp" method="post">

    name:<input type="text" name="name" value="hhhh"><br>
    xx: <input type="text" name="password" value="kk"><br>
    爱好：<input type="checkbox" name="a" value="fff">
          <input type="checkbox" name="a" value="ggg">
         <input type="submit" value="提交">
</form>


</body>
</html>
