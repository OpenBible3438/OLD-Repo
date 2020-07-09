<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function drawChart_c_ex_time_avg() {
	var jsonData = $.ajax({
	    url: "../gym/chart_ex_time_avg.gym?cho_year=2020",
	    dataType: "json",
	    async: false
	}).responseText;
	    
	var data = new google.visualization.DataTable(jsonData);
	var options = {
	  title: '평균 운동시간',
	  legend: { position: 'bottom' }
	};
	var chart = new google.visualization.PieChart(document.getElementById('c_ex_time_avg'));
	chart.draw(data, options);
	window.addEventListener('resize', drawChart_c_ex_time_avg, false);
}
</script>
</head>
<body>
<div id="c_ex_time_avg"></div>
	<script type="text/javascript">
		$(document).ready(function(){
			google.charts.load('current', {'packages':['corechart']});
			drawChart_c_ex_time_avg();
		});
	</script>
</body>
</html>