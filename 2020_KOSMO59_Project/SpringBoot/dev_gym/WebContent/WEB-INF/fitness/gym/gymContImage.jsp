<%@page import="oracle.sql.BLOB"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	byte[] image = null;
	try {
		List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
		for(int i=0; i<selResult.size(); i++) {
			Map<String, Object> rMap = selResult.get(i);
			BLOB blob = (BLOB)rMap.get("filedata");
			image = blob.getBytes(1, (int)blob.length());
			rMap.put("filedata", image);
		}
		Gson g = new Gson();
		String imsi = g.toJson(selResult);
		out.print(imsi);
	} catch(Exception e) {
		out.print(e.toString());
	}

%>





