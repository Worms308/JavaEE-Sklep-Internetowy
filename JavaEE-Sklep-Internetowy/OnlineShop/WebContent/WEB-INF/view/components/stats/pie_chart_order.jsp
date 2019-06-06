<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="piechart3" style="width: 500px;"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart3);
	
	// Draw the chart and set the chart values
	function drawChart3(){
		var data3 = google.visualization.arrayToDataTable([
	  	['Telefon', 'Przewidywane braki magazynowe'],
	  	<c:forEach items="${estimated}" var="iterator3">
	  		['${iterator3.manufacturer} ${iterator3.model}', ${iterator3.quantity}],
		</c:forEach>
	  	['',0]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var options3 = {
			  'title':'Przewidywane braki magazynowe',
			  'width':550,
			  'height':400,
			  'pieSliceText':'value'
			  };
	
	  // Display the chart inside the <div> element with id="piechart"
	  var chart3 = new google.visualization.PieChart(document.getElementById('piechart3'));
	  chart3.draw(data3, options3);
	}
</script>