<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="admin-area">
	<div class="admin_icon">
        <i class="fas fa-user-shield"></i>
    </div>
    <h1>Panel Administratora</h1>

    <div class="button-area">
    	<a href="<c:url value="/admin/stats"/>">
    		<button class="admin-btn">Statystyki sprzedaży</button>
    	</a>
        <a href="<c:url value="/admin/users"/>">
        	<button class="admin-btn">Lista użytkowników</button>
        </a>
        <a href="<c:url value="/admin/add_product"/>">
        	<button class="admin-btn">Dodaj produkt</button>
        </a>
        <a href="<c:url value="/admin/products"/>">
        	<button class="admin-btn">Lista produktów</button>
        </a>
	</div>
</div>