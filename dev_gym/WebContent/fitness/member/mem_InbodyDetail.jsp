<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- <style>
img.img{
	position:webkit-stick;
	position:sticky;
	top:0;
	width: auto;
	height: auto;
}
</style> -->






    <!-- <h2>인바디 보기</h2> -->
    <table id="inbody_detail" class="modal" border="2" width=350 bordercolor="black" cellspacing="3"
        bordercolor="black" tabindex="-1" role="dialog" aria-hidden="true">
         <div class="form-group row">
			<label for="gym_no" class="col-sm-3 col-form-label ">회원번호</label>
			<div class="col-sm-2">
				<input type="text" style="width:80px;" class="form-control" placeholder="Readonly" readonly
					   id="mem_no_d" >
			</div>
		</div>
		
		<div class="form-group row">
			<label for="gym_id" class="col-sm-3 col-form-label ">아이디</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="mem_id_d" >
			</div>
		</div>
		
		<div class="form-group row">
			<label for="gym_name" class="col-sm-3 col-form-label">회원이름</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" placeholder="Readonly input here…" readonly
					   id="mem_name_d" >
			</div>
		</div>
		<div class="row">
			<div class="col-sm-1" data-spy="scroll" ></div>
			<div>
				<img id="iP" class="col-sm-4" src="#" style="margin:20px; width:200px; height:350px">
				<img id="iP" class="col-sm-4" src="#" style="margin:40px; width:200px; height:350px">
			</div>
			<div>
				<img id="iP" class="col-sm-4" src="#" style="margin:20px; width:200px; height:350px">
				<img id="iP" class="col-sm-4" src="#" style="margin:40px; width:200px; height:350px">
			</div>
		</div>
		
		
		<!--  
		<div class="form-group row">
			<img id="inbodyPreview" class="col-sm-10" name="input_img" src="#" style="width:100px; height:200px">
			 <label for="gym_profimg" class="col-sm-3 col-form-label">파일첨부</label>
			<input type="file" id="inbodyInputImg" data-class-button="btn btn-default"
				data-class-Input="form-control" data-button-text="" data-icon-name="fa fa-upload"
				class="from-control" tabIndex="-1" style="position: absoulte; clip: rect(0px 0px 0px 0px):"
				accept=".gif, .jpg, .png" >
		-->
				<!-- <div class="bootstrap-filestyle input-group">
					<input type="text" id="userfile" class="form-control" name="userfile" disabled="">
					<span class="group-span-filestyle input-group-btn" tabindex="0">
						<label for="fileInput" class="btn btn-default">
							<span class="glyphicon fa fa-upload"></span>
						</label>
					</span>
				</div> -->
		</div>
			<!--  
			<tr>
            	<td><input type="button" value="등록"></td>
                <td>인바디 등록 사진 :</td>
                <td><input type="image" name="picture">
                	<input type="submit" value="입력">
                </td>
            </tr>  
            -->
			<tr>
                <td align="center" colspan=2><input type="submit" value="입력">
                    <input type="reset" value="취소"></td>
            </tr>
    </table>
