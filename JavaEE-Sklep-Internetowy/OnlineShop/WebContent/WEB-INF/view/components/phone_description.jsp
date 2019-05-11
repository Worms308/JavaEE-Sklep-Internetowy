<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="all">
	<div class="product_space">
		
		<div class="info_single">
			<div class="content_single">
				<h1 class="text-center">${phone.manufacturer} ${phone.model}</h1>
				<h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac ex a est pharetra cursus. Praesent eu elementum nisi. Aenean molestie velit a ante ultrices condimentum. Pellentesque ornare sapien et ipsum fermentum, eu maximus justo sagittis. Cras nec nisi tellus. Proin malesuada efficitur efficitur. Quisque non lobortis nulla. Donec sodales mauris et orci malesuada, in congue eros commodo. Sed efficitur eros purus, a accumsan nunc varius consequat. Etiam nec enim posuere, venenatis mauris a, convallis lorem. </h5>
			</div>
		</div>
		
		<div class="info_single">
			<div class="stock-info">
				<c:choose>
					<c:when test="${phone.quantity > 0}">
						<p>Dostępność: ${phone.quantity}</p>
						<p class="stock_icon"><i class="fas fa-check stock_icon"></i></p>
					</c:when>    
					<c:otherwise>
						<p>Dostępność: Chwilowo niedostępny</p>
					<p class="stock_icon_unavailable"><i class="fas fa-times"></i></p>
					</c:otherwise>
				</c:choose>
			</div>
			
		</div>


		<c:if test="${phone.quantity > 0}">
			<div class="info_single">
				<div class="content_single">
					<button>Dodaj do koszyka</button>
				</div>
			</div>
		</c:if>
		
		<!-- Jeżeli produkt nie jest na stanie to nie będzie możliwości dodania
		     i możemy zrobić, że przycisk np. będzie szary. Ale to według Twojego uznania.-->
		
		
	</div>
	<div class="image_single">
		<img src="../<c:url value="front-end-resources/img/${phone.img}"/>"/>
	</div>
</div>

	
<div class="buttons_op">
	<div class="buttons">
		<a href="../products"><button>Kontynuuj zakupy</button></a>
		<a href="#"><button>Przejdź do koszyka</button></a>
	</div>
</div>