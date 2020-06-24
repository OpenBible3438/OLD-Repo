<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>

<%
	List<Map<String, Object>> tchList = (List<Map<String, Object>>)request.getAttribute("selResult");
	Gson g = new Gson();
	String imsi = g.toJson(tchList);
	out.print(imsi);
%>