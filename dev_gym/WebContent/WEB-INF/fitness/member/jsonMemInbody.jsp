<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%@ page import="com.google.gson.Gson" %> 
<%
	List<Map<String,Object>> memInbody = (List<Map<String,Object>>)request.getAttribute("selResult");
	Gson g = new Gson();
	String imsi = g.toJson(memInbody);
	out.print(imsi);
%>