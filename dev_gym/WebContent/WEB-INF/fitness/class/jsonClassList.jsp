<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../../../common/jEasyUICommon.jsp" %>
조회 버튼 >> url : ./gym/jsonClassList.gym
<script type="text/javascript">
////////////테스트 코드)
	function showList(){
		$.ajax({
			url:'./jsonClassList.gym'	//req.getRequestURI = dev_fitness/fitness/gym/jsonClasList.gym?
		});
	}
	
</script>
</head>
<body>
<button onClick = "javascript:showList()">조회</button>
</body>
</html>