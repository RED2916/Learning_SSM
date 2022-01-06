<%--
  Created by IntelliJ IDEA.
  User: 57553
  Date: 2021/12/24
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form action="${pageContext.request.contextPath}/logIn" method="post">
        <div class="form-group">
          <label for="userId">UserId</label>
          <input type="text" id="userId" name="userId" class="form-control">
        </div>
        <br/>
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" id="password" name="password" required class="form-control">
          <br/>
        </div>
        <div class="form-group">
          <input type="submit" value="Submit">
        </div>
      </form>
    </div>
  </body>
</html>
