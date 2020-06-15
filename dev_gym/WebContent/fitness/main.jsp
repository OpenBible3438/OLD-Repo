<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String center = request.getParameter("center");
	String pick = null;
	
	 
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
  	picks('info');
  </script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */  
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body data-spy="scroll" >
<!-- ========================= TOP 자리 ========================= -->
   <%@ include file="./mainTop.jsp" %>
<!-- ========================= CENTER 시작  =========================  -->
<div class="container-fluid text-center">    
  	<div class="row content">
  	
<!-- ========================= 왼쪽 자리 ========================= -->
    <%@ include file="./mainWest.jsp" %>
    
<!-- ========================= 센터 자리 ========================= -->
		<div id="center" class="col-sm-8 text-left"> 
		
		
		
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





