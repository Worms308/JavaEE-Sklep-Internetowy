<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="shopping-area">
	<h1>Moje zamówienia</h1>
	<div class="table-card">
		<table class="user-list-table" border="1">
			<tr>
				<td>ID</td>
				<td>Data</td>
				<td>Nazwy produktów</td>
				<td>Ilość produktów</td>
				<td>Status</td>			
			</tr>
			<c:forEach items="${orders}" var="iterator" varStatus="index">
				<jsp:include page="account_order_list.jsp">
				   	<jsp:param name="id" value="${index.index + 1}"/>
				   	<jsp:param name="date" value="${iterator.date_order}"/>
				   	<jsp:param name="name" value="${iterator.sale_phone_id.manufacturer} ${iterator.sale_phone_id.model}"/>
				   	<jsp:param name="quantity" value="${iterator.quantity}"/>
				   	<jsp:param name="state" value="${iterator.date_completed}"/>
			    </jsp:include>
			</c:forEach>		
		</table>
	</div>
</div>
	
<div class="buttons_op">
	<div class="buttons">
		<a href="<c:url value="/account"/>"><button>Powrót</button></a>
	</div>
</div>