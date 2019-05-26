<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tr>
	<td><a href="<c:url value="/products/phone?id=${param.id}"/>">${param.name}</a></td>
	<td><img src="<c:url value="/front-end-resources/img/${param.img}"/>"></td>
	<td>${param.quantity}</td>
	<td><fmt:parseNumber type="number" pattern="#.##" value="${param.totalPrice}"/>zł</td>
	<td><a href="<c:url value="/cart/remove?id=${param.id}"/>"><i class="fa fa-trash" aria-hidden="true"></i><br>Usuń			</a>
</tr>