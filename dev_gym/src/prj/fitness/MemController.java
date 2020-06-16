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
		work = pMap.get("work").toString();
		reqName = pMap.get("reqName").toString();
		logger.info("work : " + work + ", reqName : " + reqName);
	}
	
	
	@Override
	public String process(String cud, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		logger.info("MemController - String 타입 process 호출");
		String path = null;
		switch(reqName) {
			case "jsonMemInbody":{
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
			case "jsonMemList":{
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
		logger.info("path : " + path);
		
		return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		logger.info("MemController - mav 타입 process 호출");
		ModelAndView mav = new ModelAndView(req, res);
		Object selResult = null;
		switch(reqName){
			case "jsonMemDetail":{
				selResult = mLogic.getMemDetail(pMap);
			}break;
			case "jsonMemInbody":{
				selResult = mLogic.getMemInbody(pMap);
			}break;
			case "jsonMemList":{
				selResult = mLogic.getMemList(pMap);
			}break;
		}
		if(selResult != null) {
			logger.info("selResult != null");
			mav.addObject("selResult", selResult);
			mav.setViewName(work+"/"+reqName);
		}
		else {
			logger.info("selResult == null");
			logger.info("MemController - selResult가 Null입니다.");
		}
		
		
		return mav;
	}

}
