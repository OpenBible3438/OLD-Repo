<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="prj.fitness.ClassDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>

<%
/*
1.파라미터로 넘어온 값을 하나씩 꺼낸다. 
2.꺼낸 것을 다시 map에 포장한다.
3.그 map을 다오(택배)에게 전달한다.
4.다오(택배)는 그 map을 xml에게 파라미터로 넘겨준다.
*/

// 	//서버에 저장된 값 요청.
// 	//파라미터로 넘어온 값("ename1")으로 꺼낸 반환 값을 res에 담는다.
// 	//res(response의 약자) == 사용자가 입력한 값
// 	String res = request.getParameter("empno1");
	
// 	//0이면 모든 사원을 조회하라는 의미와 같다.
// 	//0이 아니면 조건 검색을 실행해야 한다.
// 	//0일 때와 0이 아닐 때를 구분할 수 있어야 한다.
// 	int intRes = 0;

// 	//사용자가 아무것도 입력하지 않았을 때 = 빈 문자열이 넘어갔을 때 = String 길이가 0일 때 = res.length()가 0인 상황
// 	//사용자가 empList()를 호출했을 때 = 사원조회 버튼을 눌렀을 때 = 파라미터로 넘어온 값이 없었을 때 = null인 상황
// 	//res.length()가 0이 아닐 때와 null이 아닐 때 그때 형변환을 해주고 싶다.
// 	if(res != null && res.length() != 0){
// 		intRes = Integer.parseInt(res);
// 	};
	
//	ClassDao cDao = new ClassDao();
//	List<Map<String,Object>> cList = cDao.classList();

	List<Map<String,Object>> cList = new ArrayList<>();

	Map<String,Object> cMap = new HashMap<>();
	cMap.put("C_NUM", 1);
	cMap.put("C_NUMBER", 11);
	cMap.put("C_NAME", "핫요가 오후7시반");
	cMap.put("C_TNAME", "장영실");
	cMap.put("C_SPORTS", "요가");
	cMap.put("C_TIMES", 20);
	cMap.put("C_TOTALDAYS", 90);
	cMap.put("C_STARTDATE", "2020-06-17");
	cMap.put("C_ENDDATE", "2020-09-16");
	cMap.put("C_PRICE", 200000);
	cMap.put("C_PROCESS", "진행");
	cList.add(cMap);
	
	cMap = new HashMap<>();
	cMap.put("C_NUM", 2);
	cMap.put("C_NUMBER", 12);
	cMap.put("C_NAME", "핫요가 오후7시반");
	cMap.put("C_TNAME", "장영실");
	cMap.put("C_SPORTS", "요가");
	cMap.put("C_TIMES", 20);
	cMap.put("C_TOTALDAYS", 90);
	cMap.put("C_STARTDATE", "2020-06-17");
	cMap.put("C_ENDDATE", "2020-09-16");
	cMap.put("C_PRICE", 200000);
	cMap.put("C_PROCESS", "진행");
	cList.add(cMap);
	
	Gson g = new Gson();
	String imsi = g.toJson(cList);
	out.print(imsi);	
%>