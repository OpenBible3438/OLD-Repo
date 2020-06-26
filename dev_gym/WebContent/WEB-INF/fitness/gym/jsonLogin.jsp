<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
	Map<String, Object> pMap = selResult.get(0);
	// 로그인 실패
	if(pMap.containsKey("confirm")) {
		String confirm = pMap.get("confirm").toString();
		if("아이디".equals(confirm)) {
			out.print("confirm/아이디가 존재하지 않습니다.");
		} else if("비밀번호".equals(confirm)){
			out.print("confirm/비밀번호가 틀립니다.");
		}
	// 로그인 성공
	} else {
		String gym_no = pMap.get("GYM_NO").toString();
		String gym_name = pMap.get("GYM_NAME").toString();
		
		HttpSession ses = request.getSession();
		ses.setAttribute("gym_no",gym_no);
		ses.setAttribute("gym_name",gym_name);
		ses.setMaxInactiveInterval(10*60); //10분
		
		out.print("login/로그인 성공");
	}
%>