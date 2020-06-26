<%@page import="com.util.StringToHex"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try {
		/* com.util.StringToHex.java에 함수 선언 */
		String str = request.getParameter("filedata");
		String hexString = StringToHex.stringToHexString(str);
 		byte[] imgData = StringToHex.hexStringToByteArray(hexString);
 		System.out.print(imgData.length);
/* 		out.clear();
		out = pageContext.pushBody();
		OutputStream o = response.getOutputStream();
		o.write(imgData);
		o.flush();
		o.close(); */
	} catch(Exception e) {
		out.print(e.toString());
	}
%>