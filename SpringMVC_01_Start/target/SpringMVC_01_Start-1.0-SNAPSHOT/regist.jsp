<%--
  Created by IntelliJ IDEA.
  User: zhangyuming
  Date: 2020/12/23
  Time: 4:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/register" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        地址:<input type="text" name="address"><br>
        生日:<input type="text" name="birthday">
        兴趣爱好:
        <input type="checkbox" name="hobby" value="basketball">篮球<br>
        <input type="checkbox" name="hobby" value="football">足球<br>
        <input type="checkbox" name="hobby" value="pingpong">乒乓球<br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
