<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><spring:message code="title.success"/> - qiaogh.com</title>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="success">
		<spring:message code="desc.success"/> ${user}
	</div>
</body>
</html>