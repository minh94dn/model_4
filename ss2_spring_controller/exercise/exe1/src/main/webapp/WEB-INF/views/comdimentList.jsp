<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15/12/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comdiment List</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <input type="checkbox" name="choose" value="lettuce"><span>Lettuce</span><br>
    <input type="checkbox" name="choose" value="tomato"><span>Tomato</span><br>
    <input type="checkbox" name="choose" value="mustard"><span>Mustard</span><br>
    <input type="checkbox" name="choose" value="sprouts"><span>Sprouts</span><br>
    <button type="submit">Save</button>

</form>
<p>Reuslt: ${choose}</p>
</body>
</html>

