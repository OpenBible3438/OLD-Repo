<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
    <!-- <h2>자세히 보기</h2> -->
    <table border="2" width=350 bordercolor="black" cellspacing="3"
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
            <tr>
                <td>닉네임 :</td>
                <td><input type="text" name="nickName"></td>
            </tr>
            <tr>
                <td>사진 :</td>
                <td><input type="image" name="picture"></td>
            </tr>
            <tr>
                <td>성별 :</td>
                <td><input type="radio" name="gender" value="0" checked>남자
                    <input type="radio" name="gender" value="1">여자</td>
            </tr>
            <tr>
                <td>회원전화번호 :</td>
                <td><input type="text" name="telephone"></td>
            </tr>
            <tr>
                <td>주소 :</td>
                <td><input type="text" name="address">🔍</td>
            </tr>
            <tr>
                <td>상세주소 :</td>
                <td><input type="text" name="Detailaddress"></td>
            </tr>
            <tr>
                <td>목표체중 :</td>
                <td><input type="text" name="weight"></td>
            </tr>
            <tr>
                <td>수업이력 :</td>
                <td><input type="text" name="class"></td>
            </tr>
            <tr>
                <td align="center" colspan=2><input type="submit" value="입력">
                    <input type="reset" value="취소"></td>
    </table>
</body>
</html>