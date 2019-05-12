<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tr>
	<td>${param.id}</td>
	<td><img src="<c:url value="/front-end-resources/img/${param.img}"/>"></td>
	<td>${param.quantity}</td>
	<td><fmt:parseNumber type="number" pattern="#.##" value="${param.totalPrice}"/>zł</td>				
</tr>