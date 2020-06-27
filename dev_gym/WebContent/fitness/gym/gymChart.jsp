<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
차트는 들어가자마자 바로 조회하기
누적회원수
콤보박스(일별, 월별, 연별)
방문자 , 방문시간, 월별 회원 수(신규 회원 포험), 매출
방문 시간 >> 콤보박스(일별, 월별, 연별)
누적회원수, 월별 회원수 등 (신규회원수를 포함하는 개념이다.)
  - 월별 매출 / 연 매출
  - 전체적인 출결 상황(이벤트로 이용 등...)
  - 일별 방문자 수, 요일별, 주별, 월별, 연별, ...
  - 강사별 매출
  - 시간대별 방문자 통계
  <script type="text/javascript">
  	누적 회원 수
  		- x축 : 월 
  		- 꺾은 선 / 막대
  		
  	회원 수
  		- x축 : 월, 연
  		- 꺾은 선 / 막대
  	
  		
  		
  	회원 평균 운동시간
  		- 기준 : 0~30분, 30~1시간, ... 
  		- 원형 그래프
  		
  	시간대별 방문자
  		- x축 : 09~10시, 10시~11시
  		- 꺾은 선 그래프
  	
  		
  		
  	매출
  		- 기준 : 월, 연
  		- 꺾은 선 / 막대
  		
  	강사별 매출
  		- 기준 : 월, 연
  		- 꺾은 선 / 막대
  		
  </script>
  <img alt="" src="./img/gym"/>
</body>
</html>
