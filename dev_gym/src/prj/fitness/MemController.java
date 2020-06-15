package prj.fitness;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MemController implements Controller {

	Logger logger = Logger.getLogger(MemController.class);
	Map<String, Object> pMap = null;
	MemLogic mLogic = null;
	String work = null;
	String reqName = null; 
	int result = 0;
	public MemController(Map<String, Object> pMap) {
		logger.info("MemController 생성자 호출");
		this.pMap = pMap;
		mLogic = new MemLogic();
		reqName = pMap.get("reqName").toString();
		work = pMap.get("work").toString();
	}
	
	
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String path = null;
		
		switch(reqName) {
			case "memInbody":{
				switch(cud) {
					case "ins":{
						result = mLogic.memInbodyIns(pMap);
					}break;
					case "upd":{
						result = mLogic.memInbodyUpd(pMap);
					}break;
					case "del":{
						result = mLogic.memInbodyDel(pMap);
					}break;
				}
			}break;
			
			case "memList":{
				switch(cud) {
				case "ins":{
					result = mLogic.memIns(pMap);
				}break;
				case "upd":{
					result = mLogic.memUpd(pMap);
				}break;
				case "del":{
					result = mLogic.memDel(pMap);
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
		Object selResult = null;
		switch(reqName){
			case "memDetail":{
				selResult = mLogic.getMemDetail(pMap);
			}break;
			case "memInbody":{
				selResult = mLogic.getMemInbody(pMap);
			}break;
			case "memList":{
				selResult = mLogic.getMemList(pMap);
			}break;
		}
		if(selResult != null) {
			mav.addObject("selResult", selResult);
		}
		else {
			logger.info("MemController - selResult가 Null입니다.");
		}
		
		
		return mav;
	}

}
