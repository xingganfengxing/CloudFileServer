<%--
  Created by IntelliJ IDEA.
  User: zhy
  Date: 12/14/16
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="_include.jsp" ></jsp:include>
</head>
<body>
<jsp:include page="_head.jsp"/>
<div class="container">
    <div class="jumbotron">
        <h1>这里是标题</h1>
        <p class="lead">
                讲道理我应该写一段描述，但是由于我不知道怎么写描述，所以
            我只能如实的回答我真的不知道怎么写这一段描述。
        </p>
        <p>${error}</p>
        <form class="form-horizontal" role="form" action="/sign" method="post">
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">Name</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="name" placeholder="这里写名字" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label">Password</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" id="password" placeholder="这里写密码" name="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-10">
                    <button type="submit" class="btn btn-success">注册</button>
                </div>
            </div>
        </form>
    </div>

</div> <!-- /container -->
</form>
</body>
</html>
