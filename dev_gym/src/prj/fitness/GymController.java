package prj.fitness;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.SetData;

public class GymController implements Controller {

	Logger logger = Logger.getLogger(GymController.class);
	Map<String, Object> pMap = null;
	GymLogic gLogic = null;
	SetData setData = null;
	String work = null;
	String reqName = null;
	String progress = null;
	int result = 0;
	List<Map<String, Object>> chartData = null; //차트 조회일 때 사용
	String data = null; // 차트 조회일 때 사용
	//String autoSel = "false";
	// jsp페이지가 열릴 때 자동으로 데이터가 select 되는 지를 구분하는 변수
	// autoSel = true이면 redirect로 원래 페이지로 돌아갈 때 select 처리를 해줄 필요가 없다.
	
	
	public GymController(Map<String, Object> pMap) {
		logger.info("GymController 생성자 호출");
		this.pMap = pMap;
		gLogic = new GymLogic();
		work = pMap.get("work").toString();
		reqName = pMap.get("reqName").toString();
		logger.info("work : " + work + ", reqName : " + reqName);
		setData = new SetData();
	}
	
	
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		logger.info("GymController - String 타입 process 호출");
		logger.info("cud : " + cud + ", reqName : " + reqName);
		String path = null;
		switch(cud) {
			case "join":{ //매장 회원 가입 
				try {
					result = gLogic.gymJoin(pMap);
				} catch (Exception e) {
					logger.info("Exception : "+e.toString());
					result = 0;
				}
				//autoSel="false";
				path = "redirect:../"+reqName+":"+result;
			}break;
			case "ins":{
				try {
					switch(reqName) {
						case "classIns":{ // 수업 등록
							result = gLogic.classIns(pMap);
						}break;
						case "classMemIns":{ // 수강생 등록
							result = gLogic.classMemIns(pMap);
						}break;
						case "contentIns":{ // 컨텐츠 등록
							result = gLogic.contentIns(pMap);
							//autoSel="true";
						}break;
						case "gymNoticeIns":{ // 공지사항 등록
							result = gLogic.gymNoticeIns(pMap);
							//autoSel="true";
						}break;
					}
				} catch (Exception e) {
					logger.info("Exception : "+e.toString());
					result = 0;
				}
				path = "redirect:../insertResult" + ":" + result;
			}break;
			case "upd":{
				try {
					switch(reqName) {
						case "classUpd":{ // 수업 수정
							result = gLogic.classUpd(pMap);
						}break;
						case "classMemUpd":{ // 수강생 수정
							result = gLogic.classMemUpd(pMap);
						}break;
						case "gymInfoUpd":{ // 정보 수정
							result = gLogic.gymInfoUpd(pMap);
							//autoSel = "true";
						}break;
						case "contentUpd":{ // 컨텐츠 수정
							result = gLogic.contentUpd(pMap);
							//autoSel = "true";
						}break;
						case "gymNoticeUpd":{ // 공지사항 수정
							result = gLogic.gymNoticeUpd(pMap);
							//autoSel = "true";
						}break;
					}
				} catch (Exception e) {
					logger.info("Exception : "+e.toString());
					result = 0;
				}
				path = "redirect:../updateResult:"+result;
			}break;
			case "del":{
				try {
					switch(reqName) {
						case "classDel":{ // 수업 삭제
							result = gLogic.classDel(pMap);
						}break;
						case "classMemDel":{ // 수강생 삭제
							result = gLogic.classMemDel(pMap);
						}break;
						case "contentDel":{ // 컨텐츠 삭제
							result = gLogic.contentDel(pMap);
							//autoSel = "true";
						}break;
						case "gymNoticeDel":{ // 공지사항 삭제
							result = gLogic.gymNoticeDel(pMap);
							//autoSel = "true";
						}break;
					}
				} catch (Exception e) {
					logger.info("Exception : "+e.toString());
					result = 0;
				}
				path = "redirect:../deleteResult:"+result;
			}break;
		}
		logger.info("path : " + path);
		return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		logger.info("GymController - mav 타입 process 호출");
		//classList 조건 검색
		String progress = req.getParameter("progress");
		logger.info("progress : " + progress);
		ModelAndView mav = new ModelAndView(req, res);
		Object selResult = null;
		try {
			switch(reqName){
				case "jsonLogin":{     //회원 로그인 
					selResult = gLogic.getLogin(pMap);
				} break; 
				case "jsonIdConfirm":{ //회원 아이디 중복확인  
					selResult = gLogic.getIdConfirm(pMap);
				} break;
				case "gymProfImage":{ // 이미지 가져오기 
					selResult = gLogic.gymProfImage(pMap);
				} break;
				case "gymContImage":{ // 콘텐트 이미지 가져오기 
					selResult = gLogic.gymContImage(pMap);
				} break;
				case "getImages":{ // 이미지 한장 가져오기 
					selResult = gLogic.getImages(pMap);
				} break;
				case "jsonClassMemList":{ // 수강생 조회
					selResult = gLogic.getClassMemList(pMap);
				} break;
				case "jsonClassDetail":{ // 수업 자세히 보기
					selResult = gLogic.getClassDetail(pMap);
				}break;
				case "jsonClassList":{ // 수업 목록 조회
					selResult = gLogic.getClassList(pMap);
				}break;
				case "jsonTypeList":{
					selResult = gLogic.getTypeNo(pMap);
				}break;
				case "jsonComboList":{
					selResult = gLogic.getComboList(pMap);
				}break;
				case "jsonPayMemList":{
					selResult = gLogic.getPayMemList(pMap);
				}break;
				case "jsonGymNoticeList":{ // 공지사항 조회
					selResult = gLogic.getNoticeList(pMap);
				}break;
				case "chart_accum_members":{ // 누적 회원수 조회
					chartData = gLogic.get_c_accum_members(pMap);
					data = setData.dataToJson(chartData, "MONTH");
					selResult = data;
				}break;
				case "chart_ex_time_avg":{ // 회원 평균 운동시간 조회
					chartData = gLogic.get_c_ex_time_avg(pMap);
					data = setData.dataToJson(chartData, "RNG");
					selResult = data;
				}break;
				case "chart_cnt_mem_extime":{ // 시간대별 방문자수 평균 조회
					chartData = gLogic.get_cnt_mem_extime(pMap);
					data = setData.dataToJson(chartData, "TIME");
					selResult = data;
				}break;
				case "chart_get_newmem":{ // 시간대별 방문자수 평균 조회
					chartData = gLogic.get_newmem(pMap);
					data = setData.dataToJson(chartData, "DATE_YM");
					selResult = data;
				}break;
				case "chart_tch_sales":{ // 강사별 월별 매출
					chartData = gLogic.get_tchChart(pMap);
					data = setData.switchCol(chartData, "TCH_NAME");
					logger.info("*** data : " + data);
					selResult = data;
				}break;
				case "chart_gym_sales":{ // 매장 월별 매출
					chartData = gLogic.get_gym_sale(pMap);
					data = setData.dataToJson(chartData, "MONTH");
					selResult = data;
				}break;
				case "jsonGymInfoList":{ // 매장 정보 조회
					selResult = gLogic.getInfoList(pMap);
				}break;
				case "jsonGymReviewList":{ // 후기 조회
					selResult = gLogic.getReviewList(pMap);
				}break;
				case "jsonGymContentList":{ // 컨텐츠 조회
					selResult = gLogic.getContentList(pMap);
				}break;
				/**/
				case "jsonGymContentList2":{ 
					//편성경 추가
					selResult = gLogic.getContentList(pMap);
				}break;
			}
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		if(selResult != null) {
			logger.info("selResult != null");
			mav.addObject("selResult", selResult);
			if(reqName.contains("chart")) {//차트일 경우 도착지 통일함
				mav.setViewName("gym/chartResult");
			}
			else{
				//너가 selResult를 가지고 어디로 갈거니?
				mav.setViewName(work+"/"+reqName);
			}
		}
		else {
			selResult = new ArrayList<>();
			mav.addObject("selResult", selResult);
			mav.setViewName(work+"/"+reqName);
			logger.info("selResult == null");
			//logger.info("GymController - selResult가 Null입니다.");
		}
		return mav;
	}

}
