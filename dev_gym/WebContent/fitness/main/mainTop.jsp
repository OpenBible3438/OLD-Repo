<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- --> 
<div class="jumbotron text-center" style="padding-top:0; padding-bottom: 0;
                                          margin-bottom:0; height: 120px;">
  <img alt="" src="../../images/logo.png" style="width:230px; height:120px; padding:0; margin:0;"/>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<a class="navbar-brand" href="./main.jsp?center=info">HOME</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="collapsibleNavbar"
		 style="align-items: center;">
		<ul class="navbar-nav">
		<!-- 가이드 부분 -->
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown">가이드</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="javascript:picks('info')">소개</a> 
					<a class="dropdown-item" href="javascript:picks('')">성격</a> 
					<a class="dropdown-item" href="javascript:picks('')">기능</a> 
					<a class="dropdown-item" href="javascript:picks('join')">회원가입</a> 
				</div>
			</li>
		<!-- 매장관리 부분 -->
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown">매장관리</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="javascript:picks('gym')">매장정보</a> 
					<a class="dropdown-item" href="javascript:picks('chart')">차트</a> 
					<a class="dropdown-item" href="javascript:picks('content')">컨텐츠관리</a> 
					<a class="dropdown-item" href="javascript:picks('review')">매장후기</a> 
					<a class="dropdown-item" href="javascript:picks('notice')">공지사항</a> 
				</div>
			</li>
		<!-- 강사관리 부분 -->	
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown">강사관리</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="javascript:picks('tch')">전체강사관리</a> 
				</div>
			</li>
		<!-- 회원관리 부분 -->
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown">회원관리</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="javascript:picks('mem')">전체회원관리</a> 
					<a class="dropdown-item" href="javascript:picks('ibd')">인바디관리</a>
				</div>
			</li>
		<!-- 수업관리 부분 -->
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown">수업관리</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="javascript:picks('cls')">전체수업관리</a> 
				</div>
			</li>
		<!--  -->
		</ul>
	</div>

</nav>
