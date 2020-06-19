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
		work = pMap.get("work").toString();
		reqName = pMap.get("reqName").toString();
		logger.info("work : " + work + ", reqName : " + reqName);
	}
	
	
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		logger.info("TchController - String 타입 process 호출");
		String path = null;
		
		switch(cud) {
			case "ins":{
				switch(reqName) {
					case("jsonTchList"):{
						result = tLogic.tchIns(pMap);
					}break;
				}
				path = "redirect:../insertResult:"+result;
			}break;
			case "upd":{
				switch(reqName) {
					case("jsonTchList"):{
						result = tLogic.tchIns(pMap);
					}break;
				}
				result = tLogic.tchUpd(pMap);
				path = "redirect:../updateResult:"+result;
			}break;
			case "del":{
				switch(reqName) {
					case("jsonTchList"):{
						result = tLogic.tchIns(pMap);
					}break;
				}
				result = tLogic.tchDel(pMap);
				path = "redirect:../deleteResult:"+result;
			}break;
		}
		logger.info("path : " + path);
		
		return path;
	}

	
	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ModelAndView mav = new ModelAndView(req, res);
		logger.info("TchController - mav 타입 process 호출");
		Object selResult = null;
		switch(reqName){
			case "jsonTchClass":{
				selResult = tLogic.getTchClassList(pMap);
			}break;
			case "jsonTchList":{
				selResult = tLogic.getTchList(pMap);
			}break;
			case "jsonTchProfile":{
				selResult = tLogic.getTchProfile(pMap);
			}break;
		}
		if(selResult != null) {
			logger.info("selResult != null");
			mav.addObject("selResult", selResult);
			mav.setViewName(work+"/"+reqName);
		}
		else {
			logger.info("selResult == null");
			logger.info("TchController - selResult가 Null입니다.");
		}
		
		return mav;
	}

}
