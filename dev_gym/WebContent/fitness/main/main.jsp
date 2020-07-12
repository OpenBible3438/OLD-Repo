<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 메뉴 바 쿠키 받아오기
	String center = "";
	Cookie cs[] = request.getCookies();
	if(cs != null && cs.length>0) {
		for(Cookie ck: cs) {
			if("center".equals(ck.getName())) {
				center = ck.getValue();
				break;
			}
		}
	}
%>
<%	// 로그인 세션 받아오기
	HttpSession ses = request.getSession();
	String gym_no = null;
	String gym_name = null;
	
	//시간 설정
	Date timeForm = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
	
	//SimpleDateFormat sformatter = new SimpleDateFormat("y 
	//String nnn = sformatter.format(timeForm);  
	
	long time = ses.getLastAccessedTime()-ses.getCreationTime();   // 접속한 시간
	long timeOver = ses.getMaxInactiveInterval()*1000;             // 자동 로그아웃 시간
	long timeOver2 = (ses.getMaxInactiveInterval()*1000)/2;        // 자동 로그아웃 시간의 절반
	long timer = timeOver - time;                                  // 남은시간 = 설정시간 - 접속시간 
	
	timeForm.setTime(timer);
	String timerStr = formatter.format(timeForm);
	
	if(ses.getAttribute("gym_no") != null) {
		gym_no = (String)ses.getAttribute("gym_no");
		gym_name = (String)ses.getAttribute("gym_name");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>메인페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="../../common/bootStrap4UI.jsp" %>
<%
	// 로그인이 됐을 때
	if(gym_name != null) {
%>
<!-- =============== main style =============== -->
<style>
	/* Remove the navbar's default margin-bottom and rounded borders */
	.navbar {
		margin-bottom: 0;
		border-radius: 0;
	}
	/* 왼쪽, 가운데, 위 높이 조정 */
	.row.content {
		height: auto;
		min-height: 750px;
	}
	
	/* 작은 화면에서 사이드 나비와 그리드의 높이를 '자동'으로 설정  */
	@media screen and (max-width: 767px) {
		.sidenav {
			height: auto;
			padding: 15px;
		}
		.row.content {
			height: auto;
		}
	}
	/* 이미지 자르기  */
	.cropping{
	  	width: 250px;
	  	height: 250px;
	  	overflow: hidden;
	  	margin-left: 20px;
	}
	.cropping img{
		wihth: 100%;
		height: 100%;
	  	padding: 0px;
	}
</style>
<!-- =============== main javascript =============== -->
<script type="text/javascript">
  	function picks(center) {
  		//alert("center : "+center);
  		$.ajax({
  			method: "get"
			,data: "center="+center 
			,url: "../util/setCookie.jsp"
			,success: function(data) {
				location.reload();
			}
  		}); 
  	}
</script>
</head>
<body > 
<script type="text/javascript">
	//DOM구성이 완료되면...
	$(document).ready(function() {
		//alert("center : <%= center %>");  
		//alert("gym_no : <%= gym_no %>");
		//alert("gym_name : <%= gym_name %>");
		//alert("time : <%= time %>");
		//alert("timeOver : <%= timeOver %>");
		//alert("timer : <%= timer %>");
		var time = <%= time %>;           // 접속 시간
		var timer = <%= timer %>;         // 남은 시간
		var timeOver = <%= timeOver %>;   // 설정 시간 
		var timeOver2 = <%= timeOver2 %>; // 설정 시간/2  
		if(time>(1000*60)) { // 접속시간 > 설정시간/2 보다 클 때
			if(timer>0) {    // 남은 시간이 0보다 클 때
				if(confirm("<%= timerStr %>초 뒤에 자동 로그아웃 됩니다.\n\n10분 연장 하시겠습니까?")) {
					logout('<%= gym_name %>');	
				}
			} else {
				if(confirm("로그아웃 됩니다.\n\n10분 연장 하시겠습니까?")) {
					logout('<%= gym_name %>');	
				} else {
					logout('');
				}
			}
		}
	}); 
</script>
<!-- ========================= TOP 자리 ========================= -->
   <%@ include file="./mainTop.jsp" %> 
<!-- ========================= CENTER 시작  =========================  -->
<div class="container-fluid text-center" >    
  	<div class="row content">
<!-- ========================= 왼쪽 자리 ========================= -->
    	<%@ include file="./mainWest.jsp" %>
<!-- ========================= 센터 자리 ========================= -->
		<div id="center" class="col-sm-8 text-left"> 
			<!-- 이쫏  -->
<% // 쿠키를 받아서 center부분을 정한다.
		switch(center) {
			case "attr"   : { %> <%@ include file="../info/attr.jsp" %>  <% 
					} break;
			case "func"   : { %> <%@ include file="../info/func.jsp" %>  <% 
			       } break;
			case "api"   : { %> <%@ include file="../info/api.jsp" %> <% 
					} break;
			case "gym"    : { %> <%@ include file="../gym/gymInfo.jsp" %>  <%
					} break;
			case "chart"  : { %> <%@ include file="../gym/gymChart.jsp" %> <%
					} break;
			case "review" : { %> <%@ include file="../gym/gymReviewList.jsp" %> <%
					} break;
			case "content": { %> <%@ include file="../gym/gymContentList.jsp" %> <%
					} break;
			case "notice" : { %> <%@ include file="../gym/gymNoticeList.jsp" %> <%
					} break;
			case "tch"    : { %> <%@ include file="../teacher/tchList.jsp" %>  <%
					} break;
			case "mem"    : { %> <%@ include file="../member/mem_List.jsp" %> <%
					} break;
			case "ibd"    : { %> <%@ include file="../member/mem_InbodyLIst.jsp" %> <%
					} break;
			case "cls"    : { %> <%@ include file="../class/classList.jsp" %> <%
					} break;
			default       : { %> <%@ include file="../gym/gymChart.jsp" %> <%
			        } break;
				
		}
%>
		</div>
<!-- ========================= 오른쪽 자리 ========================= -->
   		<%@ include file="./mainEast.jsp" %>
  	</div>
</div>
<!-- ========================= CENTER 끝  =========================  -->
<!-- ========================= Footer자리 ========================= -->
	<%@ include file="./mainFoot.jsp" %>
</body>
</html>
<%
	} //로그인이 안됐을 때
	else {
%>
		<script type="text/javascript">
			$(document).ready(function() {
				alert("로그인 후 이용해주세요");
				location.href = "../start.jsp";
			}); 
		</script>
<%
	}
%>






