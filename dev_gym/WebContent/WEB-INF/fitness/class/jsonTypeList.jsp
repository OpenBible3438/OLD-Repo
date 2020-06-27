<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>    
<%@page import="com.google.gson.Gson"%>
<%
	List<Map<String, Object>> typeList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(typeList != null && typeList.size() > 0){
		Gson g = new Gson();
		String classes = g.toJson(typeList);
		out.print(classes);
	}
	else{
		out.print("null입니다.");
	}
%>    