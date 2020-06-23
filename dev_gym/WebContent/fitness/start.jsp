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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
<script type="text/javascript">
	var id_check = 1;
	var pw_check = 1;
	function addrSearch() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            var result = JSON.stringify(data);
	            var addrDoc = JSON.parse(result);
	            $('#gym_addr').val(addrDoc.address);
	            $('#gym_zipcode').val(addrDoc.zonecode);
	            $('#gym_sido').val(addrDoc.sido);
	        }
	    }).open();
	}
	function joinINS() {
		alert("회원가입에서 등록 클릭");
		$('#gym_join').attr('action','./gym/joinResult.gym');
		$('#gym_join').submit();
	}
	function login() {
		alert("로그인");
		var gym_id = $('#gym_id').val();
		var gym_pw = $('#gym_pw').val();
		//alert("gym_id : "+gym_id+", gym_pw : "+ gym_pw);
		$.ajax({  //enctype="multipart/form-data",contentType : false,processData : false
			method:'post'
			,data: 'gym_id='+gym_id+'&gym_pw='+gym_pw
			,url: './gym/jsonLogin.gym'
			,success: function(data) {
				//alert("data : "+data.trim());
				var confirm = data.trim().split("/");
				if("login" == confirm[0]) {
					alert(confirm[1]);
					location.href = "./main/main.jsp"
				} else {
					alert(confirm[1]);
				}
				
			}
		});
	}
	function id_confirm() {
		//alert("중복확인");
		var gym_id = $('#j_gym_id').val();
		if(gym_id.length < 5 
		 ||gym_id.length > 9)  {
			alert("5자리 이상, 9자 이하의 아이디를 작성해주세요");
			return;
		}
		var result = check(gym_id);
		if(result) { 
			alert("영어 대,소문자, 숫자만 입력 가능 합니다.");
			return; 
		}
		$.ajax({
			method:'post'
			,enctype: 'multipart/form-data'
			,contentType : false
			,data: 'gym_id='+gym_id
			,url: './gym/jsonIdConfirm.gym'
			,success: function(data) {
				id_check = data.trim();
				//alert("data : "+id_check);
				if(id_check == 1) {
					alert("중복된 아이디 입니다.");
				} else if(id_check == 0) {
					$('#j_gym_id_ok').val(gym_id);
					alert("사용가능한 아이디 입니다.");
				}
			}
		});
	}
	function pw_confirm() {
		//alert("비번확인");
		var gym_pw = $('#j_gym_pw').val();
		var gym_pw_2 = $('#j_gym_pw_2').val();
		if( gym_pw.length>8 && gym_pw.length <= gym_pw_2.length) {
			if(gym_pw == gym_pw_2) {
				//alert("확인되었습니다");
				$('#pw_icon').html('<i class="material-icons" style="font-size:36px;color:green">done</i>');
				pw_check = 0;
			} else {
				//alert("비밀번호가 다릅니다.");
				$('#pw_icon').html('<i class="material-icons" style="font-size:36px;color:red">clear</i>');
				pw_check = 1;
			}
		} else {
			$('#pw_icon').html('<i class="material-icons" style="font-size:36px;color:red">clear</i>');
			pw_check = 1;
		}
	}
	// 48~57 : 0~9 
	// 65~90 : 영어 대문자
	// 97~122 : 영어 소문자
	function check(str) {
		//alert("str :"+str);
		var check = 0;
		for(i=0; i<str.length; i++) {
			var code = str.charCodeAt(i)
			//alert("code :"+code);result
			if( 47<code&&code<58 
			  ||64<code&&code<91
			  ||96<code&&code<123) {
				//영어 대,소분자, 숫자
				check = 0;
			} else {
				//사용불가 문자 
				check = 1;
			}
		}
		return check;
	}
</script>
</head>
<body style="height:auto;">
<!-- ===================== 로고 부분 ===================== -->
<div class="jumbotron text-center" 
     style="padding-top:0; padding-bottom: 0; margin-bottom:0; height: 120px;">
  <img alt="" src="../images/logo.png" style="width:230px; height:120px; padding:0; margin:0;"/>
</div>

<!-- ===================== 카로우즐 부분 ===================== -->
<div class="jumbotron text-center" style="padding-top:0; padding-bottom: 0; margin-bottom:0; height: 100%;">
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
				<img src="../images/health.jpg" alt="Health" 
				     style="width:100%;height:100%;max-width:1200px; max-height:400px">
			</div>
			<div class="carousel-item">
				<img src="../images/yoga.jpg" alt="Yoga" 
				     style="width:100%;height:100%;max-width:1200px; max-height:400px">
			</div>
			<div class="carousel-item">
				<img src="../images/spinning.jpg" alt="Spinning" 
				     style="width:100%;height:100%;max-width:1200px; max-height:400px">
			</div>
			<div class="carousel-item">
				<img src="../images/pilates.jpg" alt="Pilates" 
				     style="width:100%;height:100%;max-width:1200px; max-height:400px">
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
<!-- ===================== 로그인 부분 ===================== -->
<div class="jumbotron text" style="padding-top:0; padding-bottom: 0; margin-bottom:0; height: auto; min-height:420px">
	<div class="row" style="padding-top:50px;">
	    <div class="col-sm-2"></div>
	    <div class="col-sm-5">
	    	<h1>대충 환영한다는 문구</h1>
	    </div>
	    <div class="col-sm-3">
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
			<div class="row">
				<div class="col-sm-6" style="padding-top:5px">
					<button type="button" class="btn btn-secondary"
							data-toggle="modal" data-target="#m_join" style="width:100%">회원가입</button>
				</div>
				<div class="col-sm-6" style="padding-top:5px">
					<button onclick="login()" class="btn btn-secondary" 
					        style="width:100%; padding-left:10px">로그인</button>
				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
  	</div>
</div>

<!-- ===================== 회원가입 모달 부분  ===================== -->
	<%@ include file="./join.jsp" %>
	<%-- <%@ include file="./gymAddr.jsp" %> --%>

</body>
</html>
			
