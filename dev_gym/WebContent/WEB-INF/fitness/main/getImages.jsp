<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try {
 		byte[] imgData = (byte[])request.getAttribute("selResult");
		out.clear();
		out = pageContext.pushBody();
		OutputStream o = response.getOutputStream();
		o.write(imgData);
		o.flush();
		o.close();
	} catch(Exception e) {
		out.print(e.toString());
	}
%>