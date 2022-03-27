<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wql
  Date: 2022/3/26
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <table>

    <tr>
     用户: <input type="text" name="username" id="username"/>
    </tr>

    <tr>
      密码：<input type="text" name="password" id="password"/>
    </tr>

    <tr>
      <td style="text-align: right;padding-right: 5px" colspan="2"></td>
      <input type="button" value="登录" onclick="login()"/>
    </tr>
  </table>
  <input type="button" value="测试是否有登录信息" onclick="testLocalStorage()">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="application/javascript">

  function login() {
    var name = $("#username").val();
    var word = $("#password").val();
    var data = {username:name,password:word};
    $.ajax({
      url:"${pageContext.request.contextPath}/login",
      type:"GET",
      dataType:"json",
      data:data,
      success:function (datas) {
      if(datas.code==200){
        var token = datas.token;
        var localStorage = window.localStorage;//获取localStorage对象用于存储token
        localStorage.token=token;//存储token
      alert("登录成功")
      }else {
        alert("登录失败")
      }}})}


    function testLocalStorage() {
      $.ajax({
        url:"${pageContext.request.contextPath}/test",
        success:function (data) {
          if(data.code==200){
            window.localStorage.token = data.token;
            alert(data.data)
          }else {
            alert(data.msg)
          }},
        beforeSend:function (request) {//请求时头携带token
          request.setRequestHeader("Authorization",window.localStorage.token);
        }
      })};






</script>
</body>
</html>
