<%--
  Created by IntelliJ IDEA.
  User: yuecy
  Date: 2020/5/31
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="/login" method="post">
    用户名：<input type="text" name="userName"><br>
    密码:   <input type="password" name="passWord"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
