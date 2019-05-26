<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tr>
	<td>${param.id}</td>
	<td><a href="<c:url value="/products/phone?id=${param.id}"/>">${param.manufacturer} ${param.model}</a></td>
	<td><img src="<c:url value="/front-end-resources/img/${param.img}"/>" class="gallery__image" style="height: 120px; width:120px; margin: 0 auto;"></td>
	<td>${param.price}</td>
	
	<c:choose>
		<c:when test="${param.quantity > 0}">
			<td>${param.quantity}</td>
		</c:when>    
		<c:otherwise>
			<td><b style="color:red;">BRAK</b></td>
		</c:otherwise>
	</c:choose>

	<td>${param.rating}</td>
	<td>Edytuj</td>
</tr>