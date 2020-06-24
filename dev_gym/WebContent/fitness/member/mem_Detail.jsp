<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



    <!-- <h2>자세히 보기</h2> -->
    <table class="modal" border="2" width=350 bordercolor="black" cellspacing="3"
        bordercolor="black">
            <div class="form-group row">
			<label for="gym_no" class="col-sm-3 col-form-label ">회원번호</label>
			<div class="col-sm-2">
				<input type="text" style="width:80px;" class="form-control" placeholder="Readonly" readonly
					   id="mem_no" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_name" class="col-sm-3 col-form-label">회원이름</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="gym_name" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_id" class="col-sm-3 col-form-label ">아이디</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="gym_id" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_nickname" class="col-sm-3 col-form-label">닉네임 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="gym_nickname" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_profimg" class="col-sm-3 col-form-label">이미지</label>
			<div class="col-sm-5">
				<input type="file" class="custom-file-input" id="gym_profimg" placeholder="Readonly input here…" readonly>
				<label style="padding-left: 10px"class="custom-file-label" for="gym_profimg">회원 프로필 사진</label>
				</input>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_memtel" class="col-sm-3 col-form-label">전화번호 </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="gym_memtel" >
			</div>
		<div class="col-sm-3">
				<button onclick="addrSearch()" class="btn btn-primary mb-1" placeholder="Readonly input here…" readonly>주소검색</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_addr_dtl" class="col-sm-3 col-form-label" >상세주소</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="gym_addr_dtl" >
			</div>
			<div class="col-sm-3" >
				<input type="text" class="form-control" 
					   id="gym_zipcode" 
					   placeholder="우편번호">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_g_weight" class="col-sm-3 col-form-label">목표체중 </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="gym_g_weight" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_g_class" class="col-sm-3 col-form-label">수업이력 </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="gym_g_class" >
			</div>
		</div>
            <tr>
                <td align="center" colspan=2>
                <input type="submit" value="입력">
                <input type="reset" value="취소"></td>
            </tr>
    </table>
