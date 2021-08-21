<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="gymContentIns.jsp" %>
<%@include file="gymContentUpd.jsp" %>
<div style="padding: 20px;">
<h3><b>매장관리</b> / 컨텐츠
<button type="button" class="btn btn-primary" style="float:right;" data-toggle="modal" data-target="#contentInsModal">등록</button> </h3>
<hr>
<div style="padding-left: 40px; padding-top: 20px">
<!-- 컨텐츠 -->
	<!-- jsonGymContentList 로 이동 -->
	<div id="div_content"> </div>
<!-- 컨텐츠 -->
</div>
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
	        <form id="f_del">
	        <input type="hidden" name="cud" value="del">
	        <div class="modal-body">
	        	<input id="contDel_seq" name="contDel_seq" style="width:60px" readonly>번 컨텐츠를 삭제하시겠습니까?
	        </div>
         	</form>
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

<script type="text/javascript">

	//파일 첨부시 이미지 로드 하기 
	function readURLins(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function(e) {
	        	//img태그 아이디
            	$('#contentPreviews').attr('src', e.target.result);
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	//파일첨부 input태그 아이디
	$("#contentInputImgs").change(function() {
		//alert("img_check : "+img_check);
	    readURLins(this);
	});
	//파일 첨부시 이미지 로드 하기 
    function readURLupd(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
            	//img태그 아이디
            	//alert("파일첨부1 : "+e.target.result);
                $('#contentUpdPreview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
	//파일첨부 input태그 아이디
    $("#contentUpdImg").change(function() {
        readURLupd(this);
    });
	function btnUpd(cont_seq){
		//alert(cont_seq+'번 수정버튼 클릭');
		$.ajax({
			 url:"../gym/jsonGymContentList2.gym?cont_seq="+cont_seq
			,success:function(result){
				//var imsi = JSON.stringify(result);
				var contList = JSON.parse(result.trim());
				var input = contList[0].GYM_CONTENTS;
				$("#contents_upd").text(input);
				$("#contUpd_seq").val(cont_seq);
			}
		});
	}
	function btnDel(cont_seq){
		//alert(cont_seq+'번 삭제버튼 클릭');
		$("#contDel_seq").val(cont_seq);
	}
	function contentDel(){
		//alert("삭제하기 버튼 클릭");
		$("#f_del").attr("method", "get");
		$("#f_del").attr("action", "../gym/contentDel.gym");
		$("#f_del").submit();
	}
	function contentIns(){
		//alert("컨텐츠 등록하기 버튼 클릭");
		var contentInputImg = $('#contentInputImgs').val();
		var cont_content = $('#cont_contents').val().trim();
		if(contentInputImg != "") {
			if(cont_content != "") {
				$("#f_ins").attr("action", "../gym/contentIns.gym");
				$("#f_ins").submit();
			} else {
				alert("내용을 입력해주세요");
			}
		}
		else {
			alert("이미지를 등록해주세요 ");
		}
	}
	$(document).ready(function(){
		$.ajax({
			 url:"../gym/jsonGymContentList.gym"
			,success:function(result){
				var datas = result.trim();
				$("#div_content").html(datas)
				var url = "";
				$.ajax({
					method: "post"
					,url: "../gym/gymContImage.gym"
					,success: function(result) {
						var data = JSON.stringify(result);
						var jsonDoc = JSON.parse(data);
						var imgTag = "";
						for(var i=0; i<jsonDoc.length; i++) {
							var binaryData = jsonDoc[i].filedata;
							var blob = new Blob([new Uint8Array(binaryData)],{type:'image/png'});
							url = URL.createObjectURL(blob);
							//alert("url : "+url);
							$("#img"+i+"").attr('src',url);
						}
					}
				});
				
			}
		});
	});
</script>
