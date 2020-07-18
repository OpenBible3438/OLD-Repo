package com.kosmo59.yoginaegym.common;

import android.app.Application;

public class AppVO extends Application {
    public int getGym_no() {
        return gym_no;
    }

    /* 조회할 매장 정보 저장하기*/
    public int gym_no = 0;//매장 메인 창으로 이동할 때 저장시키기

    public void setGym_no(int gym_no) {
        this.gym_no = gym_no;
    }

    /* 강사에서 회원정보 볼 때 cls_no 저장하기 */
    public int cls_no = 0;
    public int getCls_no() {
        return cls_no;
    }
    public void setCls_no(int cls_no) {
        this.cls_no = cls_no;
    }

    /* 강사에서 수강생 볼 때 mem_no 저장하기 */
    public int tch_cho_mem_no = 0;
    public int getTch_cho_mem_no() {
        return tch_cho_mem_no;
    }
    public void setTch_cho_mem_no(int tch_cho_mem_no) {
        this.tch_cho_mem_no = tch_cho_mem_no;
    }

    /* 강사에서 수업 조회할 때 스피너 선택하면 gym_no 저장하기 */
    public int tch_cho_gym_no = 0;
    public int getTch_cho_gym_no() {
        return tch_cho_gym_no;
    }
    public void setTch_cho_gym_no(int tch_cho_gym_no) {
        this.tch_cho_gym_no = tch_cho_gym_no;
    }



    /* 회원 */
    public String memberName = null;
    public String memberId = null;

    public int mem_no = 0;

    public String memberNum = null; //로그인 창에서 입력한 비밀번호를 회원번호로 받기
    public String roomName1 = null;
    public String memberNickname = null;
    public String msgSendName = null; //메세지 발신자 정하기.
    public String msgSendId = null;

    public String getMsgSendId() {
        return msgSendId;
    }

    public int getMem_no() {
        return mem_no;
    }

    public void setMsgSendId(String msgSendId) {
        this.msgSendId = msgSendId;
    }

    public String getMsgSendName() {
        return msgSendName;
    }

    public void setMsgSendName(String msgSendName) {
        this.msgSendName = msgSendName;
    }


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
    public int tch_no = 0;
    public String tchNum = null; //로그인 창에서 입력한 비밀번호를 강사번호로 받기
    public String roomName2 = null;

    public String getTchNum() {
        return tchNum;
    }

    public void setTchNum(String tchNum) {
        this.tchNum = tchNum;
    }

    public void setTch_no(int tch_no) {
        this.tch_no = tch_no;
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
