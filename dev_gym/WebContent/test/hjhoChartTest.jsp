<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, Object> tch1 = new HashMap<String, Object>();
	tch1.put("강사이름", "개똥이");
	tch1.put("1월", 1000);
	tch1.put("2월", 2000);
	tch1.put("3월", 3000);
	tch1.put("4월", 4000);
	tch1.put("5월", 5000);
	tch1.put("6월", 4000);
	tch1.put("7월", 3000);
	tch1.put("8월", 2000);
	tch1.put("9월", 1000);
	tch1.put("10월", 2000);
	tch1.put("11월", 3000);
	tch1.put("12월", 4000);
	
	Map<String, Object> tch2 = new HashMap<String, Object>();
	tch2.put("강사이름", "소똥이");
	tch2.put("1월", 2000);
	tch2.put("2월", 3000);
	tch2.put("3월", 4000);
	tch2.put("4월", 5000);
	tch2.put("5월", 6000);
	tch2.put("6월", 7000);
	tch2.put("7월", 6000);
	tch2.put("8월", 4000);
	tch2.put("9월", 5000);
	tch2.put("10월", 8000);
	tch2.put("11월", 2000);
	tch2.put("12월", 1000);
	
	Map<String, Object> tch3 = new HashMap<String, Object>();
	tch3.put("강사이름", "소똥이");
	tch3.put("1월", 5000);
	tch3.put("2월", 8000);
	tch3.put("3월", 4000);
	tch3.put("4월", 6000);
	tch3.put("5월", 6000);
	tch3.put("6월", 7000);
	tch3.put("7월", 2000);
	tch3.put("8월", 9000);
	tch3.put("9월", 1000);
	tch3.put("10월", 5000);
	tch3.put("11월", 5000);
	tch3.put("12월", 3000);
	
	List<Map<String, Object>> listVer3 = new ArrayList<Map<String,Object>>();
	listVer3.add(0, tch1);
	listVer3.add(1, tch2);
	listVer3.add(2, tch3);
	//데이터 만들기 오라클에서 가져온 데이터 
	int monthStr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
	
	List<List<Integer>> listTotal2 = new ArrayList<List<Integer>>();
	for(int i=0; i<monthStr.length; i++) {
		List<Integer> month = new ArrayList<Integer>();
		month.add(0, monthStr[i]);
		listTotal2.add(i,month);
	}
	Map<String, Object> tchMap = new HashMap<>();
	for(int i=0; i<listVer3.size(); i++) {
		Map<String, Object> bufMap = listVer3.get(i);
		tchMap.put(""+i, bufMap.get("강사이름"));
		listTotal2.get(0).add(i+1, Integer.parseInt(bufMap.get("1월").toString()));
		listTotal2.get(1).add(i+1, Integer.parseInt(bufMap.get("2월").toString()));
		listTotal2.get(2).add(i+1, Integer.parseInt(bufMap.get("3월").toString()));
		listTotal2.get(3).add(i+1, Integer.parseInt(bufMap.get("4월").toString()));
		listTotal2.get(4).add(i+1, Integer.parseInt(bufMap.get("5월").toString()));
		listTotal2.get(5).add(i+1, Integer.parseInt(bufMap.get("6월").toString()));
		listTotal2.get(6).add(i+1, Integer.parseInt(bufMap.get("7월").toString()));
		listTotal2.get(7).add(i+1, Integer.parseInt(bufMap.get("8월").toString()));
		listTotal2.get(8).add(i+1, Integer.parseInt(bufMap.get("9월").toString()));
		listTotal2.get(9).add(i+1, Integer.parseInt(bufMap.get("10월").toString()));
		listTotal2.get(10).add(i+1, Integer.parseInt(bufMap.get("11월").toString()));
		listTotal2.get(11).add(i+1, Integer.parseInt(bufMap.get("12월").toString()));
	}
	System.out.println(listTotal2);
	Gson g = new Gson();
	String imsi = g.toJson(listTotal2);
	System.out.println(listTotal2);
			
%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
	    google.charts.load('current', {'packages':['line']});
	    google.charts.setOnLoadCallback(drawChart);
	
	  function drawChart() {
	
	    var data = new google.visualization.DataTable();
	    data.addColumn('number', 'Day');
    <%		for(int i=0; i<tchMap.size(); i++) {
    %>      	data.addColumn('number', '<%= tchMap.get(i+"") %>');
    			
    <%
		    }
    %>
	    data.addRows(<%=listTotal2.toString()%>);
	
	    var options = {
	      chart: {
	        title: 'Box Office Earnings in First Two Weeks of Opening',
	        subtitle: 'in millions of dollars (USD)'
	      },
	      width: 900,
	      height: 500
	    };
	
	    var chart = new google.charts.Line(document.getElementById('curve_chart'));
	
	    chart.draw(data, google.charts.Line.convertOptions(options));
	  }
    </script>
  </head>
  <body>
    <div id="curve_chart" style="width: 900px; height: 500px"></div>
  </body>
</html>