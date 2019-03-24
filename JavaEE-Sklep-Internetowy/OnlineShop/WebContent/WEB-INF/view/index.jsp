<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value="front-end-resources/css/style.css"/>">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

	<link href="https://fonts.googleapis.com/css?family=PT+Sans+Narrow" rel="stylesheet">

	

</head>

<body>

	<div class="nav">
		<ul>
  <li id="menu-item"><a href="index.html">Home</a></li>
  <li id="menu-item"><a href="#news">O nas</a></li>
  <li class="dropdown" id="menu-item">
    <a href="javascript:void(0)" class="dropbtn">Produkty</a>
    <div class="dropdown-content">
      <a href="all_products.html">Wszystkie</a>
      <a href="#">Smartfony</a>
      <a href="#">Laptopy</a>
    </div>
	<li id="menu-item"><a href="login.html">Logowanie</a></li>
	<li id="menu-item" style="margin-left: 62%;"><a href="#news"><i class="fas fa-user" id="item-nav"></i></a><li>
	<li><a href="#news"><i class="fas fa-shopping-basket" id="item-nav"></i></a></li>
</ul>
	</div>
	
	<div class="content">
		<div class="lines">
		<h1>Electra Shop</h1>
	</div>
	</div>
	

<div id="footer">
	by Electra Shop
</div>
	
	

<script src="script.js"></script>

</body>

</html>