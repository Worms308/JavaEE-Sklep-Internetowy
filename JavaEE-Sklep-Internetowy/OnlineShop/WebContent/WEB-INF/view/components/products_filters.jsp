<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	 <main class="site-wrapper">
      <h1 class="text-center first_h1">Kategorie produktów</h1>
      <div class="filters">
        <select id="company">
          <option value="">Firma</option>
          <option value="apple">Apple</option>
          <option value="samsung">Samsung</option>
          <option value="huaweii">Huaweii</option>
          <option value="xiaomi">Xiaomi</option>
        </select>

        <!--Jeśli Apple-->
        <select id="model">
          <option value="">Model</option>
          <option value="iphone4s">iPhone 4s</option>
          <option value="iphone5">iPhone 5</option>
        </select>

        <!--Jeśli Samsung-->
        <!--<select id="model">
    <option value="">Model</option>
	<option value="s8">S8</option>
    <option value="s9">S9</option>
    <option value="j7">J7 2017</option>
</select>-->

        <!--Jeśli Huaweii-->
        <!--<select id="model">
    <option value="">Model</option>
	<option value="p30">P30</option>
    <option value="y6">Y6</option>
</select>-->

        <!--Jeśli Xiaomi-->
        <!--<select id="model">
    <option value="">Model</option>
	<option value="mia2">MI A2</option>
    <option value="redmi6a">Redmi 6A</option>
</select>-->

        <select id="processor">
          <option value="">Procesor</option>
          <option value="qs845">Qualcomm Snapdragon 845</option>
          <option value="qs835">Qualcomm Snapdragon 835</option>
          <option value="e9810">Exynos 9810</option>
        </select>

        <select id="system">
          <option value="">System</option>
          <option value="os">iPhone OS</option>
          <option value="android">Android</option>
          <option value="wp">Windows Phone</option>
        </select>

        <select id="size">
          <option value="">Rozmiar ekranu</option>
          <option value="5cal">do 5 cali</option>
          <option value="6cal">do 6 cali</option>
          <option value="7cal">do 7 cali</option>
        </select>
      </div>

      <div class="filters">
        <select id="ram">
          <option value="">RAM</option>
          <option value="to_2gb_ram">do 2GB</option>
          <option value="to_4gb_ram">do 4GB</option>
          <option value="to_8gb_ram">do 8GB</option>
          <option value="from_8gb_ram">od 8GB</option>
        </select>

        <select id="memory">
          <option value="">Pamięć</option>
          <option value="to_8GB_memory">do 8GB</option>
          <option value="to_16GB_memory">do 16GB</option>
          <option value="from_16GB_memory">od 16GB</option>
        </select>

        <select id="camera">
          <option value="">Kamera</option>
          <option value="to_5mpix">do 5Mpix</option>
          <option value="to_8mpix">do 8Mpix</option>
          <option value="from_ 8Mpix">od 8Mpix</option>
        </select>

        <select id="price">
          <option value="">Cena</option>
          <option value="to_500zl">do 500zł</option>
          <option value="to_1000zl">do 1000zł</option>
          <option value="to_2000zl">do 2000zł</option>
          <option value="from_2000zl">od 2000zł</option>
        </select>

        <select id="assessment">
          <option value="">Ocena</option>
          <option value="to_4_assessment">do 4</option>
          <option value="5_assessment">5</option>
          <!-- Zakładam, że 5 to max ocena-->
        </select>
      </div>
      <div class="buttons_op">
        <div class="buttons">
          <a href="#"><button>Fitruj</button></a>
        </div>
      </div>
      <section class="gallery">
        <figure class="gallery__item">
          <img src="img/iphone.png" alt="" class="gallery__image" />
          <figcaption class="gallery__image-caption">
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>

        <figure class="gallery__item">
          <img class="gallery__image" src="img/omen.png" />
          <figcaption class="gallery__image-caption">
            <br />
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>

        <figure class="gallery__item">
          <img class="gallery__image" src="img/iphone.png" />
          <figcaption class="gallery__image-caption">
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>

        <figure class="gallery__item">
          <img class="gallery__image" src="img/omen.png" />
          <figcaption class="gallery__image-caption">
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>

        <figure class="gallery__item">
          <img class="gallery__image" src="img/iphone.png" />
          <figcaption class="gallery__image-caption">
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>

        <figure class="gallery__item">
          <img class="gallery__image" src="img/omen.png" />
          <figcaption class="gallery__image-caption">
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>

        <figure class="gallery__item">
          <img class="gallery__image" src="img/iphone.png" />
          <figcaption class="gallery__image-caption">
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>

        <figure class="gallery__item">
          <img class="gallery__image" src="img/samsung.jpg" />
          <figcaption class="gallery__image-caption">
            Lorem ipsum dolor sit amet.<br />
            <i class="fas fa-cart-plus"></i>
          </figcaption>
        </figure>
      </section>
    </main>