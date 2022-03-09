<%--
  Created by IntelliJ IDEA.
  User: wql
  Date: 2021/1/11
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.WQL.wqltest" %>
<%@ page import="java.util.HashMap" %>
>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--定义变量--%>
<c:set var="as"  value="WQL" scope="session"></c:set>
<%
    wqltest a = new wqltest();
    HashMap map = new HashMap();
    session.setAttribute("wql",a);
    session.setAttribute("wql1",map);
%>
<%--为bean对象赋值--%>
<c:set value="FQ" property="name" target="${sessionScope.wql}"/>
<%--为Map赋值--%>
<c:set value="WQL" property="name1" target="${sessionScope.wql1}"/>

变量a：${as}<br>
bean对象：${wql.name}<br>
Map：${wql1.get("name1")}<br>
</body>
</html>
