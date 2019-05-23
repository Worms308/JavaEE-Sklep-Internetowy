<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value="front-end-resources/css/style.css"/>">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

	<link href="https://fonts.googleapis.com/css?family=PT+Sans+Narrow" rel="stylesheet">
</head>
<body>

	<jsp:include page="components/navbar.jsp" />
	<div class="content-min">
		<div class="lines">
			<h1>Electra Shop</h1>
		</div>
	</div>
	
	<jsp:include page="components/admin_panel.jsp"/>
	
	<script src="script.js"></script>

</body>
</html>