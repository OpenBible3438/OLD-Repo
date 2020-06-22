<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>    
<%@page import="com.google.gson.Gson"%>
<%
	List<Map<String, Object>> classList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(classList != null && classList.size() > 0){
		Gson g = new Gson();
		String notices = g.toJson(classList);
		out.print(classList);
	}
	else{
		out.print("null입니다.");
	}
%>    