package prj.fitness;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GymController implements Controller {

	Logger logger = Logger.getLogger(GymController.class);
	Map<String, Object> pMap = null;
	GymLogic gLogic = null;
	String work = null;
	String reqName = null;
	String progress = null;
	int result = 0;
	String autoSel = "false";
	
	public GymController(Map<String, Object> pMap) {
		logger.info("GymController 생성자 호출");
		this.pMap = pMap;
		gLogic = new GymLogic();
		work = pMap.get("work").toString();
		reqName = pMap.get("reqName").toString();
		logger.info("work : " + work + ", reqName : " + reqName);
	}
	
	
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		logger.info("GymController - String 타입 process 호출");
		logger.info("cud : " + cud + ", reqName : " + reqName);
		String path = null;
		switch(cud) {
			case "join":{ //매장 회원 가입 
				result = gLogic.gymJoin(pMap);
				autoSel="false";
				path = "redirect:../"+reqName+":"+result+":"+autoSel;
			}break;
			case "ins":{
				switch(reqName) {
					case "classIns":{
						result = gLogic.classIns(pMap);
					}break;
					case "classMemIns":{
						result = gLogic.classMemIns(pMap);
					}break;
					case "chartIns":{
						result = gLogic.chartIns(pMap);
						autoSel="true";
					}break;
					case "contentIns":{
						result = gLogic.contentIns(pMap);
						autoSel="true";
					}break;
					case "gymNoticeIns":{
						result = gLogic.gymNoticeIns(pMap);
						autoSel="true";
					}break;
				}
				path = "redirect:../insertResult" + ":" + result + ":"+ autoSel;
			}break;
			case "upd":{
				switch(reqName) {
					case "classUpd":{
						result = gLogic.classUpd(pMap);
					}break;
					case "classMemUpd":{
						result = gLogic.classMemUpd(pMap);
					}break;
					case "gymInfoUpd":{
						result = gLogic.gymInfoUpd(pMap);
					}break;
					case "chartUpd":{
						result = gLogic.chartUpd(pMap);
					}break;
					case "contentUpd":{
						result = gLogic.contentUpd(pMap);
					}break;
					case "gymNoticeUpd":{
						result = gLogic.gymNoticeUpd(pMap);
					}break;
				}
				path = "redirect:../updateResult:"+result + ":"+ autoSel;
			}break;
			case "del":{
				switch(reqName) {
					case "classDel":{
						result = gLogic.classDel(pMap);
					}break;
					case "classMemDel":{
						result = gLogic.classMemDel(pMap);
					}break;
					case "chartDel":{
						result = gLogic.chartDel(pMap);
					}break;
					case "contentDel":{
						result = gLogic.contentDel(pMap);
					}break;
					case "gymNoticeDel":{
						result = gLogic.gymNoticeDel(pMap);
					}break;
				}
				path = "redirect:../deleteResult:"+result + ":"+ autoSel;
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
			case "jsonClassMemList":{
				selResult = gLogic.getClassMemList(pMap);
			} break;
			case "jsonClassDetail":{
				selResult = gLogic.getClassDetail(pMap);
			}break;
			case "jsonClassList":{
				selResult = gLogic.getClassList(pMap);
			}break;
			case "jsonTeacherNoList":{
				selResult = gLogic.getTchNo(pMap);
			}break;
			case "jsonGymNoticeList":{
				selResult = gLogic.getNoticeList(pMap);
			}break;
			case "jsonGymChartList":{
				selResult = gLogic.getChartList(pMap);
			}break;
			case "jsonGymContentList":{
				selResult = gLogic.getContentList(pMap);
			}break;
			case "jsonGymInfoList":{
				selResult = gLogic.getInfoList(pMap);
			}break;
			case "jsonGymReviewList":{
				selResult = gLogic.getReviewList(pMap);
			}break;
			case "jsonGymContentList2":{ 
				//편성경 추가
				selResult = gLogic.getContentList(pMap);
			}break;
		}
		if(selResult != null) {
			logger.info("selResult != null");
			mav.addObject("selResult", selResult);
			//너가 selResult를 가지고 어디로 갈거니?
			mav.setViewName(work+"/"+reqName);
		}
		else {
			logger.info("selResult == null");
			logger.info("GymController - selResult가 Null입니다.");
		}
		
		return mav;
	}

}
