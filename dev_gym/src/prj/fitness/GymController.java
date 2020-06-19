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
	int result = 0;
	
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
//		switch(reqName) {
//			case "jsonClassList":{
//				switch(cud) {
//					case "ins":{
//						result = gLogic.classIns(pMap);
//					}break;
//					case "upd":{
//						result = gLogic.classUpd(pMap);
//					}break;
//					case "del":{
//						result = gLogic.classDel(pMap);
//					}break;
//				}
//			}break;
//			case "jsonClassMemList":{
//				switch(cud) {
//					case "ins":{
//						result = gLogic.classMemIns(pMap);
//					}break;
//					case "upd":{
//						result = gLogic.classMemUpd(pMap);
//					}break;
//					case "del":{
//						result = gLogic.classMemDel(pMap);
//					}break;
//				}
//			}break;
//			case "jsonGymInfoList":{
//				switch(cud) {
//				case "upd":{
//					result = gLogic.gymInfoUpd(pMap);
//				}break;
//				}
//			}break;
//			case "jsonGymChartList":{///////////chart는 좀 다르게 처리해야 하지 않을까...!!
//				switch(cud) {
//					case "ins":{
//						result = gLogic.chartIns(pMap);
//					}break;
//					case "upd":{
//						result = gLogic.chartUpd(pMap);
//					}break;
//					case "del":{
//						result = gLogic.chartDel(pMap);
//					}break;
//				}
//			}break;
//			case "jsonGymContentList":{
//				switch(cud) {
//					case "ins":{
//						result = gLogic.contentIns(pMap);
//					}break;
//					case "upd":{
//						result = gLogic.contentUpd(pMap);
//					}break;
//					case "del":{
//						result = gLogic.contentDel(pMap);
//					}break;
//				}
//			}break;
//			case "jsonGymNoticeList":{
//				switch(cud) {
//				case "ins":{
//					result = gLogic.gymNoticeIns(pMap);
//				}break;
//				case "upd":{
//					result = gLogic.gymNoticeUpd(pMap);
//				}break;
//				case "del":{
//					result = gLogic.gymNoticeDel(pMap);
//				}break;
//				}
//			}break;
//			
//			
//		}/////end of switch
		
		switch(cud) {
			case "join":{
				////////////////////////////////////////////////////
				////////////////////////////////////////////////////
				////////////////////////////////////////////////////
				path = "redirect:"+reqName+":"+result;
				
			}break;
			case "ins":{
				switch(reqName) {
					case "jsonClassList":{
						result = gLogic.classIns(pMap);
					}break;
					case "jsonClassMemList":{
						result = gLogic.classMemIns(pMap);
					}break;
					case "jsonGymChartList":{
						result = gLogic.chartIns(pMap);
					}break;
					case "jsonGymContentList":{
						result = gLogic.contentIns(pMap);
					}break;
					case "jsonGymNoticeList":{
						result = gLogic.gymNoticeIns(pMap);
					}break;
				}
				path = "redirect:../insertResult" + ":" + result;
			}break;
			case "upd":{
				switch(reqName) {
					case "jsonClassList":{
						result = gLogic.classUpd(pMap);
					}break;
					case "jsonClassMemList":{
						result = gLogic.classMemUpd(pMap);
					}break;
					case "jsonGymInfoList":{
						result = gLogic.gymInfoUpd(pMap);
					}break;
					case "jsonGymChartList":{
						result = gLogic.chartUpd(pMap);
					}break;
					case "jsonGymContentList":{
						result = gLogic.contentUpd(pMap);
					}break;
					case "jsonGymNoticeList":{
						result = gLogic.gymNoticeUpd(pMap);
					}break;
				}
				path = "redirect:../updateResult:"+result;
			}break;
			case "del":{
				switch(reqName) {
					case "jsonClassList":{
						result = gLogic.classDel(pMap);
					}break;
					case "jsonClassMemList":{
						result = gLogic.classMemDel(pMap);
					}break;
					case "jsonGymChartList":{
						result = gLogic.chartDel(pMap);
					}break;
					case "jsonGymContentList":{
						result = gLogic.contentDel(pMap);
					}break;
					case "jsonGymNoticeList":{
						result = gLogic.gymNoticeDel(pMap);
					}break;
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
		ModelAndView mav = new ModelAndView(req, res);
		Object selResult = null;
		switch(reqName){
			case "jsonLogin":{
				selResult = gLogic.getLogin(pMap);
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
		}
		if(selResult != null) {
			logger.info("selResult != null");
			mav.addObject("selResult", selResult);
			mav.setViewName(work+"/"+reqName);
		}
		else {
			logger.info("selResult == null");
			logger.info("GymController - selResult가 Null입니다.");
		}
		
		return mav;
	}

}
