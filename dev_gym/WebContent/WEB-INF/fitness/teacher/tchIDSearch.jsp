<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="oracle.sql.BLOB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	byte[] image = null;
	try {
		List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
		for(int i=0; i<selResult.size(); i++) {
			Map<String, Object> rMap = selResult.get(i);
			if(rMap.containsKey("FILEDATA")) {
				BLOB blob = (BLOB)rMap.get("FILEDATA");
				image = blob.getBytes(1, (int)blob.length());
				rMap.put("FILEDATA", image);
			}
		}
		Gson g = new Gson();
		String imsi = g.toJson(selResult);
		out.print(imsi);
	} catch(Exception e) {
		out.print(e.toString());
	}

%>