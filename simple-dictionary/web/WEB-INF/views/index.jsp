<%--
  Created by IntelliJ IDEA.
  User: HN
  Date: 9/12/2020
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Dictionary</title>
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form action="/translate" method="post">
    <input type="text" name="english" placeholder="Enter your word"  value="${requestScope["english"]}"/>
    <br>
    <input type="text" name="vietnamese" value="${requestScope["vietnamese"]}"/>
    <br>
    <input type="submit" id="submit" value="Search"/>
  </form>
  </body>
</html>
