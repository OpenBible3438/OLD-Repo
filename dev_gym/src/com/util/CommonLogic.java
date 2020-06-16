package com.util;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import prj.fitness.ModelAndView;


public class CommonLogic {

	Logger logger = Logger.getLogger(CommonLogic.class);
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	boolean isRedirect = false;
	String pageMove[] = null;
	
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
			pMap.put("work", "main");
			pMap.put("reqName", commands[1]);//login이 들어감
		}
		else if(commands.length == 3) {
			pMap.put("work", commands[1]);
			pMap.put("reqName", commands[2]);
		}
	}
	
	
	public void moveMapper(Object processResult) {
		logger.info("moveMapper() 호출");
		if(processResult instanceof String) {
			logger.info("processResult instanceof String");
			pageMove = processResult.toString().split(":");
		}
		else if(processResult instanceof ModelAndView) {
			logger.info("processResult instanceof ModelAndView");
			pageMove = new String[2];
			ModelAndView mav = (ModelAndView)processResult;
			pageMove[0] = "forward";
			pageMove[1] = mav.getViewName();
		}
		logger.info("pageMove[0]= "+pageMove[0]+", pageMove[1]= "+pageMove[1]);
		if(pageMove != null);
		moveAction();
	}
	
	public void moveAction() {
		logger.info("moveAction() 호출");
		try {
			if(pageMove[0].equals("redirect")) {
				logger.info("redirect");
				if(pageMove.length==4) {
					logger.info("이동할 페이지 : " + pageMove[1]+"/"+pageMove[2]+"?result="+pageMove[3] );
					res.sendRedirect(pageMove[2]+".gym?result="+pageMove[3]);
				}
				else {
					logger.info("**************pageMove를 확인해주세요**************");
				}
			}
			else {
				logger.info("forward");
				RequestDispatcher view = req.getRequestDispatcher(pageMove[1]);
				view.forward(req, res);
			}
		} catch (Exception e) {
			logger.info("============ moveAction()============");
			e.printStackTrace();
		}
	}
	
}
