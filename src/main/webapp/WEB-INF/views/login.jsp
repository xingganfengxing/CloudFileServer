<%--
  Created by IntelliJ IDEA.
  User: zhy
  Date: 1/16/17
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="_include.jsp"/>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="alert alert-danger" role="alert">${errors}</div>
            <form role="form" action="/login" method="post">
                <div class="form-group">
                    <label for="inputName">Name</label>
                    <input type="text" class="form-control" id="inputName" placeholder="这里是名字" name="name">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword" placeholder="这里是密码" name="password">
                </div>
                <button type="submit" class="btn btn-default col-md-offset-4 btn-success">登陆</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
