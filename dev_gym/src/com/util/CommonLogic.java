package com.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import prj.fitness.ModelAndView;


public class CommonLogic {

	Logger logger = Logger.getLogger(CommonLogic.class);
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	
	public CommonLogic(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
		
	}


	public void setCommands(Map<String, Object> pMap) {
		// url : 
		// [0] : 첫 폴더		// fitness
		// [1] : work		// gym
		// [2] : reqName		// jsonClassMemList
		logger.info("getCommands() 호출 ");
		String[] commands = null;
		//	dev_fitness/fitness/gym/gymMain.gym?cud=sel&mode=gym
		String contextPath = req.getContextPath();
		String requestURI = req.getRequestURI();
		int end = requestURI.lastIndexOf(".");
		String command = requestURI.substring(contextPath.length()+1, end);
		commands = command.split("/");
		logger.info("===== commands[] =====");
		for(String str : commands) {
			logger.info("str : " + str);
		}
		if(commands.length == 2) {
			// 메인페이지에서 요청 처리 할 일이 없음.
			pMap.put("main", commands[1]);
		}
		else if(commands.length == 3) {
			pMap.put("work", commands[1]);
			pMap.put("reqName", commands[2]);
		}
	}
	
	
	public String[] moveMapper(Object processResult) {
		String pageMove[] = null;
		if(processResult instanceof String) {
			logger.info("processResult instanceof String");
			pageMove = processResult.toString().split(":");
			logger.info("pageMove[0]="+pageMove[0]+", pageMove[1]="+pageMove[1]);
		}
		else if(processResult instanceof ModelAndView) {
			logger.info("processResult instanceof ModelAndView");
			ModelAndView mav = (ModelAndView)processResult;
			pageMove = new String[2];
			pageMove[0] = "forward";
			pageMove[1] = mav.getViewName();
			logger.info("pageMove[0]="+pageMove[0]+", pageMove[1]="+pageMove[1]);
		}
		
		return pageMove;
	}
	
	
	
}
