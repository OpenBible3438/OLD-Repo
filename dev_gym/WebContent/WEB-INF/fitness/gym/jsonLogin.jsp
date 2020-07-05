<%@page import="com.google.gson.Gson"%>
<%@page import="oracle.sql.BLOB"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
	Map<String, Object> pMap = selResult.get(0);
	byte[] image = null;
	// 로그인 실패
	if(pMap.containsKey("confirm")) {
		String confirm = pMap.get("confirm").toString();
		if("아이디".equals(confirm)) {
			pMap.put("confirm", "아이디가 존재하지 않습니다.");
			//out.print("confirm/아이디가 존재하지 않습니다.");
		} else if("비밀번호".equals(confirm)){
			pMap.put("confirm", "비밀번호가 틀립니다.");
			//out.print("confirm/비밀번호가 틀립니다.");
		}
	// 로그인 성공
	} else {
		BLOB blob = (BLOB)pMap.get("filedata");
		image = blob.getBytes(1, (int)blob.length());
		pMap.put("filedata", image);
		//request.setAttribute("profImg", image);
		
		String gym_no = pMap.get("GYM_NO").toString();
		String gym_name = pMap.get("GYM_NAME").toString();
		pMap.remove("GYM_NO");
		pMap.remove("GYM_NAME");
		
		//매장 정보 세션 저장 
		HttpSession ses = request.getSession();
		ses.setAttribute("gym_no",gym_no);
		ses.setAttribute("gym_name",gym_name);
		ses.setMaxInactiveInterval(10*60); //10분
		//out.print("login/로그인 성공");
		pMap.put("confirm", "login");
	}
	Gson g = new Gson();
	String imsi = g.toJson(selResult);
	out.print(imsi);
%>