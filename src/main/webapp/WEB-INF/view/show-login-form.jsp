<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>login</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>
<form:form action="processForm" modelAttribute="user">

    Login: <form:input placeholder="login" path="login"/>
    <form:errors path="login" cssClass="error"/>
    <br/>
    Password: <form:password placeholder="password" path="password"/>
    <form:errors path="password" cssClass="error"/>
    <br/>
    <input type="submit" value="log in">

</form:form>
  <br/>
<form:form action="/myspringmvc/registration/regForm">
    <input type="submit" value="registration"/>
</form:form>


</body>
</html>