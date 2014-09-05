<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>403 Forbidden</title>
</head>


<body>
	<div><h1>You don't have the right to view.</h1></div>
	<div><a href="<c:url value='/'"/>Back to front page</a></div>
</body>
</html>
