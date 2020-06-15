package prj.fitness;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class TchController implements Controller {

	Logger logger = Logger.getLogger(TchController.class);
	Map<String, Object> pMap = null;
	TchLogic tLogic = null;
	String work = null;
	String reqName = null;
	int result = 0;
	public TchController(Map<String, Object> pMap) {
		logger.info("TchController 생성자 호출");
		this.pMap = pMap;
		tLogic = new TchLogic();
		reqName = pMap.get("reqName").toString();
		work = pMap.get("work").toString();
	}
	
	
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String path = null;
		switch(reqName) {
			case "ins":{
				result = tLogic.tchIns(pMap);
			}break;
			case "upd":{
				result = tLogic.tchUpd(pMap);
			}break;
			case "del":{
				result = tLogic.tchDel(pMap);
			}break;
		}
		
		path = "redirect:" + work + ":" + reqName + ":" + result;

		return path;
	}

	
	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ModelAndView mav = new ModelAndView(req, res);
		Object selResult = null;
		switch(reqName){
			case "tchClass":{
				selResult = tLogic.getTchClassList(pMap);
			}break;
			case "tchList":{
				selResult = tLogic.getTchList(pMap);
			}break;
			case "tchProfile":{
				selResult = tLogic.getTchProfile(pMap);
			}break;
		}
		if(selResult != null) {
			mav.addObject("selResult", selResult);
		}
		else {
			logger.info("TchController - selResult가 Null입니다.");
		}
		
		
		return mav;
	}

}
