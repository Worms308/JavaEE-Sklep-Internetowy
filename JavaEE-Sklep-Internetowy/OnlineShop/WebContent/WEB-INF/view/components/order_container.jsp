<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="shopping-area">
	<h1>Podsumowanie</h1>
	<div class="table-card">
		<table border="1">
			<tr>
				<td>Pozycja</td>
				<td></td>
				<td>Ilość</td>
				<td>Cena</td>					
			</tr>
			<c:forEach items="${cart.phonesWithQuantity}" var="iterator" varStatus="index">
				<jsp:include page="cart_tile.jsp">
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
</div>

<div class="buyer_area">
	<div class="buyer_info">
		<h2>Dane zamawiającego:</h2>
		<p>${sessionScope.user.name} ${sessionScope.user.surname}</p>
		<p>${sessionScope.user.address.country}</p>
		<p>${sessionScope.user.address.street} ${sessionScope.user.address.streetNumber} ${sessionScope.user.address.homeNumber}</p>
		<p>${sessionScope.user.address.postalCode} ${sessionScope.user.address.city}</p>
		<p>Tel: ${sessionScope.user.phone}</p>
		<p>${sessionScope.user.email}</p>
	</div>
</div>
	
<form method="post" action="<c:url value="/realize"/>" style="width: 100%; text-align: left">
<div class="delivery_area">
	<div class="delivery_info">
		<h2>Sposób dostawy:</h2>
			<label><input type="radio" class="radio_btn" name="delivery" value="DHL" required> Kurier DHL</label><br>
			<label><input type="radio" class="radio_btn" name="delivery" value="DPD"> Kurier DPD</label><br>
			<label><input type="radio" class="radio_btn" name="delivery" value="Poczta polska"> Poczta Polska</label><br>
		</div>
</div>

<div class="delivery_area">
	<div class="payment_info">
		<h2>Płatność:</h2>
		<label><input type="radio" class="radio_btn" name="payment" value="transfer" required> Płatność z góry</label><br>
		<label><input type="radio" class="radio_btn" name="payment" value="cash on delivery"> Płatność przy odbiorze (+5zł)</label><br>
	</div>
</div>
		
<div class="buttons_op">
	<div class="buttons">
		<a href="<c:url value="/index"/>"><button>Strona główna</button></a>
		<button type="submit">Zamawiam</button>
	</div>
</div>
</form>
	
	