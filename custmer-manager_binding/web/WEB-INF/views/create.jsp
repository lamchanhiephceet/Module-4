<%--
  Created by IntelliJ IDEA.
  User: HN
  Date: 9/16/2020
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new customer</title>
</head>
<body>
<h3>Welcome, Enter The Customer Details</h3>
<form:form method="POST" action="addCustomer" modelAttribute="customer">
    <table>
        <tr>
            <td><form:label path="id">Customer ID: </form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Customer's name: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="address">Customer's address: </form:label></td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>