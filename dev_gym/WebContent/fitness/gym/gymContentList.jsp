<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="gymContentIns.jsp" %>
<%@include file="gymContentUpd.jsp" %>
<script type="text/javascript">
	function btnIns(){
		//alert('등록버튼클릭');		
	}
	function contentDel(){
		//alert('삭제하기');
		location.href='../jsonGymContentList?cud=del';
	}
</script>
<div style="padding: 20px;">
<h3><b>매장관리</b> / 컨텐츠
<br>
	<button onClick="btnIns()" type="button" class="btn btn-primary" style="float:right;" data-toggle="modal" data-target="#contentInsModal">등록</button>
</h3>
<div style="padding-left: 40px; padding-top: 20px">
<!-- 컨텐츠 -->
	<!-- jsonGymContentList 로 이동 -->
	<div id="div_content"></div>
<!-- 컨텐츠 -->

<!-- 삭제버튼 눌렀을 때 모달부분 -->
<!-- 삭제 Modal -->
<div class="modal" id="contentDelModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <div class="modal-header">
	         	<h4 class="modal-title">삭제</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	        	해당 컨텐츠를 삭제하시겠습니까?
	        </div>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-danger" data-dismiss="modal" onClick="contentDel()">삭제하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>
<!-- 삭제 Modal -->
</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			 url:"../gym/jsonGymContentList.gym"
			,success:function(result){
				//alert(result);
				$("#div_content").html(result)
			}
		});
	});
</script>
