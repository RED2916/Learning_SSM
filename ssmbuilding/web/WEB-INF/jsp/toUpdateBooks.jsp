<%--
  Created by IntelliJ IDEA.
  User: 57553
  Date: 2021/12/27
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/AfterLogIn/books/updateBooks">
        <input type="hidden" name="bookID" value="${books.bookID}">
        <div class="form-group">
            <label for="bkname">书籍名称</label>
            <input type="text" name="bookName" class="form-control" value="${books.bookName}" id="bkname" required>
        </div>
        <div class="form-group">
            <label for="bkcount">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${books.bookCounts}" id="bkcount" required>
        </div>
        <div class="form-group">
            <label for="bkdetail">书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${books.detail}" id="bkdetail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" id="bksubmit">
        </div>
    </form>
</div>
</body>
</html>
