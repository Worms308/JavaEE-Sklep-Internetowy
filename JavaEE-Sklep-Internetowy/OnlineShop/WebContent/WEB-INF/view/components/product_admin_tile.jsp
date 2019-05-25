<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tr>
	<td>${param.id}</td>
	<td>${param.manufacturer} ${param.model}</td>
	<td><img src="<c:url value="/front-end-resources/img/${param.img}"/>" class="gallery__image" style="height: 120px; width:120px; margin: 0 auto;"></td>
	<td>${param.price}</td>
	<td>${param.quantity}</td>
	<td>${param.rating}</td>
	<td>Edytuj</td>
</tr>