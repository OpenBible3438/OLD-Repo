<%@page import="java.sql.Blob"%>
<%@page import="oracle.sql.BLOB"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try {
		List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
		for(int i=0; i<selResult.size(); i++) {
			Map<String, Object> rMap = selResult.get(i);
// 			out.print(rMap.get("filesize")+"<br>");
// 			out.print(rMap.get("filename")+"<br>");
			Blob blob = (BLOB)rMap.get("filedata");
			byte[] image = blob.getBytes(1, (int)blob.length());
// 			out.print(image+"<br>");
			rMap.put("filedata",image);
%>
		<%-- <%rMap.put %> --%>

<%		
		}
		Gson g = new Gson();
		String imsi = g.toJson(selResult);
		out.print(imsi);
	} catch(Exception e) {
		out.print(e.toString());
	}
%>
