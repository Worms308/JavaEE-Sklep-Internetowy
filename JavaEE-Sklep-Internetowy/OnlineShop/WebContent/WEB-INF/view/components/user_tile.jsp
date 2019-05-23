<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tr>
	<td>${param.id}</td>
	<td>${param.login}</td>
	<td>${param.name}</td>
	<td>${param.description}</td>
	
	<c:choose>
		<c:when test="${param.description == 'admin'}">
		<td>
			<form method="post">
				<input type="hidden" value="${param.id}" name="id"/>
				<button style="cursor: pointer; background-color: transparent; border: none; color: #000;" type="submit"><i class="fas fa-arrow-down"></i><br>Degraduj do praw klienta</button>
			</form>
		</td>
		</c:when>    
		<c:otherwise>
		<td>
			<form method="post">
				<input type="hidden" value="${param.id}" name="id"/>
				<button style="cursor: pointer; background-color: transparent; border: none; color: #000;" type="submit"><i class="fas fa-arrow-up"></i><br>Nadaj prawa administratora</button>
			</form>
		</td>
		</c:otherwise>
	</c:choose>
	
	
</tr>