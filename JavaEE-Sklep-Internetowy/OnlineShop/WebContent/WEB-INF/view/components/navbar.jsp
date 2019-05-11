<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="nav">
		<ul>
		  <li id="menu-item"><a href="index">Strona główna</a></li>
		  <li id="menu-item"><a href="#news">O nas</a></li>
		  <li id="menu-item"><a href="products">Smartfony</a></li>
		    <%
		        Object username = session.getAttribute("user");                     
		        if (username == null) {
		    %>
		        <li id="menu-item"><a href="login">Logowanie</a></li>
		    <% } else { %>
		        <li id="menu-item"><a href="#">Witaj, ${user.name}</a></li>
		    <% }%>
			
			<li id="menu-item" style="margin-left: 62%;"><a href="#news"><i class="fas fa-user" id="item-nav"></i></a><li>
			<li><a href="#news"><i class="fas fa-shopping-basket" id="item-nav"></i></a></li>
			<%                   
		        if (username != null) {
		    %>
		        <li><a href="logout"><i class="fas fa-sign-out-alt" id="item-nav"></i></a></li>
		    <% } %>
			
		</ul>
	</div>