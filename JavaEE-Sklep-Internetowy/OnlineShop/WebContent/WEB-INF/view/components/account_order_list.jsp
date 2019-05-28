<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tr>
	<td>${param.id}</td>
	<td>${param.date}</td>
	<td>${param.name}</td>
	<td>${param.quantity}</td>
	<c:if test="${param.state == '' }">
		<td>W trakcie</td>	
	</c:if>
	<c:if test="${param.state != '' }">
		<td>Zakończono</td>	
	</c:if>
</tr>	