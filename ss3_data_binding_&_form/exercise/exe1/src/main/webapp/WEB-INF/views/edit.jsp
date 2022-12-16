<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 16/12/2022
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Mail</title>
</head>
<body>
<%--@elvariable id="mail" type=""--%>
<form:form action="/mail/edit" method="post" modelAttribute="mail">
    <form:hidden path="id"/>
    <h4>language</h4>
    <form:select path="language" items="${languageList}"/>
    <h4>Page Size</h4>
    <form:select path="pageSize" items="${pageSizeList}"/>
    <h4>Spams Filter</h4>
    <form:checkbox path="spamsFilter"/>
    <h4>Signature</h4>
    <form:input path="signature"/>
    <br>
    <br>
    <input type="submit" value="Update">
</form:form>
</body>
</html>
