<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//매장 정보 세션 저장 
	HttpSession ses = request.getSession();
	String gym_name = null;
	if(request.getParameter("gym_name") != null && request.getParameter("gym_name").length() > 0) {
		gym_name = request.getParameter("gym_name");
	}
	
	if(gym_name != null) {
		ses.setMaxInactiveInterval(ses.getMaxInactiveInterval()+(5*60)); //10분
		int time = ses.getMaxInactiveInterval()/60;
		out.print("5분 연장 되었습니다. \n설정시간 : "+time+"분");
	}
	else {
		ses.invalidate();
		out.print("로그아웃");
	}
%>