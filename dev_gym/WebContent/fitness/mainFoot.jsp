<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
</style>
<footer class="container-fluid text-center">
  <p>여기에서 mainWest.jsp를 include 
	location.href="./main.jsp?center=info";
여기에서 mainEast.jsp를 include 
여기에서 mainTop.jsp를 include 
여기에서 mainFoot.jsp를 include 
/////center
url : 
if(매장이름 != null) {
//메뉴 버튼을 누르는 경우
	if(center.equals("class")) {
		여기에서 classList.jsp를 include
	}
	else if(center.equals("teacher")) {
		여기에서 tchList.jsp를 include
	}
	else if(center.equals("member")) {
		여기에서 memList.jsp를 include
	}
	else if(center.equals("inbody")) {
		여기에서 memInbody.jsp를 include	/////////////////////////
	}
	else if(center.equals("review")) {
		여기에서 gymReview.jsp를 include
	}
	if(center.equals("chart")) {
		여기에서 gymChart.jsp를 include
	}
	else if(center.equals("content")) {
		여기에서 gymContent.jsp를 include
	}
	else if(center.equals("main")) {
		여기에서 gymMain.jsp를 include
	}
	else if(center.equals("notice")) {
		여기에서 gymNotice.jsp를 include
	}
else {
//./main.jsp?center=review
}

url패턴
/dev_fitness/fitness/gym/info.gym?cud=ins
	</p>
</footer>