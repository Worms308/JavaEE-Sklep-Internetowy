<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="shopping-area">
		<h1>Lista użytkowników</h1>
		
		<div class="table-card">
			<table class="user-list-table" border="1">
				<tr>
					<td>ID</td>
					<td>Login</td>
					<td>Imie i nazwisko</td>
					<td>Prawa (Administrator/Klient)</td>
					<td>Zarządzaj prawami dostępu</td>
				</tr>
				<c:forEach items="${users}" var="iterator">
				    <jsp:include page="user_tile.jsp">
				    	<jsp:param name="id" value="${iterator.id}"/>
				    	<jsp:param name="login" value="${iterator.login}"/>
				    	<jsp:param name="name" value="${iterator.name} ${iterator.surname}"/>
				    	<jsp:param name="description" value="${iterator.usertype.description}"/>
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