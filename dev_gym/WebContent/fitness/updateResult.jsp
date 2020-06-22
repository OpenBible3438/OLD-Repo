<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int result = Integer.parseInt(request.getParameter("result").toString());
    	String autoSel = request.getParameter("autoSel").toString();
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
	var autoSel = <%=autoSel%>;
	var data = "";
	if(autoSel == "false"){
		data = "?mode=refresh";
	}
	if(result > 0){
		alert("수정 완료하였습니다.");
	}
	else{
		alert("수정 실패하였습니다.");
	}
	location.href="./main/main.jsp"+data;
</script>
</body>
</html>