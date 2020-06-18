<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
img.img{
	position:webkit-stick;
	position:sticky;
	top:0;
	width: auto;
	height: auto;
}
</style>
</head>
<body>
    <!-- <h2>인바디 등록</h2> -->
    <table border="2" width=auto bordercolor="black" cellspacing="3"
        bordercolor="black">
            <tr>
                <td>회원번호 :</td>
                <td><input type="text" name="memNo"></td>
            </tr>
            <tr>
                <td>회원이름 :</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>회원아이디 :</td>
                <td><input type="text" name="ID"></td>
            </tr>
            <div>
            	<img class="picture.jpg">
            	<td>인바디 등록 사진 :</td>
            </div>
			<!--  <tr>
            	<td><input type="button" value="등록"></td>
                <td>인바디 등록 사진 :</td>
                <td><input type="image" name="picture">
                	<input type="submit" value="입력">
                </td>
            </tr>  -->
			<tr>
                <td align="center" colspan=2><input type="submit" value="입력">
                    <input type="reset" value="취소"></td>
            </tr>
    </table>
</body>
</html>