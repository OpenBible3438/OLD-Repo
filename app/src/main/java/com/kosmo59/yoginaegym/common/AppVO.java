package com.kosmo59.yoginaegym.common;

import android.app.Application;

public class AppVO extends Application {
    /* 조회할 매장 정보 저장하기*/
    public int gym_no = 0;//매장 메인 창으로 이동할 때 저장시키기

    /* 회원 */
    public String memberName = null;
    public String memberId = null;
    public int mem_no = 0;
    public String memberNum = null; //로그인 창에서 입력한 비밀번호를 회원번호로 받기
    public String roomName1 = null;
    public String memberNickname = null;


    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }


    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }
    public void setMem_no(int mem_no) {
        this.mem_no = mem_no;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRoomName1() {
        return roomName1;
    }

    public void setRoomName1(String roomName1) {
        this.roomName1 = roomName1;
    }

    /* 강사 */
    public String tchName = null;
    public String tchId = null;
    public String tchNum = null; //로그인 창에서 입력한 비밀번호를 강사번호로 받기
    public String roomName2 = null;

    public String getTchNum() {
        return tchNum;
    }

    public void setTchNum(String tchNum) {
        this.tchNum = tchNum;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId;
    }

    public String getRoomName2() {
        return roomName2;
    }

    public void setRoomName2(String roomName2) {
        this.roomName2 = roomName2;
    }
}
