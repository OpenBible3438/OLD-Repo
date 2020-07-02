<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>    
<%@page import="com.google.gson.Gson"%>
<%
	List<Map<String, Object>> classMemList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(classMemList != null && classMemList.size() > 0){
		Gson g = new Gson();
		String classes = g.toJson(classMemList);
		out.print(classes);
	}
	else{
		out.print("null입니다.");
	}
%>  