<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<html>
  <head>
    <title>欢迎页</title>
  </head>
  <body>

  <a href="${pageContext.request.contextPath}/user/wql">查询</a>
  <a href="${pageContext.request.contextPath}/user/wql/12" name="_method">查询所有</a>

  <br/>
  <br/>
  <h1>post请求</h1>
  <form action="${pageContext.request.contextPath}/user/wql" method="post">
    账号：<input type="text" name="account">
    <br/>
    密码：<input type="text" name="password">
    <input type="submit" value="提交">
  </form>

  <br/>
  <br/>
  <h1>put请求</h1>
  <form action="${pageContext.request.contextPath}/user/wql" method="post">
    <!--定义PUT请求-->
    <input type="hidden" name="_method" value="PUT">
    账号：<input type="text" name="account">
    <br/>
    密码：<input type="text" name="password">
    <input type="submit" value="提交">
  </form>

  <br/>
  <br/>
  <h1>delete请求</h1>
  <form action="${pageContext.request.contextPath}/user/wql" method="post">
    <!--定义DELETE请求-->
    <input type="hidden" name="_method" value="delete">
    账号：<input type="text" name="account">
    <br/>
    密码：<input type="text" name="password">
    <input type="submit" value="提交">
  </form>

  <br/>
  <br/>
  <h1>RequestBody</h1>
  <form action="${pageContext.request.contextPath}/requestbody" method="post">
    账号：<input type="text" name="account">
    <br/>
    密码：<input type="text" name="password">
    <input type="submit" value="提交">
  </form>

  <a href="${pageContext.request.contextPath}/response">HttpServletResponse响应数据</a>

  <br/>
  <a href="${pageContext.request.contextPath}/download">wql图片下载</a>
  <br>

  <a href="${pageContext.request.contextPath}/upload">文件上传</a>
  <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    文件：<input type="file" name="multipartFile">
    <input type="submit" value="上传">
  </form>
  </body>
</html>
