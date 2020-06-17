<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ids = request.getParameter("ids");
	String pwd = request.getParameter("pwd");
	out.print("ids : "+ids+", pwd : "+ pwd);
%>