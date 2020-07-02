<%@page import="oracle.sql.BLOB"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>

<%
	try {
		List<Map<String, Object>> tchList = (List<Map<String, Object>>)request.getAttribute("selResult");
		for(int i=0; i<tchList.size(); i++) {
			Map<String, Object> rMap = tchList.get(i);
			rMap.put("RNO",i+1);
		}
		Gson g = new Gson();
		String imsi = g.toJson(tchList);
		//System.out.print(imsi);
		out.print(imsi);
	} catch(Exception e) {
		out.print(e.toString());
	}

%>