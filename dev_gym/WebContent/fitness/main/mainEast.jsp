<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-sm-2" style="padding: 10px">

	<div class="row" align="center">
		<div class="col-sm-12">
			<a href="javascript:picks('home')">
	  			<img alt="" src="../../images/logo.png" style="width:100%; height:100%; padding:0; margin:0;"/>
	  		</a>
		</div>
	</div>
	<hr>
	<div class="row" align="center" style="text-align: center;">
		<div class="col-sm-12">
			<b><%= gym_name %> 매장</b>
		</div>
	</div>
	<hr>
	<div class="row" align="center" style="text-align: center;">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<button type="button" 
			        class="btn btn-secondary"
			        style="width: 100%"
			        onclick="logout('')">로그아웃</button>
		</div>
		<div class="col-sm-2"></div>
	</div>
</div>

<script type="text/javascript">
	function logout(id) {
		//alert("로그아웃 클릭");
		var data = id;
		$.ajax({
			data : 'gym_name='+id
			,url: './logout.jsp'
			,success: function(data) {
				alert(data.trim());
				location.reload();
			}
		});
	}
</script>


	