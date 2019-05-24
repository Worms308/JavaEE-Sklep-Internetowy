<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="piechart2" style="width: 500px;"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart2);
	
	// Draw the chart and set the chart values
	function drawChart2() {
		var data2 = google.visualization.arrayToDataTable([
	  	['Telefon', 'Ilość na magazynie'],
	  	<c:forEach items="${storage}" var="iterator2">
	  		['${iterator2.manufacturer} ${iterator2.model}', ${iterator2.quantity}],
		</c:forEach>
	  	['',0]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var options2 = {'title':'Ilość na magazynie', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var chart2 = new google.visualization.PieChart(document.getElementById('piechart2'));
	  chart2.draw(data2, options2);
	}
</script>