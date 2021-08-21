<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	List<Map<String,Object>> selResult = (List<Map<String,Object>>)request.getAttribute("selResult");         
%>
<%
   //데이터 만들기 오라클에서 가져온 데이터 
   int monthStr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
   
   List<List<Integer>> listTotal2 = new ArrayList<List<Integer>>();
   for(int i=0; i<monthStr.length; i++) {
      List<Integer> month = new ArrayList<Integer>();
      month.add(0, monthStr[i]);
      listTotal2.add(i,month);
   }
   Map<String, Object> tchMap = new HashMap<>();
   for(int i=0; i<selResult.size(); i++) {
      Map<String, Object> bufMap = selResult.get(i);
      tchMap.put(""+i, bufMap.get("tch_name"));
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
   
   System.out.println("selResult : " + selResult);
   System.out.println("tchMap : " + tchMap);
   Gson g = new Gson();
   String imsi = g.toJson(listTotal2);
   System.out.println(selResult);
         
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
       data.addColumn('number', '월');
    <%      for(int i=0; i<tchMap.size(); i++) {
    		
    		System.out.print("******************");
    		System.out.print(tchMap.get(i+""));
    %>         data.addColumn('number', '<%= tchMap.get(i+"") %>');
             
    <%
          }
    %>
       data.addRows(<%=listTotal2.toString()%>);
       var options = {
    	        chart: {
    	          title: '강사별 월별 매출',
    	        },
    	        axes: {
    	          x: {
    	            0: {side: 'bottom'}
    	          }
    	        }
    	      };

      var chart = new google.charts.Line(document.getElementById('curve_chart'));

      chart.draw(data, google.charts.Line.convertOptions(options));
     }
    </script>
  </head>
  <body>
    <div id="curve_chart"></div>
  </body>
</html>