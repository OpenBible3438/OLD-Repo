<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String center = request.getParameter("center");
	String pick = null;
	//center를 쿠키에 저장
	//다시 main.jsp로 이동하더라고 쿠키에 저장하면 마지막으로 보고있는 화면을 보여준다.
	if("home".equals(center)) {
		Cookie centerPick = new Cookie("center", "");
		centerPick.setPath("/dev_gym/fitness");
		centerPick.setMaxAge(0);
		response.addCookie(centerPick);
	} else {
		Cookie centerPick = new Cookie("center", center);
		centerPick.setPath("/dev_gym/fitness");
		centerPick.setMaxAge(-1);
		response.addCookie(centerPick);
		//String path= centerPick.getPath();
	}
	
%>