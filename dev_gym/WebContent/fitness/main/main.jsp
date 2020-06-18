<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String center = null;
	Cookie cs[] = request.getCookies();
	if(cs != null && cs.length>0) {
		for(int i=0; i<cs.length; i++) {
			if("center".equals(cs[i].getName())) {
				center = cs[i].getValue();
				break;
			}
		}
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
  		alert("center : "+center);
  		$.ajax({
  			method: "get"
			,data: "center="+center 
			,url: "../util/setCookie.jsp"
			,success: function(data) {
				var pickURL = data.trim();
				$.ajax({
					url: pickURL
					,success: function(pickPage) {
						//alert("pickPage : "+pickPage);
						$('#center').html(pickPage);
					}
				});
			}
  		}); 
  	}
</script>
</head>
<body >
<script type="text/javascript">
	//DOM구성이 완료되면...
	$(document).ready(function() {
		picks('<%=center%>'); 
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





