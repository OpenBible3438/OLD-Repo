package com.util;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import oracle.sql.BLOB;
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
		if(req.getSession().getAttribute("gym_no")!=null) {
			int gym_no = 0;
			gym_no = Integer.parseInt(req.getSession().getAttribute("gym_no").toString());
			pMap.put("gym_no", gym_no);
			logger.info("gym_no : " + gym_no);
		}
		//logger.info("pMap : " + pMap);
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
			ModelAndView mav = (ModelAndView)processResult;
			if (mav.type.equals("json")) {
				
				logger.info("type : json - printJson");
				printJson(mav.res, mav.getObject());
			} else if(mav.type.equals("img")) {
				logger.info("type : img - printImg");
				printImg(mav.res, mav.getObject());			
			} else {
				pageMove = new String[2];
				pageMove[0] = "forward";
				pageMove[1] = mav.getViewName();
			}
		}
		if(pageMove != null) {
			logger.info("pageMove[0]= "+pageMove[0]+", pageMove[1]= "+pageMove[1]);
			moveAction();
		}
	}
	
	private void printJson(HttpServletResponse response, Object selResult) {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
		Gson g = new Gson();
		String jsonResult = null;
		if(selResult != null) {
			jsonResult = g.toJson(selResult);
		}else {
			jsonResult = "데이터가 없습니다.";/////////이렇게 해두면 출력할 때 문제가 있을 것 같다...!
		}
        try {
        	logger.info("jsonResult : " + jsonResult);
        	response.getWriter().print(jsonResult);
		} catch (Exception e) {
			logger.info("printJson 오류");
			e.printStackTrace();
		}
	}
	private void printImg(HttpServletResponse response, Object selResult) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("image/png; charset=UTF-8");
		BLOB blob = null;
		try {
			if(selResult != null) {
				logger.info("호출 : printImg, selResult != null");
				List<Map<String, Object>> list = (List<Map<String, Object>>)selResult;
				blob = (BLOB)list.get(0).get("img");
				byte[] image = blob.getBytes(1, (int)blob.length());
				OutputStream o = response.getOutputStream();
				o.write(image);
				o.flush();
				o.close();
			}else {
				logger.info("호출 : printImg, selResult == null");
				response.getWriter().print("데이터가 없습니다.");
			}
		} catch (Exception e) {
			logger.info("printImg 오류");
			e.printStackTrace();
		}
	}


	public void moveAction() {
		logger.info("moveAction() 호출");
		String path = "";
		try {
			if(pageMove[0].equals("redirect")) {
				logger.info("redirect");
				logger.info("pageMove.length : " + pageMove.length);
				if(pageMove.length == 3) {
					path = pageMove[1]+".jsp?result="+pageMove[2];
					logger.info("pageMove.length==3 // 이동할 페이지 : " + path );
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
