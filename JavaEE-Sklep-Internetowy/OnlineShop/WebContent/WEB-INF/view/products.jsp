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
	
	<div class="content">
		<div class="lines">
		<h1>Electra Shop</h1>
	</div>
	</div>
	
	<jsp:include page="components/products_filters.jsp">
		<jsp:param name="manufacturers" value="${manufacturers}"/>
		<jsp:param name="models" value="${models}"/>
		<jsp:param name="system" value="${system}"/>
		<jsp:param name="processor" value="${processor}"/>
	</jsp:include>

	
<main class="site-wrapper">

<h1 class="text-gallery"> Produkty</h1>
  <section class="gallery">
  	<c:forEach items="${phones}" var="iterator">
	    <jsp:include page="components/phone_tile.jsp">
	    	<jsp:param name="manufacturer" value="${iterator.manufacturer}"/>
	    	<jsp:param name="model" value="${iterator.model}"/>
	    	<jsp:param name="id" value="${iterator.phoneId}"/>
	    	<jsp:param name="img" value="${iterator.img}"/>
	    </jsp:include>
    </c:forEach>
    
  </section>
</main>
	

</body>

</html>