<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기내짐 로그인 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
<script type="text/javascript">
	function join() {
		alert("회원가입");
		//모달 처리 ...
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
	function id_confirm() {
		alert("중복검사 클릭");
	}
	function addrSearch() {
		alert("주소검색 클릭 ");
	}
</script>
</head>
<body>
<!-- ===================== 로고 부분 ===================== -->
<div class="jumbotron text-center" style="padding-top:0; padding-bottom: 0;
                                          margin-bottom:0; height: 120px;">
  <img alt="" src="../images/logo.png" style="width:230px; height:120px; padding:0; margin:0;"/>
</div>

<!-- ===================== 카로우즐 부분 ===================== -->
<div class="jumbotron text-center" style="padding-top:0; padding-bottom: 0; margin-bottom:0; height: 450px;">
	<div id="startCarosel" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#startCarosel" data-slide-to="0" class="active"></li>
			<li data-target="#startCarosel" data-slide-to="1"></li>
			<li data-target="#startCarosel" data-slide-to="2"></li>
			<li data-target="#startCarosel" data-slide-to="3"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="../images/fitness.jpg" alt="Fitness" width="1200" height="400">
			</div>
			<div class="carousel-item">
				<img src="../images/flower.jpg" alt="Flower" width="1200" height="400">
			</div>
			<div class="carousel-item">
				<img src="../images/prj.PNG" alt="Project" width="1200" height="400">
			</div>
			<div class="carousel-item">
				<img src="../images/sofa_cat.jpg" alt="SofaCat" width="1200" height="400">
			</div>
		</div>
		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#startCarosel" data-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#startCarosel" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
</div>
<!-- 
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			
			Indicators
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
			Wrapper for slides
			<div class="carousel-inner" role="listbox">

				<div class="item active">
					<img src="./../images/fitness.jpg" alt="Fitness" style="width:1200px; height:400px"/>
					<div class="carousel-caption">
						<h3>Chania</h3>
						<p>The atmosphere in Chania has a touch of Florence and
							Venice.</p>
					</div>
				</div>
			</div>
			Left and right controls
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
</div> -->
<!-- ===================== 로그인 부분 ===================== -->
<div class="jumbotron text" style="padding-top:0; padding-bottom: 0; margin-bottom:0; height: auto; min-height:350px">
	<div class="row" style="padding-top:50px;">
	    <div class="col-sm-1"></div>
	    <div class="col-sm-7">
	    	<h1>대충 환영한다는 문구</h1>
	    </div>
	    <div class="col-sm-4">
			<form id="f_login" class="form" >
				<div class="form-group row">
					<label for="gym_id" class="col-sm-4 col-form-label ">아이디</label>
					<div class="col-sm-8">
						<input type="text" id="gym_id" class="form-control">
					</div>
				</div>
				<div class="form-group row">
					<label for="gym_pw" class="col-sm-4 col-form-label">비밀번호</label>
					<div class="col-sm-8">
						<input type="password" id="gym_pw" class="form-control">
					</div>
				</div>
			</form>
			<div class="row" style="padding-top:5px">
				<div class="col-sm-6">
					<button type="button" class="btn btn-secondary"
							data-toggle="modal" data-target="#m_join" style="width:100%">회원가입</button>
				</div>
				<div class="col-sm-6">
					<button onclick="login()" class="btn btn-secondary" 
					        style="width:100%; padding-left:10px">로그인</button>
				</div>
			</div>
		</div>
  	</div>
</div>
<!-- ===================== 회원가입 모달 부분  ===================== -->
	<%@ include file="./join.jsp" %>
</body>
</html>
			
