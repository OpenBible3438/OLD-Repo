<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	/* function toJson(){
	 var jsonData = $.ajax({
        url: "test.jsn",
        dataType:"json",
        data: {"id1":"first", "id2":"second", "id3":"third"},
        async: false
        }).responseText;
    // Create our data table out of JSON data loaded from server.
    var data = new google.visualization.DataTable(jsonData);

	var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
	chart.draw(data);
	location.href = "test.jsn2"
	} */
	///////////////////////////////////////////////////////////

   /*  var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
          }; */
 /*    var chart = new google.visualization.LineChart(document.getElementById('curve_chart')); */

   /*  chart.draw(data, options); */
    
	///////////////////////////////////////////////////////////
	
	google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
	
    function drawChart() {
      var jsonData = $.ajax({
          url: "testurl.jsn2",
          dataType: "json",
          async: false
          }).responseText;
          
      // Create our data table out of JSON data loaded from server.
      var data = new google.visualization.DataTable(jsonData);
      var options = {
        title: '차트 테스트',
        curveType: 'function',
        legend: { position: 'bottom' }
      };
      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }

	
</script>
</head>
<body>
	<div id="chart_div" style="width: 900px; height: 500px; border:1px solid black;" >
	</div>
</body>
</html>