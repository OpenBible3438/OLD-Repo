package prj.fitness;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GymController implements Controller {

	Logger logger = Logger.getLogger(GymController.class);
	GymLogic gLogic = null;
	Map<String, Object> pMap = null;
	String reqName = null;
	String work = null;
	int result = 0;
	
	public GymController(Map<String, Object> pMap) {
		logger.info("GymController 생성자 호출");
		this.pMap = pMap;
		gLogic = new GymLogic();
		reqName = pMap.get("reqName").toString();
		work = pMap.get("work").toString();
	}
	
	
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String path = null;
		switch(reqName) {
		case "classList":{
			switch(cud) {
				case "ins":{
					result = gLogic.classIns(pMap);
				}break;
				case "upd":{
					result = gLogic.classUpd(pMap);
				}break;
				case "del":{
					result = gLogic.classDel(pMap);
				}break;
			}
		}break;
		
		case "classMemList":{
			switch(cud) {
			case "ins":{
				result = gLogic.classMemIns(pMap);
			}break;
			case "upd":{
				result = gLogic.classMemUpd(pMap);
			}break;
			case "del":{
				result = gLogic.classMemDel(pMap);
			}break;
			}
		}break;
		
		case "gymChart":{
			switch(cud) {
			case "ins":{
				result = gLogic.classMemIns(pMap);
			}break;
			case "upd":{
				result = gLogic.classMemUpd(pMap);
			}break;
			case "del":{
				result = gLogic.classMemDel(pMap);
			}break;
			}
		}break;
		
		case "gymContent":{
			switch(cud) {
			case "ins":{
				result = gLogic.contentIns(pMap);
			}break;
			case "upd":{
				result = gLogic.contentUpd(pMap);
			}break;
			case "del":{
				result = gLogic.contentDel(pMap);
			}break;
			}
		}break;
		
		case "gymNotice":{
			switch(cud) {
			case "ins":{
				result = gLogic.gymInfoUpd(pMap);
			}break;
			case "upd":{
				result = gLogic.gymNoticeIns(pMap);
			}break;
			case "del":{
				result = gLogic.gymNoticeUpd(pMap);
			}break;
			}
		}break;
	}
	
	path = "redirect:" + work + ":" + reqName + ":" + result;

	return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ModelAndView mav = new ModelAndView(req, res);
		String reqName = pMap.get("reqName").toString();
		Object selResult = null;
		switch(reqName){
			case "classDetail":{
				selResult = gLogic.getClassDetail(pMap);
			}break;
			case "classList":{
				selResult = gLogic.getClassList(pMap);
			}break;
			case "classMemList":{
				selResult = gLogic.getClassMemList(pMap);
			}break;
			case "gymChart":{
				selResult = gLogic.getGymChart(pMap);
			}break;
			case "gymContent":{
				selResult = gLogic.getGymContent(pMap);
			}break;
			case "gymMain":{
				selResult = gLogic.getGymMain(pMap);
			}break;
			case "gymNotice":{
				selResult = gLogic.getGymNotice(pMap);
			}break;
			case "gymReview":{
				selResult = gLogic.getGymReview(pMap);
			}break;
		}
		if(selResult != null) {
			mav.addObject("selResult", selResult);
		}
		else {
			logger.info("GymController - selResult가 Null입니다.");
		}
		
		return mav;
	}

}
