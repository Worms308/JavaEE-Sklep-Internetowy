<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="piechart1" style="width: 500px;"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart1);
	
	// Draw the chart and set the chart values
	function drawChart1() {
		var sold = google.visualization.arrayToDataTable([
	  	['Telefon', 'Ilość sprzedaży w ostatnim miesiacu'],
	  	<c:forEach items="${sold}" var="iterator">
	  		['${iterator.manufacturer} ${iterator.model}', ${iterator.quantity}],
		</c:forEach>
	  	['',0]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var options1 = {'title':'Ilość sprzedaży w ostatnim miesiacu', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var chart1 = new google.visualization.PieChart(document.getElementById('piechart1'));
	  chart1.draw(sold, options1);
	}
</script>