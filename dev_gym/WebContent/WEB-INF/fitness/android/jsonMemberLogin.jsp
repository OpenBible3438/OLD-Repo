<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
	Map<String, Object> pMap = selResult.get(0);
	
	if(selResult != null){
		String mem_name = pMap.get("MEM_NAME").toString();
	}
	Gson g = new Gson();
	String imsi = g.toJson(selResult);
	out.print(imsi);
%>