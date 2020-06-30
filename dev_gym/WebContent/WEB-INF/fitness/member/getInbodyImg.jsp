<%@page import="oracle.sql.BLOB"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> byteList = (List<Map<String, Object>>)request.getAttribute("selResult");
	byte[] image = null;
	String url = "";
	try{
		for(int i=0; i<byteList.size(); i++){
			Map<String, Object> rMap = byteList.get(i);
			BLOB blob = (BLOB)rMap.get("FILEDATA");
			image = blob.getBytes(1, (int)blob.length());
			rMap.put("FILEDATA", image);
		}
	}catch(Exception e){
		out.print(e.toString());
	}
	
	for(int i=0; i<byteList.size(); i++) {
		Map<String,Object> map = byteList.get(i);
%>

		<img src="../main/getImages.jsp?filedata=<%=map.get("FILEDATA") %>" >
			
<%
	}
%>