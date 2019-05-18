<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<figure class="gallery__item">
      <a href="<c:url value="/products/phone?id=${param.id}"/>"><img src="<c:url value="/front-end-resources/img/${param.img}"/>" class="gallery__image"></a>
      <figcaption class="gallery__image-caption">
        ${param.manufacturer} ${param.model}<br>
		<a href="<c:url value="/products/phone?id=${param.id}"/>"><i class="fas fa-cart-plus"></i></a>
      </figcaption>
</figure> 