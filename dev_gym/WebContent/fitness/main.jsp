<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String center = request.getParameter("center");
	String pick = null;
	if(center != null) {
		pick = center;
	} else {
		pick = "info";
	}
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>메인페이지</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@ include file="./../common/bootStrap4UI.jsp" %>
  <script type="text/javascript">
  	function picks(center) {
  		var pick = null;
  		switch(center) {
			case "info":    { pick = "./info/info.jsp?mode=info"; } break;
			case "join":    { pick = "./join.jsp"; } break;
			case "gym":     { pick = "./gym/gymInfo.jsp"; } break;
			case "chart":   { pick = "./gym/gymChart.jsp"; } break;
			case "review":  { pick = "./gym/gymReviewList.jsp"; } break;
			case "content": { pick = "./gym/gymContentList.jsp"; } break;
			case "notice":  { pick = "./gym/gymNoticeList.jsp"; } break;
			case "tch":     { pick = "./teacher/tchInfo.jsp"; } break;
			case "mem":     { pick = "./member/memInfo.jsp"; } break;
			case "ibd":     { pick = "./member/memInbodyList.jsp"; } break;
			case "cls":     { pick = "./class/classInfo.jsp"; } break;
			default :       { pick = "./info/info.jsp"; } break;
		}
  		$.ajax({
  			url:pick
  			,success: function(data) {
  				$('#center').html(data);
  			}
  		});
  	}
  	picks("<%=pick%>");
  </script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */  
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    /* 왼쪽, 가운데, 위 높이 조정 */
    .row.content {height: 650px}
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    /* 작은 화면에서 사이드 나비와 그리드의 높이를 '자동'으로 설정  */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;}
    }
  </style>
</head>
<body >
<!-- ========================= TOP 자리 ========================= -->
   <%@ include file="./mainTop.jsp" %>
<!-- ========================= CENTER 시작  =========================  -->
<div class="container-fluid text-center">    
  	<div class="row content">
  	
<!-- ========================= 왼쪽 자리 ========================= -->
    	<%@ include file="./mainWest.jsp" %>
    
<!-- ========================= 센터 자리 ========================= -->
	<div data-spy="scroll" data-target="#center">
		<div id="center" class="col-sm-8 text-left" > 
		
		
		
		</div>
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





