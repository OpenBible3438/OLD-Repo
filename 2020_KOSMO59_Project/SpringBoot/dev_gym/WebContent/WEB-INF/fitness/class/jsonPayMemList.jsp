<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>    
<%@page import="com.google.gson.Gson"%>
<%
	List<Map<String, Object>> payMemList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(payMemList != null && payMemList.size() > 0){
		Gson g = new Gson();
		String classes = g.toJson(payMemList);
		out.print(classes);
	}
	else {
		Map<String, Object> map = new HashMap<>();
		map.put("MEM_NO", 1);
		payMemList.add(map);
		Gson g = new Gson();
		String classes = g.toJson(payMemList);
		out.print(classes);
	}
%>    