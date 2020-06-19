<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String result = request.getParameter("result");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	var result = <%=result%>;
	var data = "";
	if(result == "1"){
		alert("삭제 완료하였습니다.");
		data = "?mode=refresh";
	}
	else{
		alert("삭제 실패하였습니다.");
	}
	location.href="./main/main.jsp"+data;
</script>
</body>
</html>