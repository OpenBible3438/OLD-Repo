<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int result = Integer.parseInt(request.getParameter("result").toString());
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
	if(result > 0){
		alert("삭제 완료하였습니다.");
	}
	else{
		alert("삭제 실패하였습니다.");
	}
	location.href="./main/main.jsp";
</script>
</body>
</html>