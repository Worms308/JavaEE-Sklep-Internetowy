<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main class="site-wrapper">
	<h1 class="text-center first_h1">Kategorie produktów</h1>
	 <form action="<c:url value="/products"/>" method="post" class="form-filter" style="width: 100%"> 
	
    <div class="filters">
    	<select id="manufacturer" name="manufacturer">
	        <option value="">Firma</option>
	        <c:forEach items="${manufacturers}" var="iterator">
	        	<option value="${iterator}">${iterator}</option>
	        </c:forEach>
        </select>

        <select id="model" name="model">
          	<option value="">Model</option>
	        <c:forEach items="${models}" var="iterator">
	        	<option value="${iterator}">${iterator}</option>
	        </c:forEach>
        </select>

        <select id="processor" name="processor">
	        <option value="">Procesor</option>
	        <c:forEach items="${processor}" var="iterator">
	        	<option value="${iterator}">${iterator}</option>
	        </c:forEach>
        </select>

        <select id="system" name="system">
	        <option value="">System</option>
	        <c:forEach items="${system}" var="iterator">
	        	<option value="${iterator}">${iterator}</option>
	        </c:forEach>
        </select>

        <select id="screen" name="screen">
	        <option value="">Rozmiar ekranu</option>
	        <option value="5">do 5"</option>
	        <option value="6">do 6"</option>
	        <option value="7">do 7"</option>
	        <option value="8">do 8"</option>
        </select>
	</div>

    <div class="filters">
    	<select id="ram" name="ram">
	        <option value="">RAM</option>
	        <option value="2">2GB</option>
	        <option value="4">4GB</option>
	        <option value="8">8GB</option>
	        <option value="16">16GB</option>
        </select>

        <select id="storage" name="storage">
	        <option value="">Pamięć</option>
	        <option value="64">64GB</option>
	        <option value="128">128GB</option>
	        <option value="256">256GB</option>
        </select>

        <select id="camera" name="camera">
	        <option value="">Kamera</option>
	        <option value="to_15">do 15Mpix</option>
	        <option value="to_25">do 25Mpix</option>
	        <option value="to_40">do 40Mpix</option>
	        <option value="from_40">od 40Mpix</option>
        </select>

        <select id="price" name="price">
	        <option value="">Cena</option>
	        <option value="to_500">do 500zł</option>
	        <option value="to_1000">do 1000zł</option>
	        <option value="to_2000">do 2000zł</option>
	        <option value="from_2000">od 2000zł</option>
        </select>

        <select id="rating" name="rating">
	        <option value="">Ocena</option>
	        <option value="2">2</option>
	        <option value="3">3</option>
	        <option value="4">4</option>
	        <option value="5">5</option>
        </select>
        
	</div>
	<div class="buttons_op">
		<div class="buttons">
        	<button type="submit">Fitruj</button>
        </div>
	</div>
	</form> 
</main>