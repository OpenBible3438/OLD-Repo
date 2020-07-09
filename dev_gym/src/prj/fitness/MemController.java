package prj.fitness;

import java.io.IOException;
import java.util.ArrayList;
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
	//String autoSel = "false";
	// jsp페이지가 열릴 때 자동으로 데이터가 select 되는 지를 구분하는 변수
	// autoSel = true이면 redirect로 원래 페이지로 돌아갈 때 select 처리를 해줄 필요가 없다.
	
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
			switch(cud) {
				case "ins":{
					try {
						switch(reqName) {
							case "memInbodyIns":{ // 인바디 등록
								result = mLogic.memInbodyIns(pMap);
							}break;
						}
					} catch (Exception e) {
						logger.info("Exception : "+e.toString());
						result = 0;
					}
					path = "redirect:../insertResult" + ":" + result;
				}break;
				case "upd":{
					try {
						switch(reqName) {
							case "memInbodyUpd":{ // 인바디 수정
								result = mLogic.memInbodyUpd(pMap);
							}break;
						}
					} catch (Exception e) {
						logger.info("Exception : "+e.toString());
						result = 0;
					}
					path = "redirect:../updateResult:"+result;
				}break;
				case "del":{
					try {
						switch(reqName) {
							case "memInbodyDel":{ // 인바디 삭제
								result = mLogic.memInbodyDel(pMap);
							}break;
						}
					} catch (Exception e) {
						logger.info("Exception : "+e.toString());
						result = 0;
					}
					path = "redirect:../deleteResult:"+result;
				}break;
			}
			
		logger.info("path : " + path);
		return path;
	}

	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		logger.info("MemController - mav 타입 process 호출");
		ModelAndView mav = new ModelAndView(req, res);
		Object selResult = null;
		try {
			switch(reqName){
				case "jsonMemDetail":{ // 회원 자세히 보기
					selResult = mLogic.getMemDetail(pMap);
				}break;
				case "jsonMemInbody":{ // 인바디 목록 조회
					selResult = mLogic.getMemInbody(pMap);
				}break;
				case "jsonMemInbodyOne":{ // 인바디 조건 검색 조회
					selResult = mLogic.getMemInbodyOne(pMap);
				}break;
				case "jsonMemList":{ // 회원 조회
					selResult = mLogic.getMemList(pMap);
				}break;
				case "jsonMemListOne":{ // 회원 조건검색 
					selResult = mLogic.getMemListOne(pMap);
				}break;
				case "getInbodyImg":{ // 한 회원에 대한 인바디 사진 조회
					selResult = mLogic.getInbodyImg(pMap);
				}break;
				case "jsonOneMemClsList":{ // 한 회원에 대한 등록한 수업 조회
					selResult = mLogic.getOneMemClsList(pMap);
				}break;
			}
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		if(selResult != null) {
			logger.info("selResult != null");
		}
		else {
			logger.info("selResult == null");
			selResult = new ArrayList<>();
			//logger.info("MemController - selResult가 Null입니다.");
		}
		mav.addObject("selResult", selResult);
		mav.setViewName(work+"/"+reqName);
		
		
		return mav;
	}

}
