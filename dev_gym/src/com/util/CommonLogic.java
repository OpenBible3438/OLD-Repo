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
		logger.info("requestURI : "+requestURI);
		int end = requestURI.lastIndexOf(".");
		String command = requestURI.substring(contextPath.length()+1, end);
		commands = command.split("/");
		logger.info("===== commands[] =====");
		for(String str : commands) {
			logger.info("str : " + str);
		}
		/*if(commands.length == 2) {
			pMap.put("work", "main");
			pMap.put("reqName", commands[1]);//login이 들어감
		}*/
		if(commands.length == 3) {
			pMap.put("work", commands[1]);
			pMap.put("reqName", commands[2]);
		}
		///////세션으로 매장번호 받아와서 pMap에 넣기//////////
		logger.info("**************************");
		logger.info(req.getAttribute("gym_no"));
		req.getSession().getAttribute("gym_no");
		String gym_no = null;
		if(req.getSession().getAttribute("gym_no")!=null) {
			gym_no = req.getSession().getAttribute("gym_no").toString();
		}
		else {
			logger.info("gym_no가 없으므로 1로 설정");
			gym_no = "1";//세션없으면 1로 두기. 테스트 하기 위한 기본 값이다.
		}
		logger.info("gym_no : " + gym_no);
		pMap.put("gym_no", gym_no);
//		logger.info("pMap : " + pMap);
        if("gym".equals(pMap.get("type"))) {
    	  logger.info("체크박스 세팅");
          if(!(pMap.containsKey("gym_parking"))) pMap.put("gym_parking", "off");
          if(!(pMap.containsKey("gym_wash")))    pMap.put("gym_wash", "off");
          if(!(pMap.containsKey("gym_uniform"))) pMap.put("gym_uniform", "off");
          if(!(pMap.containsKey("gym_locker")))  pMap.put("gym_locker", "off");
        }
	}
	
	public void moveMapper(Object processResult) {
		logger.info("moveMapper() 호출");
		if(processResult instanceof String) {
			logger.info("processResult instanceof String");
			pageMove = processResult.toString().split(":");
			logger.info("processResult : " + processResult);
		}
		else if(processResult instanceof ModelAndView) {
			logger.info("processResult instanceof ModelAndView");
			pageMove = new String[2];
			ModelAndView mav = (ModelAndView)processResult;
			pageMove[0] = "forward";
			pageMove[1] = mav.getViewName();
		}
		logger.info("pageMove[0]= "+pageMove[0]+", pageMove[1]= "+pageMove[1]);
		if(pageMove != null)
			moveAction();
	}
	
	public void moveAction() {
		logger.info("moveAction() 호출");
		String path = "";
		try {
			if(pageMove[0].equals("redirect")) {
				logger.info("redirect");
				logger.info("pageMove.length : " + pageMove.length);
				if(pageMove.length==4) {
					path = pageMove[1]+".jsp?result="+pageMove[2] +"&autoSel=" + pageMove[3];
					logger.info("pageMove.length==4 // 이동할 페이지 : " + path );
					res.sendRedirect(path);
				}
				else {
					logger.info("**************pageMove를 확인해주세요**************");
				}
			}
			else {
				logger.info("forward : "+pageMove[1]);
				RequestDispatcher view = req.getRequestDispatcher(pageMove[1]);
				view.forward(req, res);
			}
		} catch (Exception e) {
			logger.info("============ moveAction()============");
			e.printStackTrace();
		}
	}
	
}
