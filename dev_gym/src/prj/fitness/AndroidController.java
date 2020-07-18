package prj.fitness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class AndroidController implements Controller{
	Logger logger = Logger.getLogger(AndroidController.class);
	Map<String, Object> pMap = null;
	AndroidLogic aLogic = null;
	String work = null;
	String reqName = null;
	int result = 0;

	public AndroidController(Map<String, Object> pMap) {
		logger.info("AndroidController 생성자 호출");
		this.pMap = pMap;
		aLogic = new AndroidLogic();
		work = pMap.get("work").toString();
		reqName = pMap.get("reqName").toString();
		logger.info("work : " + work + ", reqName : " + reqName);
	}

	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		logger.info("AndroidController - String 타입 process 호출");
		String path = null;
			switch(cud) {
				case "ins":{
					try {
						switch(reqName) {
						// 편성경
							case "memberJoin":{
								result = aLogic.memberJoin(pMap);
							}break;
						// 김혜림
							
						// 김승현
							
						// 박준규
							// 회원 리뷰 등록
							case "memReviewIns":{ 
								result = aLogic.memReviewIns(pMap);
							}break;
						// 김현빈
							
						// 허준호
							// 회원이 콘텐츠에 좋아요 눌렀을 때 
							case "contLikeINS":{
								result = aLogic.contLikeINS(pMap);
							}break;
						}
					} catch (Exception e) {
						logger.info("Exception : "+e.toString());
						result = 0;
					}
					path = "redirect:../insertResult_and" + ":" + result;
				}break;
				case "upd":{
					try {
						switch(reqName) {
						// 편성경
						
						// 김혜림
							
						// 김승현
							
						// 박준규
						// 김현빈
							
						// 허준호

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
						// 편성경
						
						// 김혜림
							
						// 김승현
							
						// 박준규
						
						// 김현빈
							
						// 허준호
							// 회원이 콘텐츠에 좋아요 뺐을 때 
							case "contLikeDEL":{
								result = aLogic.contLikeDEL(pMap);
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
		logger.info("AndroidController - mav 타입 process 호출");
		ModelAndView mav = new ModelAndView(req, res);
		Object selResult = null;
		try {
			switch(reqName) {
			// 편성경
				case "jsonMemberLogin":{
					selResult = aLogic.getMemberLogin(pMap);
					mav.type="json";
				}break;
				case "jsonTeacherLogin":{
					selResult = aLogic.getTeacherLogin(pMap);
					mav.type="json";
				}break;
				
				//매장 공지사항 조회
				case "jsonGymNoticeList":{
					selResult = aLogic.getGymNoticeList(pMap);
					mav.type = "json";
					logger.info("selResult : " + selResult);
				}break;
			// 김혜림
				//강사별 수업 목록 조회
				case "jsonTchClassList":{
					selResult = aLogic.getTchClassList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				//수업별 수강생 조회
				case "jsonClsMemList":{
					selResult = aLogic.getclsMemList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				//회원별 결제 목록 조회
				case "jsonMemPayList":{
					selResult = aLogic.getMemPayList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				case "jsonGymList":{
					selResult = aLogic.getGymList(pMap);
					mav.type = "json";
					logger.info("selResult : " + selResult);
				}break;
//				case "imageOne":{
//					selResult = aLogic.getImageOne(pMap);
//					logger.info("selResult : " + selResult);
//					mav.type = "json";
//				}break;
				case "jsonMemClsList":{
					selResult = aLogic.getMemWeekCls(pMap);
					logger.info("selResult : " + selResult);
					mav.type = "json";
				}break;
				case "jsonGymProfile":{
					selResult = aLogic.getGymProfile(pMap);
					logger.info("selResult : " + selResult);
					mav.type = "json";
				}break;
				case "myClassList":{//회원 - 수업정보
					selResult = aLogic.getMyClass(pMap);
					logger.info("selResult : " + selResult);
					mav.type = "json";
				}break;
				case "jsonTchList":{//매장 - 강사진
					selResult = aLogic.getTchList(pMap);
					logger.info("selResult : " + selResult);
					mav.type = "json";
				}break;
				case "jsonClsDtl":{//매장 - 수업 - 자세히보기
					selResult = aLogic.getClsDetail(pMap);
					logger.info("selResult : " + selResult);
					mav.type = "json";
				}break;
				case "jsonMemTchList":{//회원이 듣는 수업들의 강사 구하기(메시지에 사용)
					selResult = aLogic.getMemTchList(pMap);
					logger.info("selResult : " + selResult);
					mav.type = "json";
				}break;
				case "jsonTchChatMemList":{//강사의 전체 회원 리스트(메시지에 사용) 성경추가
					selResult = aLogic.getTchChatMemList(pMap);
					logger.info("selResult : " + selResult);
					mav.type = "json";
				}break;
				
			// 김승현
				
			// 박준규
				// 매장기준 콘텐츠 조회
				case "jsonGymContentsList":{
					selResult = aLogic.getGymContentsList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;				
			// 김현빈
				
			// 허준호
				// 회원 기준 후기 조회
				case "jsonMemReview":{
					selResult = aLogic.getMemReview(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 매장기준 강사 조회
				case "jsonGymTeacherList":{
					selResult = aLogic.getGymTeacherList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 매장기준 수업 조회
				case "jsonGymClassList":{
					selResult = aLogic.getGymClassList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 매장기준 후기 조회
				case "jsonGymReviewList":{
					selResult = aLogic.getGymReviewList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 강사> 수업/회원관리 > 수업리스트 > 수강생 보기> 인바디(그 회원에 대한) 
				case "jsonTchClsMemIbd":{
					selResult = aLogic.getTchClsMemIbd(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 전체 콘텐츠 가져오기  
				case "jsonContentsList":{
					selResult = aLogic.getContentsList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 강사 프로필 가져오기   
				case "jsonTeacherProf":{
					selResult = aLogic.getTeacherProf(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 회원 > 내정보 > 후기 리스트   
				case "jsonRevMemList":{
					selResult = aLogic.getRevMemList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 회원 > 내정보 > 후기 리스트 > 등록 수업리스트    
				case "jsonRevClsList":{
					selResult = aLogic.getRevClsList(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 강사 출석   
				case "jsonTeacherAttend":{
					selResult = aLogic.getTeacherAttend(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				// 회원 출석   
				case "jsonMemberAttend":{
					selResult = aLogic.getMemberAttend(pMap);
					mav.type="json";
					logger.info("selResult : " + selResult);
				}break;
				 // 이미지 한장 가져오기 
				case "getImg":{
					selResult = aLogic.getImg(pMap);
					logger.info("selResult :"+selResult.toString());
					mav.type = "img";
				} break;
				
			}
		} catch(Exception e) {
			logger.info("Exception : "+e.toString());
		}
		if(selResult != null) {
			logger.info("selResult != null");
		} else {
			logger.info("selResult == null");
			selResult = new ArrayList<>();
		}
		mav.addObject("selResult", selResult);
		mav.setViewName(work+"/"+reqName);
		return mav;
	}

}
