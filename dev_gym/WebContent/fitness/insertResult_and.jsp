<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = Integer.parseInt(request.getParameter("result").toString());
	out.print(result);
%>