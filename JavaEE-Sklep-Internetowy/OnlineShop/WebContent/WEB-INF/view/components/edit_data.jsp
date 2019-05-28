<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="shopping-area">
		<h1>Edytuj dane</h1>
		
		<div class="buyer_area">
			<div class="buyer_offline_info">
				<h2>Edytuj dane</h2>
				<h3>Dane osobowe</h3>
				<form action="<c:url value="/account/edit/personal_change"/>" method="post">
					<input class="offline" type="text" name="name" placeholder="Imię">
					<input class="offline" type="text" name="surname" placeholder="Nazwisko">
					<input class="offline" type="text" name="email" placeholder="Email">
					<input class="offline" type="text" name="phone" placeholder="Numer kontaktowy">
					<input type="submit" name="edit_data_submit" value="Zmień dane osobowe">
				</form> <br>
				<h3>Adres</h3>
				<form action="<c:url value="/account/edit/address_change"/>" method="post">
					<input class="offline" type="text" name="country" placeholder="Kraj">
					<input class="offline" type="text" name="city" placeholder="Miejscowość">
					<input class="offline" type="text" name="street" placeholder="Ulica">
					<input class="offline" type="text" name="street_number" placeholder="Nr ulicy">
					<input class="offline" type="text" name="house_number" placeholder="Nr domu/lokalu">
					<input class="offline" type="text" name="postal_code" placeholder="Kod pocztowy">
					<input type="submit" name="edit_data_submit" value="Zmień adres">
				</form> <br>
				<h3>Hasło</h3>
				<form action="" method="post">
					<input class="offline" type="password" name="actual_pass" placeholder="Stare hasło">
					<input class="offline" type="password" name="new_pass" placeholder="Nowe hasło">
					<input class="offline" type="password" name="new_pass2" placeholder="Powtórz nowe hasło">
					<p><b>${status}</b></p>
					<input type="submit" name="edit_data_submit" value="Zmień hasło">
				</form>
			</div>
	
		</div>
	
		
		<div class="delivery_area">
				<div class="delivery_info">
					<h2>Twoje aktualne dane:</h2>
					<p>${sessionScope.user.name} ${sessionScope.user.surname}</p>
					<p>${sessionScope.user.email}</p>
					<p>${sessionScope.user.phone}</p>		
					<p>${sessionScope.user.address.country}</p>		
					<p>${sessionScope.user.address.city} ${sessionScope.user.address.postalCode}</p>		
					<p>${sessionScope.user.address.street} ${sessionScope.user.address.streetNumber}/${sessionScope.user.address.homeNumber}</p>
				</div>
		</div>
	
	<div class="buttons_op">
		<div class="buttons">
			<a href="<c:url value="/account"/>"><button>Powrót</button></a>
		</div>
	</div>