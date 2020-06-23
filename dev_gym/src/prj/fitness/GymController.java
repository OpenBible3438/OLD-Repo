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
						autoSel="true";
					}break;
					case "jsonGymContentList":{
						result = gLogic.contentIns(pMap);
						autoSel="true";
					}break;
					case "jsonGymNoticeList":{
						result = gLogic.gymNoticeIns(pMap);
						autoSel="true";
					}break;
				}
				path = "redirect:../insertResult" + ":" + result + ":"+ autoSel;
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
				path = "redirect:../updateResult:"+result + ":"+ autoSel;
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
				path = "redirect:../deleteResult:"+result + ":"+ autoSel;
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
			case "jsonIdConfirm":{
				selResult = gLogic.getIdConfirm(pMap);
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
