<%@page import="com.util.HashMapBinder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = Integer.parseInt(request.getParameter("result").toString());
	//out.print(result);
%>
<script type="text/javascript">
	if("<%=result%>"=="1") {
		alert("회원가입 완료");
	} else {
		alert("회원가입 실패");
	}
	location.href="./start.jsp";
</script>

