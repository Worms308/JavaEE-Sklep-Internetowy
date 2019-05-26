<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value="/front-end-resources/css/style.css"/>">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

	<link href="https://fonts.googleapis.com/css?family=PT+Sans+Narrow" rel="stylesheet">
</head>
<body>

	<jsp:include page="components/navbar.jsp" />
	<div class="content-min">
		<div class="lines">
			<h1>Electra Shop</h1>
		</div>
	</div>
	<div class="shopping-area">
		<h1>Dodaj produkt</h1>
		
		<div class="table-card">
			<form action="" method="POST" class="admin-form">
			
			Producent: <input type="text" class="input-admin" name="manufacturer" required><br><br>
			Model: <input type="text" class="input-admin" name="model" required><br><br>
			Procesor: <input type="text" class="input-admin" name="processor" required><br><br>
			System: <input type="text" class="input-admin" name="system" required><br><br>
			Rozmiar ekranu: <input type="text" class="input-admin" name="screen_size" required><br><br>
			RAM: <input type="text" class="input-admin" name="ram" required><br><br>
			Pamięć: <input type="text" class="input-admin" name="storage" required><br><br>
			Aparat: <input type="text" class="input-admin" name="camera" required><br><br>
			Cena: <input type="text" class="input-admin" name="price" required><br><br>
			Ilość: <input type="text" class="input-admin" name="quantity" required><br><br>
			Nazwa zdjęcia (.png): <input type="text" class="input-admin" placeholder="Pamiętaj dodać zdjęcie do serwera!" name="img" required><br><br>
			<span style="color: #000; margin: 0 auto;"><b>${status}</b></span><br>
			<input type="submit" value="Dodaj produkt">

		</form>
		
	
	</div>

	<div class="buttons_op">
		<div class="buttons">
			<a href="<c:url value="/admin"/>"><button>Powrót</button></a>
		</div>
	</div>
	
	<script src="script.js"></script>

</body>
</html>