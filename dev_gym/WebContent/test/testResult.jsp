<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JsonObject data = (JsonObject)request.getAttribute("data");
	
	JsonObject jo = new JsonObject();
	Gson g = new Gson();
/* 	JsonArray data = new JsonArray();
	jo.add("cols", dataList);9h 
//	String data = g.toJson(dataList); */
	out.print(data);
%>