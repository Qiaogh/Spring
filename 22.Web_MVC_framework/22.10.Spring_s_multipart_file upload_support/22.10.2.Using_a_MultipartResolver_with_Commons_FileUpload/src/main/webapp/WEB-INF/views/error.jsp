<%--
  Created by IntelliJ IDEA.
  User: qiaogh
  Date: 2017/12/18
  Time: 下午2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="title.error"/></title>
    <link href="<spring:theme code='styleSheet'/>" rel="stylesheet" />
    <jsp:include page="theme.jsp" />
</head>
<body>
    <h2><spring:message code="desc.error" /></h2>
</body>
</html>
