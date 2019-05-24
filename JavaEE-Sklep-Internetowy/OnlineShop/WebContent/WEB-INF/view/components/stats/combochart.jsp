<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="chart_div" style="width: 900px; height: 500px; margin: 0 auto;"></div>


    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization3);

      function drawVisualization3() {
        // Some raw data (not necessarily accurate)
        var data3 = google.visualization.arrayToDataTable([
          ${comboChart}
        ]);

        var options3 = {
          title : 'Miesięczna sprzedaż',
          vAxis: {title: 'Sztuki'},
          hAxis: {title: 'Miesiące'},
          seriesType: 'bars',
          series: {5: {type: 'line'}}
        };

        var chart3 = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart3.draw(data3, options3);
      }
    </script>
