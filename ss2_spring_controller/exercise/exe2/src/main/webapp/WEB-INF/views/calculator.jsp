<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/12/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/calculator/result" method="post">
    <p>Number One</p>
    <input name="number1" value="${number1}">
    <br>
    <br>
    <select name="calculation">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <br>
    <p>Number Two</p>
    <input name="number2" value="${number2}">
    <br>
    <br>
    <button type="submit" >Result</button>
    <h3>${result}</h3>
    <p>${mess}</p>
</form>
</body>
</html>
