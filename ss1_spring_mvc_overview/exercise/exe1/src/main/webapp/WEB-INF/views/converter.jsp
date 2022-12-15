<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/12/2022
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<h1>Convert from USD to VND</h1>
<form action="/converter/result">
    <p>USD</p>
    <input name="usd" value="${usd}">
    <p>Tỉ Giá</p>
    <input value="23000" readonly>
    <p>Result: ${result}</p>
    <button type="submit" >Converter</button>
</form>
</body>
</html>
