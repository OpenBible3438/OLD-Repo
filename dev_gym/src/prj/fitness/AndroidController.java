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
		
		return "아직 안 했어요";
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		logger.info("AndroidController - mav 타입 process 호출");
		ModelAndView mav = new ModelAndView(req, res);
		Object selResult = null;
		try {
			switch(reqName) {
			case "jsonMemberLogin":{
				selResult = aLogic.getMemberLogin(pMap);
			}break;
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
