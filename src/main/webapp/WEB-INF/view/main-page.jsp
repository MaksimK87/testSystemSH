
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
<h2>Welcom to your account, ${userFromDB.userDetails.name} ${userFromDB.userDetails.surName}! </h2>

<br/>

Available tests:
<table>
	<tr>
		<th>Test name</th>
		<th>Duration(minutes)</th>
		<th>Action</th>
	</tr>

	<c:forEach var="test" items="${tests}">


		<c:url var="startTest" value="/user/startTest">
			<c:param name="testId" value="${test.id}" />
		</c:url>


		<tr>
			<td>${test.testName}</td>
			<td>${test.testDuration}</td>

			<td>

				<a href="${startTest}">start test</a>
				|

			</td>

		</tr>

	</c:forEach>

</table>
<br/>


<br/>
<form:form action="/myspringmvc/login/processForm">
	<input type="submit" value="log out"/>
</form:form>

</body>
</html>