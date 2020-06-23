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
		min-height: 600px;
	}
	
	/* On small screens, set height to 'auto' for sidenav and grid */
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
		//alert("center : <%=center%>"); 
		//alert("gym_no : <%=gym_no%>");
		//alert("gym_name : <%=gym_name%>");
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
			case "tch"    : { %> <%@ include file="../teacher/tchInfo.jsp" %>  <%
					} break;
			case "mem"    : { %> <%@ include file="../member/mem_List.jsp" %> <%
					} break;
			case "ibd"    : { %> <%@ include file="../member/mem_InbodyLIst.jsp" %> <%
					} break;
			case "cls"    : { %> <%@ include file="../class/classList.jsp" %> <%
					} break;
			default       : { %> <%@ include file="../info/attr.jsp" %> <%
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





