<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="all">
	<div class="product_space">
		<div class="info_single">
			<div class="content_single">
				<h1 class="text-center">${phone.manufacturer} ${phone.model}</h1>
				
				<style>
					table {
						border: none;
					}
					
					th {
						text-align: left;
					}
					
					td {
						padding-left: 18px;
					}
					
					.price {
						font-weight: 700;
						margin: 40px 0;
					}
					
					.price__value {
						font-size: 40px;
						color: #19247c;
						margin: 0 0 0 25px;
						
					}
					
				</style>
				
				<table style="border: none;">
						<tr>
							<th>Producent</th>
							<td>${phone.manufacturer}</td>
						</tr>
						<tr>
							<th>Model</th>
							<td>${phone.model}</td>
						</tr>
						<tr>
							<th>Procesor</th>
							<td>${phone.processor}</td>
						</tr>
						<tr>
							<th>System</th>
							<td>${phone.system}</td>
						</tr>
						<tr>
							<th>Ekran</th>
							<td>${phone.screenSize}"</td>
						</tr>
						<tr>
							<th>Ram</th>
							<td>${phone.ram} GB</td>
						</tr>
						<tr>
							<th>Pamięć</th>
							<td>${phone.storage} GB</td>
						</tr>
						<tr>
							<th>Kamera</th>
							<td>${phone.camera} MPX</td>
						</tr>
						<tr>
							<th>Ocena </th>
							<c:choose>
								<c:when test="${phone.rating <= 1.5}">
									<td> <span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</td>
								</c:when>
								<c:when test="${phone.rating > 1.5 && phone.rating <= 2.5}">
									<td> <span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</td>
								</c:when>
								<c:when test="${phone.rating > 2.5 && phone.rating <= 3.5}">
									<td> <span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</td>
								</c:when>
								<c:when test="${phone.rating > 3.5 && phone.rating <= 4.5}">
									<td> <span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
									</td>
								</c:when>
								<c:when test="${phone.rating > 4.5}">
									<td> <span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
									</td>
								</c:when>
							</c:choose>
						</tr>
				 </table>
				 
				 <div class="rating text-center">
					
				</div>	

				 <div class="price">
					 <c:choose>
					 	<c:when test="${phone.discount > 0}">
					 		<c:set var="price_discount" scope = "session" value="${phone.price - phone.discount*phone.price}"/>
							<b>Cena przed obniżką:</b>
							<span class="strikethrough price__value">
							 	<fmt:parseNumber type="number" pattern="#.##" value="${phone.price}"/> zł
							 </span>
							 <br></br>
							<b>Cena po obniżce:</b> 
							<span class="price__value">
								<fmt:parseNumber type="number" pattern="#.##" value="${price_discount}"/> zł 
							</span>
					 	</c:when>
						 <c:otherwise>
						 	<b>Cena:</b> 
						 	<span class="price__value">
						 		<fmt:parseNumber type="number" pattern="#.##" value="${phone.price}"/> zł
						 	</span>
						 </c:otherwise>
					 </c:choose>
				 </div>
				
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
				<form action="<c:url value="/cart"/>" method="post">
					<button type="submit" name="id" value="${phone.phoneId}">Dodaj do koszyka</button>
				</form>
				</div>
			</div>
		</c:if>
		
	</div>
	<div class="image_single">
		<img src="<c:url value="/front-end-resources/img/${phone.img}"/>"/>
	</div>
</div>

	
<div class="buttons_op">
	<div class="buttons">
		<a href="<c:url value="/products"/>"><button>Kontynuuj zakupy</button></a>
		<a href="<c:url value="/cart"/>"><button>Przejdź do koszyka</button></a>
	</div>
</div>