<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type='checkbox' id='form-switch'>
	<form id='login-form' action="j_security_check" method="post">
		  <input type="text" name="j_username" placeholder="Nazwa użytkownika" required autofocus>
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