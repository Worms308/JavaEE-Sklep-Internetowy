<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topnav" id="myTopnav">

	<a href="<c:url value="/index"/>">Home</a>
	<a href="#">O nas</a>
	<a href="<c:url value="/products"/>">Sklep</a>
	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<a href="<c:url value="/login"/>">Logowanie</a>
		</c:when>    
		<c:otherwise>
			<a href="#">Witaj, ${user.name}</a>
		</c:otherwise>
	</c:choose>
	<c:if test="${sessionScope.user.usertype.description == 'admin'}">
		<a href="<c:url value="/admin"/>"><b>Panel administratora</b></a>
	</c:if>
	
	<div class="icons_space">
		<a href="<c:url value="login"/>" class="user_margin"><i class="fas fa-user" id="item-nav"></i></a>
		<a href="<c:url value="/cart"/>"><i class="fas fa-shopping-basket" id="item-nav"></i></a>
	</div>
	
	<c:if test="${sessionScope.user != null}">
		<a href="<c:url value="/logout"/>"><i class="fas fa-sign-out-alt" id="item-nav"></i></a>
	</c:if>
	
</div>