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
	var cho_year = 2020;
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart_c_accum_members);
google.charts.setOnLoadCallback(drawChart_c_ex_time_avg);
google.charts.setOnLoadCallback(drawChart_c_cnt_mem_extime);
google.charts.setOnLoadCallback(drawChart_c_newmem);
	
	function setChart_accum(year){
		cho_year = year;
		$("#btn_accum").text(cho_year);
		google.charts.setOnLoadCallback(drawChart_c_accum_members);
	}
	
	function setChart_newmem(year){
		cho_year = year;
		$("#btn_newmem").text(cho_year);
		google.charts.setOnLoadCallback(drawChart_c_newmem);
	}

	function drawChart_c_newmem() {
		var jsonData = $.ajax({
		    url: "../gym/chart_get_newmem.gym?cho_year="+cho_year,
		    dataType: "json",
		    async: false
		    }).responseText;
		    
		// Create our data table out of JSON data loaded from server.
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '월별 수강생 증가',
		  curveType: 'function',
		  legend: { position: 'bottom' }
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.LineChart(document.getElementById('c_newmem'));
		chart.draw(data, options);
	}
	
	function drawChart_c_accum_members() {
		var jsonData = $.ajax({
		    url: "../gym/chart_accum_members.gym?yy="+cho_year,
		    dataType: "json",
		    async: false
		}).responseText;
		    
		// Create our data table out of JSON data loaded from server.
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '누적 회원 수',
		  curveType: 'function',
		  legend: { position: 'bottom' }
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.LineChart(document.getElementById('c_accum_members'));
		chart.draw(data, options);
	}
	
	
	function drawChart_c_ex_time_avg() {
		var jsonData = $.ajax({
		    url: "../gym/chart_ex_time_avg.gym",
		    dataType: "json",
		    async: false
		}).responseText;
		    
		// Create our data table out of JSON data loaded from server.
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '평균 운동시간',
		  curveType: 'function',
		  legend: { position: 'bottom' }
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document.getElementById('c_ex_time_avg'));
		chart.draw(data, options);
	}
	function drawChart_c_cnt_mem_extime() {
		var jsonData = $.ajax({
		    url: "../gym/chart_cnt_mem_extime.gym",
		    dataType: "json",
		    async: false
		}).responseText;
		    
		// Create our data table out of JSON data loaded from server.
		var data = new google.visualization.DataTable(jsonData);
		var options = {

		  title: '시간대별 방문자 수 평균',
		  curveType: 'function',
		  legend: { position: 'bottom' }
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document.getElementById('c_cnt_mem_extime'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
<div id="test"></div>
	<div class="w-100 row h-25" style="border:1px solid black; min-height:350px">
		<div class="w-50 h-100">
			<div>
				 <div class="dropdown" style="margin-top:5px; align:right;">
					  <button class="btn btn-secondary dropdown-toggle"
					  type="button" id="dropdownMenuButton"
					  data-toggle="dropdown"
					  aria-haspopup="true" aria-expanded="false"><label id="btn_newmem" style="margin:0;">2020</label>
					  </button>
					  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					    <a class="dropdown-item" href="javascript:setChart_newmem(2019)">2019</a>
					    <a class="dropdown-item" href="javascript:setChart_newmem(2020)">2020</a>
					  </div>
				</div>
				<div id="c_newmem"></div>
			</div>
		</div>
		<div class="w-50 h-100">
			<div>
				<div class="dropdown" style="margin-top:5px; align:right;">
					  <button class="btn btn-secondary dropdown-toggle"
					  type="button" id="dropdownMenuButton"
					  data-toggle="dropdown"
					  aria-haspopup="true" aria-expanded="false"><label id="btn_accum" style="margin:0;">2020</label>
					  </button>
					  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					    <a class="dropdown-item" href="javascript:setChart_accum(2019)">2019</a>
					    <a class="dropdown-item" href="javascript:setChart_accum(2020)">2020</a>
					  </div>
				</div>
				<div id="c_accum_members"></div>
			</div>
		</div>
	</div>
	<div class="w-100 row h-25" style="border:1px solid black; min-height:350px">
		<div class="w-50">
			<div>
				<label>강사별 매출</label>
				<div id="c_tch_salse" style="border:1px solid black;">
					차트
				</div>
			</div>
		</div>
		<div class="w-50">
			<div>
				<label>전체 매출</label>
				<div id="c_all_sales">
					차트
				</div>
			</div>
		</div>
	</div>
	<div class="w-100 row h-25" style="border:1px solid black; min-height:350px">
		<div class="w-100">
			<div id="c_cnt_mem_extime"></div>
		</div>
	</div>
	<div class="w-100 row h-25" style="border:1px solid black; min-height:350px">
		<div class="w-100">
			<div id="c_ex_time_avg"></div>
		</div>
	</div>
</body>
</html>
