<%--
  Created by IntelliJ IDEA.
  User: HN
  Date: 9/12/2020
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body>
  <form action="/convert" method="post">
    <label>USD:
      <input type="text" name="usd" value="${requestScope["usd"]}"/>
    </label>
    <br/>
    <label>VND:
    <input type="text" name="vnd" value="${requestScope["vnd"]}"/>
    </label>
    <br/>
    <input type ="submit" id="submit" value="Converter"/>
  </form>
  </body>
</html>
