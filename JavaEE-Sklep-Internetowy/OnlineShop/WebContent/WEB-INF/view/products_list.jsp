<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value="/front-end-resources/css/style.css"/>">
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

<div class="shopping-area">
	<h1>Lista produktów</h1>	
	<div class="table-card">
		<table class="user-list-table" border="1">
			<tr>
				<td>ID</td>
				<td>Nazwa</td>
				<td>Zdjęcie</td>
				<td>Cena (zł)</td>
				<td>Ilość w magazynie</td>
				<td>Średnia ocena</td>
				<td>Akcja</td>	
			</tr>
			
		  	<c:forEach items="${phones}" var="iterator">
			    <jsp:include page="components/product_admin_tile.jsp">
			    	<jsp:param name="id" value="${iterator.phoneId}"/>
			    	<jsp:param name="manufacturer" value="${iterator.manufacturer}"/>
			    	<jsp:param name="model" value="${iterator.model}"/>
			    	<jsp:param name="img" value="${iterator.img}"/>
			    	<jsp:param name="price" value="${iterator.price}"/>
			    	<jsp:param name="quantity" value="${iterator.quantity}"/>
			    	<jsp:param name="rating" value="${iterator.rating}"/>
			    </jsp:include>
		    </c:forEach>
				
			</table>
		</div>
	</div>
	
	<div class="buttons_op">
		<div class="buttons">
			<a href="<c:url value="/admin"/>"><button>Powrót</button></a>
		</div>
	</div>
</body>

</html>