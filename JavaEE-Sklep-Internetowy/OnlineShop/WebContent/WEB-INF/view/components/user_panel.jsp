<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="admin-area">
	<div class="admin_icon">
    	<i class="fas fa-user-alt"></i>
	</div>
		<h1>Panel Użytkownika</h1>

		<div class="button-area">
			<a href="<c:url value="/account/edit"/>">
          		<button class="admin-btn">Edytuj dane</button>
			</a>
			<a href="<c:url value="/account/orders"/>">
        		<button class="admin-btn">Moje zamówienia</button>
        	</a>
	</div>
</div>