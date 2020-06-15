<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String center = request.getParameter("center");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>메인페이지</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@ include file="./../common/bootStrap4UI.jsp" %>
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
<body>
<!-- ========================= TOP 자리 ========================= -->
   <%@ include file="./mainTop.jsp" %>
<!-- ========================= CENTER 시작  =========================  -->
<div class="container-fluid text-center">    
  <div class="row content">
<!-- ========================= 왼쪽 자리 ========================= -->
    <%@ include file="./mainWest.jsp" %>
<!-- ========================= 센터 자리 ========================= -->
<div class="col-sm-8 text-left"> 
<%	if("info".equals(center) || center == null) { %>
    	<%@ include file="./info/info.jsp" %>
    	
<%  } else if("gym".equals(center)) { %>
    	<%@ include file="./gym/gymInfo.jsp" %>
    	
<%  } else if("chart".equals(center)) { %>
    	<%@ include file="./gym/gymChart.jsp" %>
    	
<%  } else if("review".equals(center)) { %>
    	<%@ include file="./gym/gymReviewList.jsp" %>
    	
<%  } else if("content".equals(center)) { %>
    	<%@ include file="./gym/gymContentList.jsp" %>
    	
<%  } else if("notice".equals(center)) { %>
    	<%@ include file="./gym/gymNoticeList.jsp" %>
    	
<%  } else if("tch".equals(center)) { %>
    	<%@ include file="./teacher/tchInfo.jsp" %>
    	
<%  } else if("mem".equals(center)) { %>
    	<%@ include file="./member/memInfo.jsp" %>
    	
<%  } else if("ibd".equals(center)) { %>
    	<%@ include file="./member/memInbodyList.jsp" %>
    	
<%  } else if("cls".equals(center)) { %>
    	<%@ include file="./class/classInfo.jsp" %>
    	
<%	} %>
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





