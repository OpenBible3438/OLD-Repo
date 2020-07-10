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

	function setChart(year){
		cho_year = year;
		$("#set_Chart").text(cho_year);
		google.charts.setOnLoadCallback(drawChart_c_accum_members);
		google.charts.setOnLoadCallback(drawChart_c_ex_time_avg);
		google.charts.setOnLoadCallback(drawChart_c_cnt_mem_extime);
 		google.charts.setOnLoadCallback(drawChart_c_newmem);
		google.charts.setOnLoadCallback(drawChart_c_gym_sales); 
		google.charts.setOnLoadCallback(drawChart_c_tch_sales);
	}

	function drawChart_c_newmem() {
		var jsonData = $.ajax({
		    url: "../gym/chart_get_newmem.gym?cho_year="+cho_year,
		    dataType: "json",
		    async: false
		    }).responseText;
		    
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '월별 수강생 등록 현황',
		  legend: { position: 'bottom' }
		};
		var chart = new google.visualization.LineChart(document.getElementById('c_newmem'));
		chart.draw(data, options);
		window.addEventListener('resize', drawChart_c_newmem, false);
	}
	
	function drawChart_c_accum_members() {
		var jsonData = $.ajax({
		    url: "../gym/chart_accum_members.gym?cho_year="+cho_year,
		    dataType: "json",
		    async: false
		}).responseText;
		
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '누적 회원 수',
		  legend: { position: 'bottom' }
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.AreaChart(document.getElementById('c_accum_members'));
		chart.draw(data, options);
		window.addEventListener('resize', drawChart_c_accum_members, false);
	}
	
	
	function drawChart_c_ex_time_avg() {
		var jsonData = $.ajax({
		    url: "../gym/chart_ex_time_avg.gym?cho_year="+cho_year,
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
	function drawChart_c_cnt_mem_extime() {
		var jsonData = $.ajax({
		    url: "../gym/chart_cnt_mem_extime.gym?cho_year="+cho_year,
		    dataType: "json",
		    async: false
		}).responseText;
		    
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '시간대별 방문자 수 평균',
		  curveType: 'function',
		  legend: { position: 'bottom' }
		};
		var chart = new google.visualization.LineChart(document.getElementById('c_cnt_mem_extime'));
		chart.draw(data, options);
		window.addEventListener('resize', drawChart_c_cnt_mem_extime, false);
	}
	function drawChart_c_tch_sales() {
		var jsonData = $.ajax({
			url : "../gym/chart_tch_sales.gym?cho_year="+cho_year,
		    dataType: "json",
		    async: false
		}).responseText;
		    
		// Create our data table out of JSON data loaded from server.
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '강사별 월별 매출',
		  legend: { position: 'bottom' }
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.LineChart(document.getElementById('c_tch_sales'));
		chart.draw(data, options);
		window.addEventListener('resize', drawChart_c_tch_sales, false);
	}
	function drawChart_c_gym_sales() {
		var jsonData = $.ajax({
		    url: "../gym/chart_gym_sales.gym?cho_year="+cho_year,
		    dataType: "json",
		    async: false
		}).responseText;
		    
		// Create our data table out of JSON data loaded from server.
		var data = new google.visualization.DataTable(jsonData);
		var options = {
		  title: '월별 매출',
		  legend: { position: 'bottom' }
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.LineChart(document.getElementById('c_gym_sales'));
		chart.draw(data, options);
		window.addEventListener('resize', drawChart_c_gym_sales, false);
	}
</script>
</head>
<body>
<div style="padding: 20px;">
	<div class="form-group row form-inline" style="width:100%;">
   		<div class=" w-75" style="min-width:100px;"><h3><b>매장관리</b> / 차트</h3></div>   <!-- 제목 틀 입니다. -->
   		<div class="w-25">
			<div class="dropdown" style="float:right">
				  <button class="btn btn-secondary dropdown-toggle"
				  type="button" id="dropdownMenuButton"
				  data-toggle="dropdown" style="min-width:90px; height:45px;"
				  aria-haspopup="true" aria-expanded="false"><span id="set_Chart" style="margin:0;">2020</span>
				  </button>
				  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				    <a class="dropdown-item" href="javascript:setChart(2019)">2019</a>
				    <a class="dropdown-item" href="javascript:setChart(2020)">2020</a>
				  </div>
			</div>
		</div>
	</div>
   <hr>
    <!--=========================== 내용 시작 ===========================-->
	<div style="padding-left: 40px; padding-top: 20px">
<br>
			<div class="w-100" style="min-height:250px">
				<div class="w-100 h-100">
					<div>
						<div id="c_newmem"></div>
					</div>
				</div>
			</div>
			<div class="w-100" style="min-height:250px">
				<div class="w-100">
					<div>
						<div id="c_accum_members"></div>
					</div>
				</div>
			</div>
			<div class="w-100" style="min-height:250px">
				<div class="w-100">
					<div>
						<div id="c_tch_sales"></div>
					</div>
				</div>
			</div>
			<div class="w-100" style="min-height:250px">
				<div class="w-100">
					<div>
						<div id="c_gym_sales"></div>
					</div>
				</div>
			</div>
			<div class="w-100" style="min-height:250px">
				<div class="w-100">
					<div id="c_cnt_mem_extime"></div>
				</div>
			</div>
			<div class="w-100" style="min-height:250px">
				<div class="w-100">
					<div id="c_ex_time_avg"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			google.charts.load('current', {'packages':['corechart']});
			setChart(2020);
		});
	</script>
</body>
</html>
