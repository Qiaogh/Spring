<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><spring:message code="title.enroll"/> - qiaogh.com</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" />
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet" />
	<link href="<spring:theme code='styleSheet'/>" rel="stylesheet" />
    <jsp:include page="theme.jsp" />
</head>

<body>

 	<div class="form-container">
 	
 	<h1><spring:message code="form.title" /></h1>
 	
	<form:form method="POST" action="/login" modelAttribute="user" class="form-horizontal" enctype="multipart/form-data">

		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="portrait"><spring:message code="input.user.portrait" /></label>
                <div class="col-md-7">
                    <input type="file" name="portrait" id="portrait" class="form-control input-sm" />
                </div>
            </div>
        </div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name"><spring:message code="input.user.name" /></label>
				<div class="col-md-7">
					<form:input type="input" path="name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password"><spring:message code="input.user.password" /></label>
				<div class="col-md-7">
					<form:input type="password" path="password" id="password" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="password" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Login" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>