<%@page import="java.util.Set"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> dataList = (List<Map<String, Object>>)request.getAttribute("dataList");
	if(dataList != null){
		
	
	Gson g = new Gson();
	
	Map<String, Object> data = new HashMap<>();//전체 데이터를 담을 map
	
	Map<String, Object> col0 = new HashMap<>();//x축
	Map<String, Object> col1 = new HashMap<>();//첫 번째 컬럼
	Map<String, Object> col2 = new HashMap<>();//두 번째 컬럼
	Map<String, Object> col3 = new HashMap<>();//세 번째 컬럼
	List<Map<String, Object>> cols = new ArrayList<>();//컬럼 합치기
	
	col0.put("type", "string");
	col0.put("label", "day");

	col1.put("type", "number");
	col1.put("label", "first");
	//첫 번째 컬럼 설정
	
	col2.put("type", "number");
	col2.put("label", "second");
	//두 번째 컬럼 설정
	
	col3.put("type", "number");
	col3.put("label", "third");
	//세 번째 컬럼 설정
	
	cols.add(col0);
	cols.add(col1);
	cols.add(col2);
	cols.add(col3);
	//컬럼 합치기
	
	data.put("cols", cols);
	//전체 데이터에 컬럼 넣기
	
	Map<String, Object> data_col0 = null;
	Map<String, Object> data_col1 = null;
	Map<String, Object> data_col2 = null;
	Map<String, Object> data_col3 = null;
	
	Map<String, Object> now_data = null;
	List<Map<String, Object>> oneRow_data = null;
	Map<String, Object> oneRow = null;
	List<Map<String, Object>> rows = new ArrayList<>();
	
/* 	Set<String> keys_set = dataList.get(0).keySet();
	String[] keys = new String[keys_set.size()];
	int cnt = 0;
	for(String key : keys_set){
		keys[cnt++] = key;
	} */
	//키 값 자동으로 뽑아주려 했는데 어차피 직접 넣어줘야 할 듯...
	
	for(int i=0; i<dataList.size(); i++){
		
		now_data = dataList.get(i);
		
		data_col0 = new HashMap<>();
		data_col1 = new HashMap<>();
		data_col2 = new HashMap<>();
		data_col3 = new HashMap<>();
		oneRow_data = new ArrayList<>();
		oneRow = new HashMap<>();
		
		data_col0.put("v", (i+1)+"월");
		data_col1.put("v", now_data.get("FIRST"));
		data_col2.put("v", now_data.get("SECOND"));
		data_col3.put("v", now_data.get("THIRD"));
		
		oneRow_data.add(data_col0);
		oneRow_data.add(data_col1);
		oneRow_data.add(data_col2);
		oneRow_data.add(data_col3);
		
		oneRow.put("c", oneRow_data);
		
		rows.add(oneRow);
	}
	data.put("rows", rows);
	
	String result = g.toJson(data);
	out.print(result);
	}
	else{
		out.print("null");
	}
	

%>