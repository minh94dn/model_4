<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 16/12/2022
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Mail</title>
</head>
<body>
<h1>List Mail</h1>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="mail" items="${mailList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${mail.getLanguage()}</td>
            <td>${mail.getPageSize()}</td>
            <td>${mail.isSpamsFilter()}</td>
            <td>${mail.getSignature()}</td>
            <td><a href="/mail/edit/${mail.getId()}"><button>Edit</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
