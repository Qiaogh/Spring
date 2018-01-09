<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="title.success"/> - qiaogh.com</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"/>
    <link href="<spring:theme code='styleSheet'/>" rel="stylesheet"/>
    <jsp:include page="theme.jsp"/>
</head>
<body>
<div class="success">
    <spring:message code="desc.success"/> ${user}
</div>
<c:if test="${fn:length(fileNames)>0}">
    <div class="container col-md-6">
        <ul class="list-group">
            <c:forEach var="fileName" items="${fileNames}">
                <li class="list-group-item"><a href="/download?fileName=${fileName}">${fileName}</a></li>
            </c:forEach>
        </ul>
    </div>
</c:if>
</body>
</html>