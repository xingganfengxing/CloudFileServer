<%--
  Created by IntelliJ IDEA.
  User: zhy
  Date: 11/30/16
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
  <head>
      <title>index</title>
      <meta content="text/html" charset="UTF-8">
      <!-- 新 Bootstrap 核心 CSS 文件 -->
      <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

      <!-- 可选的Bootstrap主题文件（一般不用引入） -->
      <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

      <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
      <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

      <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
      <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
      <p>上传文件</p>
      <form method="post" enctype="multipart/form-data" action="/upload">
          <input type="file" name="uploadFile"><br>
          <input type="hidden" name="path" value="${path}">
          <input type="submit" value="Submit">
      </form>
  <table class="table">
      <thead>
        <th>fileName</th>
        <th>action</th>
      </thead>
      <tbody>
      <c:forEach var="dic" items="${dicList}">
          <tr>
              <td>
                  <a href="/open?dic=${dic}"><button type="button">${dic.getName()}</button></a>
              </td>
              <td>
                  <a href="/delete?fileName=${dic}"><button type="button">delete</button></a>
              </td>
          </tr>
      </c:forEach>
      <c:forEach var="file" items="${fileList}">
              <tr>
                  <td><c:out value="${file.getName()}"/></td>
                  <td>
                      <a href="/delete?fileName=${file}"><button type="button">delete</button></a>
                      <a href="/download?fileName=${file}"><button type="button">download</button></a>
                      </form>
                  </td>
              </tr>
      </c:forEach>
      </tbody>
  </table>
  </div>
  </body>
</html>
