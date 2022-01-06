<%--
  Created by IntelliJ IDEA.
  User: 57553
  Date: 2021/12/22
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>LogIn</title>
  </head>
  <body>
    <form action="/logIn" method="post">
      UserId:
      <input type="text" name="userId">
      <br/>
      Password:
      <input type="password" name="password">
      <br/>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
