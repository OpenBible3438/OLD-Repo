<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기내짐 로그인 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
<script type="text/javascript">
	function join() {
		alert("회원가입");
	}
	function login() {
		alert("로그인");
		var id = $('#ids').val();
		var pw = $('#pwd').val();
		alert("ids : "+id+", pwd : "+ pw);
		/*
		$('#f_login').attr('method','get');
		$('#f_login').attr('action','./login.jsp');
		$('#f_login').submit();
		*/
	}
</script>
</head>
<body>
<div class="jumbotron text-center" style="padding-top:0; padding-bottom: 0;
                                          margin-bottom:0; height: 120px;">
  <img alt="" src="../images/logo.png" style="width:230px; height:120px; padding:0; margin:0;"/>
</div>
<div class="jumbotron text-center" style="padding-top:0; padding-bottom: 0; margin-bottom:0; height: 450px;">
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">

				<div class="item active">
					<img src="./../images/fitness.jpg" alt="Fitness" style="width:600px; height:400px"/>
					<div class="carousel-caption">
						<h3>Chania</h3>
						<p>The atmosphere in Chania has a touch of Florence and
							Venice.</p>
					</div>
				</div>
				<div class="item">
					<img src="./../images/prj.PNG" alt="Project" style="width:600px; height:400px"/>
					<div class="carousel-caption">
						<h3>Chania</h3>
						<p>The atmosphere in Chania has a touch of Florence and
							Venice.</p>
					</div>
				</div>
				<div class="item">
					<img src="./../images/flower.jpg" alt="Flower" style="width:600px; height:400px"/>
					<div class="carousel-caption">
						<h3>Flowers</h3>
						<p>Beautiful flowers in Kolymbari, Crete.</p>
					</div>
				</div>
				<div class="item">
					<img src="./../images/sofa_cat.jpg" alt="Cat" style="width:600px; height:400px"/>
					<div class="carousel-caption">
						<h3>Flowers</h3>
						<p>Beautiful flowers in Kolymbari, Crete.</p>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>
<div class="jumbotron text" style="padding-top:0; padding-bottom: 0; margin-bottom:0; height: 280px;">
<div class="row" style="padding-top:50px;">
    <div class="col-sm-1"></div>
    <div class="col-sm-7">
    	<h1>대충 환영한다는 문구</h1>
    </div>
    <div class="col-sm-4">
		<form id="f_login" class="form-inline" >
		<div class="row">
			<div class="form-group">
				<label for="ids" style="width:50px">ID:</label> 
				<input type="text" 
				       class="form-control" 
				       id="ids" placeholder="Enter ID" name="ids">
			</div>
		</div>
		<div class="row" style="padding-top:5px">
			<div class="form-group">
				<label for="pwd" style="width:50px">PW:</label> 
				<input type="password" 
				       class="form-control" 
				       id="pwd" placeholder="Enter PW" name="pwd">
			</div>
		</div>
		</form>
			<div class="row" style="padding-top:5px">
				<button onclick="join()" class="btn btn-default"
				        style="width:130px">회원가입</button>
				<button onclick="login()" class="btn btn-default"
					    style="width:130px">로그인</button>
			</div>
	</div>
  </div>
</div>
</body>
</html>
			
