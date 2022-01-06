<%--
  Created by IntelliJ IDEA.
  User: 57553
  Date: 2021/12/27
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object userId = request.getSession().getAttribute("userId");
%>
<html>
<head>
    <title>AllBooks</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-8 column">
                <div class="page-header">
                    <h1>
                        <small>书籍列表 —— 显示所有书籍</small>
                    </h1>
                </div>
            </div>
            <div class="col-md-4 column">
                <div class="page-header">
                    <span style="float: right;">欢迎您，用户：<%=userId%></span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <div class="page-header" style="float: left;">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/AfterLogIn/books/toAddBooks">添加书籍</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/AfterLogIn/books/showAllBooks">显示全部书籍</a>
                </div>
            </div>
            <div class="col-md-8 column">
                <form class="form-inline" style="float: right;" name="queryBookName" method="post" action="${pageContext.request.contextPath}/AfterLogIn/books/queryBooks">
                    <label for="queryName">查询书籍</label>
                    <input type="text" name="bookName" class="form-control" id="queryName" required>
                    &nbsp;
                    <input type="submit" class="btn btn-primary" value="查询">
                    <span style="color: red;font-weight: bold;">${failToFindBooks}</span>
                </form>
            </div>
        </div>

        <div class="row clearfix">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${booksList}">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/AfterLogIn/books/toUpdateBooks/${book.bookID}">修改</a>
                                &nbsp; | &nbsp;
                                <a href="${pageContext.request.contextPath}/AfterLogIn/books/deleteBooks/${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row clearfix" style="float: right;">
            <a href="${pageContext.request.contextPath}/AfterLogIn/books/backPage">上一页</a>
            &nbsp; | &nbsp;
            <a href="${pageContext.request.contextPath}/AfterLogIn/books/nextPage">下一页</a>
        </div>
    </div>
</body>
</html>
