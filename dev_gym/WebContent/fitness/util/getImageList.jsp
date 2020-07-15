<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="image/png; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try {
		/* com.util.StringToHex.java에 함수 선언 */
 		byte[] imgData = request.getParameter("imgByte").getBytes();
 		//System.out.print(imgData.length);
 		out.clear();
		out = pageContext.pushBody();
		OutputStream o = response.getOutputStream();
		o.write(imgData);
		o.flush();
		o.close();/* */
	} catch(Exception e) {
		out.print(e.toString());
	}
%>