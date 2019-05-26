<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	
	<div class="shopping-area">
		<h1>Twój koszyk</h1>
	
		<c:if test="${not empty sessionScope.cart.phonesWithQuantity}">
		<div class="table-card">
			<table border="1">
				<tr>
					<td>Pozycja</td>
					<td></td>
					<td>Ilość</td>
					<td>Cena</td>
				</tr>
				<c:forEach items="${cart.phonesWithQuantity}" var="iterator" varStatus="index">
					<jsp:include page="components/cart_tile.jsp">
				    	<jsp:param name="id" value="${iterator.phone.phoneId}"/>
				    	<jsp:param name="name" value="${iterator.phone.manufacturer} ${iterator.phone.model}"/>
				    	<jsp:param name="img" value="${iterator.phone.img}"/>
				    	<jsp:param name="quantity" value="${iterator.quantity}"/>
				    	<jsp:param name="totalPrice" value="${iterator.totalPriceWithDiscount}"/>
				    </jsp:include>
				</c:forEach>
			</table>
		</div>
		
		<div class="payment">
			<table>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><h2>Do zapłaty:</h2><fmt:parseNumber type="number" pattern="#.##" value="${cart.totalPriceWithDiscount}"/>zł</td>
				</tr>
			</table>
			
		</div>
		</c:if>
		
		<c:if test="${empty sessionScope.cart.phonesWithQuantity}">
			<div style="width: 100%; display: flex;">
				<h3 style="margin: 0 auto;"><u>Twój koszyk jest pusty.</u></h3>
			</div>
		</c:if>
	
	</div>
	
	<div class="buttons_op">
		<div class="buttons">
			<a href="<c:url value="/products"/>"><button>Kontynuuj zakupy</button></a>
			<c:if test="${not empty sessionScope.cart.phonesWithQuantity}">
				<a href="<c:url value="/order"/>"><button>Do kasy</button></a>
			</c:if>
		</div>
	</div>
	
</body>
</html>