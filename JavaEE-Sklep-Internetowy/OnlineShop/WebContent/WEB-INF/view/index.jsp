<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/front-end-resources/css/style.css"/>">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>

<body>


<nav role="navigation" class="nav">
    <ul class="nav-items">
        <li class="nav-item">
            <a href="#" class="nav-link"><span>Home</span></a>
        </li> 
        <li class="nav-item dropdown">
            <a href="#" class="nav-link"><span>Products</span></a>
            <nav class="submenu">
                <ul class="submenu-items">
                    <li class="submenu-item"><a href="#" class="submenu-link">Product #1</a></li>
                    <li class="submenu-item"><a href="#" class="submenu-link">Product #2</a></li>
                    <li class="submenu-item"><a href="#" class="submenu-link">Product #3</a></li>
                </ul>
            </nav>
        </li> 
        <li class="nav-item">
            <a href="login.html" class="nav-link"><span>Log In</span></a>
        </li>
        <li class="nav-item dropdown">
            <a href="#" class="nav-link"><span>More</span></a>
            <nav class="submenu">
                <ul class="submenu-items">
                    <li class="submenu-item"><a href="#" class="submenu-link">About</a></li>
                    <li class="submenu-item"><a href="#" class="submenu-link">Contact</a></li>
                    <li class="submenu-item"><hr class="submenu-seperator" /></li>
                    <li class="submenu-item"><a href="#" class="submenu-link">Support</a></li>
                    <li class="submenu-item"><a href="#" class="submenu-link">FAQs</a></li>
                    <li class="submenu-item"><a href="#" class="submenu-link">Careers</a></li>
                </ul>
           "WebContent/login.html" </nav>
        </li>  
    </ul>
</nav> 



<div id="logo">

<h1> Toy Land </h1>

<p>The best surprise for Your Children!</p>

</div>

<div id="icons">

  <a href="login.html"><i class="large material-icons">account_circle</i></a>
 
</div>           

<div id="footer">

Toy Land 2019, All rights reserved

</div>

<script src="js/script.js"></script>

</body>
</html>