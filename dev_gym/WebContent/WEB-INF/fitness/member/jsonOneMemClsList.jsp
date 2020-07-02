<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%@ page import="com.google.gson.Gson" %>    
<%
	List<Map<String,Object>> memList = (List<Map<String,Object>>)request.getAttribute("selResult");
	for(int i=0; i<memList.size(); i++) {
		memList.get(i).put("RNO", i+1);
	}
	Gson g = new Gson();
	String imsi = g.toJson(memList);
	out.print(imsi);
%>