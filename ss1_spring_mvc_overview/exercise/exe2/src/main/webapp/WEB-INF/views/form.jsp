<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/12/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>English-Vietnamese Dictionary</h1>
<form action="/word/result">
    <p>English</p>
    <input name="english" value="${english}">
    <p>Vietnamese: ${result}</p>
    <button type="submit">Search</button>
</form>
</body>
</html>
