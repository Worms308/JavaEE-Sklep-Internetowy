<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topnav" id="myTopnav">

	<a href="index">Home</a>
	<a href="#">O nas</a>
	<a href="products">Sklep</a>
	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<a href="login">Logowanie</a>
		</c:when>    
		<c:otherwise>
			<a href="#">Witaj, ${user.name}</a>
		</c:otherwise>
	</c:choose>
	
	<div class="icons_space">
		<a href="login" class="user_margin"><i class="fas fa-user" id="item-nav"></i></a>
		<a href="koszyk"><i class="fas fa-shopping-basket" id="item-nav"></i></a>
	</div>
	
	<c:if test="${sessionScope.user != null}">
		<a href="index"><i class="fas fa-sign-out-alt" id="item-nav"></i></a>
	</c:if>


	</div>