<%@page import="java.util.Arrays"%>
<%@page import="java.net.URL"%>
<%@page import="java.sql.Blob"%>
<%@page import="oracle.sql.BLOB"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%
	byte[] image = null;
	try {
		List<Map<String, Object>> selResult = (List<Map<String, Object>>)request.getAttribute("selResult");
		for(int i=0; i<selResult.size(); i++) {
			Map<String, Object> rMap = selResult.get(i);
// 			out.print("filesize : "+rMap.get("filesize")+"<br>");
// 			out.print("filename : "+rMap.get("FILENAME")+"<br>");
// 			out.print("OracleBLOB : "+rMap.get("filedata")+"<br><br>");
			BLOB blob = (BLOB)rMap.get("filedata");
// 			out.print("blob : "+blob+"<br>");
			image = blob.getBytes(1, (int)blob.length());
			//out.print(Arrays.toString(image));
// 			out.print("image : "+rMap.get("filedata")+"<br>");
// 			out.print("image : "+image+"<br><br>");
// 			out.print("getBytes : "+blob.getBytes(1, (int)blob.length())+"<br><br>");
%>
<script type="text/javascript">
		try {
// 			const objectURL = window.URL.createObjectURL([blob], {type: 'image/png'});
// 			document.write("bytes : "+blob+", URL : "+objectURL);
			<%-- var binaryData = <%= Arrays.toString(image) %>; --%>
			var url = URL.createObjectURL(new Blob(<%=Arrays.toString(image)%>
			    										 ,{type:'image/png',endings: 'native'}));
			location.href=url;
			//document.write("url : "+url);
			//document.write(url);
		} catch (e) {
			document.write("Exception : "+e.toString());
		}
	</script>
<%

		}

// 		Gson g = new Gson();
// 		String imsi = g.toJson(selResult);
// 		out.print(imsi);
	} catch(Exception e) {
		out.print(e.toString());
	}

%>





