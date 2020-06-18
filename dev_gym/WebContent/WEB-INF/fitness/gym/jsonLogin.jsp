<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
	Map<String, Object> pMap = selResult.get(0);
	String gym_no = pMap.get("GYM_NO").toString();
	String gym_name = pMap.get("GYM_NAME").toString();
	out.print("gym_no : "+gym_no+", gym_name : "+ gym_name);
%>