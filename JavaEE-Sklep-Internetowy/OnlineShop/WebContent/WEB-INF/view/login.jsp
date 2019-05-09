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
    <a href="javascript:void(0)" class="dropbtn">Smartfony</a>
    <div class="dropdown-content">
      <a href="all_products.html">Wszystkie</a>
      <a href="iphone-products.html">iPhone</a>
      <a href="samsung-products.html">Samsung</a>
	  <a href="huaweii-products.html">Huaweii</a>
	  <a href="xiaomi-products.html">Xiaomi</a>
    </div>
	<li id="menu-item"><a href="login.html">Logowanie</a></li>
	<li id="menu-item" style="margin-left: 62%;"><a href="#news"><i class="fas fa-user" id="item-nav"></i></a><li>
	<li><a href="#news"><i class="fas fa-shopping-basket" id="item-nav"></i></a></li>
</ul>
	</div>
	
	<div class="content">
		
		<div class="lines">
		
		<h1>Electra Shop</h1>
		
					<input type='checkbox' id='form-switch'>
<form id='login-form' action="j_security_check" method='post'>
  <input type="text" name="j_username" placeholder="Nazwa użytkownika" required>
  <input type="password" name="j_password" placeholder="Hasło" required>
  <button type='submit'>Zaloguj się</button>
  <br><br>
  <label for='form-switch'><span>Nie masz jeszcze konta? Zarejestruj się</span></label>
</form>

<form id='register-form' action="register" method="post">
  <input type="text" name="name" placeholder="Imie użytkownika" required>
  <input type="text" name="surname" placeholder="Nazwisko użytkownika" required>
  <input type="email" name="email" placeholder="Email" required>
  <input type="text" name="phone" placeholder="Nr telefonu" required>
  <input type="text" name="country" placeholder="Kraj zamieszkania" required>
  <input type="text" name="city" placeholder="Miejscowość" required>
  <input type="text" name="street" placeholder="Ulica" required>
  <input type="text" name="streetNum" placeholder="Nr ulicy" required>
  <input type="text" name="home" placeholder="Nr domu/mieszkania" required>
  <input type="text" name="postal" placeholder="Kod pocztowy" required>
 
  <input type="text" name="username" placeholder="Nazwa użytkownika" required>
  <input type="password" name="password" placeholder="Hasło" required>
  <input type="password" name="password2" placeholder="Powtórz hasło" required>
  <button type='submit'>Zarejestruj się</button>
  <br><br>
  <label for='form-switch' class="spanek">Jesteś użytkowniem? Zaloguj się</label>
</form>

		
	
	</div>
	
	
	
	
	
	
	


<div id="footer">
	by Electra Shop
</div>
	
	

</body>

</html>