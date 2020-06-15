<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://jonmiles.github.io/bootstrap-treeview/js/bootstrap-treeview.js"></script>   
<script src="https://jonmiles.github.io/bootstrap-treeview/bower_components/bootstrap/dist/css/bootstrap.css"></script>
<script type="text/javascript">
	function gymMove() {
		//location.href="./main.jsp?center=gym"
	}
</script>
<style>
/* Style the sidenav links and the dropdown button */
#west a, .dropdown-btn {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 15px;
  color: #f1f1f1;
  display: block;
  border: none;
  background: none;
  width: 100%;
  text-align: left;
  cursor: pointer;
  outline: none;
}
/* On mouse-over */
#west a:hover, #west .dropdown-btn:hover {
  color: #000000;
}
/* 클릭했을 때 뒷 배경색 */
#west .active {
  background-color: #0066CC;/* #0000FF */
  color: white;
}
#west .dropdown-container {
  display: none;
  background-color: #0066CC;
  padding-left: 8px;
}

/* Optional: Style the caret down icon */
#west .fa-caret-down {
  float: right;
  padding-right: 8px;
}
</style>   
<div id="west" class="col-sm-2" style="background-color: #0066CC;">
 	<button id="info" class="dropdown-btn"><b>가이드</b> 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="dropdown-container">
	    <a href="#">- 소개</a>
	    <a href="#">- 기능</a>
	    <a href="#">- 성격</a>
  	</div>
 	<button id="gym" class="dropdown-btn" onClick="gymMove()"><b>매장관리</b> 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="dropdown-container">
	    <a href="#">- 매장정보</a>
	    <a href="#">- 차트</a>
	    <a href="#">- 컨텐츠관리</a>
	    <a href="#">- 매장 후기</a>
	    <a href="#">- 공지사항</a>
  	</div>
 	<button id="tch" class="dropdown-btn"><b>강사관리</b> 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="dropdown-container">
	    <a href="#">- 전체강사</a>
  	</div>
 	<button id="mem" class="dropdown-btn"><b>회원관리</b> 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="dropdown-container">
	    <a href="#">- 전체회원</a>
	    <a href="#">- 회원인바디</a>
  	</div>
 	<button id="cls" class="dropdown-btn"><b>수업관리</b> 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="dropdown-container">
	    <a href="#">- 전체수업</a>
  	</div>
</div>
<script type="text/javascript">
/**/var dropdown = document.getElementsByClassName("dropdown-btn");
	for (var i = 0; i < dropdown.length; i++) {
		dropdown[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var dropdownContent = this.nextElementSibling;
			if (dropdownContent.style.display === "block") {
				dropdownContent.style.display = "none";
			} else {
				dropdownContent.style.display = "block";
			}
		});
	} 
</script>









