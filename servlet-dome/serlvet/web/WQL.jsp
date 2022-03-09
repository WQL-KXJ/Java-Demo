<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--导入库：url是自己定义的url地址 prefix是库名--%>
<%@ taglib prefix="mywql" uri="http://tomcat.apache.org/jsp/el/wql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


${mywql:Tolower("WQL")}

</body>
</html>
