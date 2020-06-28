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
	String autoSel = "false";
	// jsp페이지가 열릴 때 자동으로 데이터가 select 되는 지를 구분하는 변수
	// autoSel = true이면 redirect로 원래 페이지로 돌아갈 때 select 처리를 해줄 필요가 없다.
	
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
					case("tchIns"):{ // 강사 등록
						result = tLogic.tchIns(pMap);
					}break;
				}
				path = "redirect:../insertResult:"+result + ":"+ autoSel;
			}break;
			case "upd":{
				switch(reqName) {
					case("tchUpd"):{ // 강사 수정
						result = tLogic.tchUpd(pMap);
					}break;
					case("tchUpd2"):{ 
						//result = tLogic.tchUpd2(pMap);
					}break;
				}
				path = "redirect:../updateResult:"+result + ":"+ autoSel;
			}break;
			case "del":{
				switch(reqName) {
					case("tchDel"):{ // 강사 삭제
						result = tLogic.tchDel(pMap);
					}break;
				}
				path = "redirect:../deleteResult:"+result + ":"+ autoSel;
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
			case "jsonTchClass":{ // 강사별 수업 조회
				selResult = tLogic.getTchClassList(pMap);
			}break;
			case "jsonTchList":{ // 강사 목록 조회
				selResult = tLogic.getTchList(pMap);
			}break;
			case "jsonTchProfile":{ // 강사 프로필 조회
				selResult = tLogic.getTchProfile(pMap);
			}break;
			case "tchNoSearch":{ // 강사 프로필 조회 - 번호찾기 - 번호검색
				selResult = tLogic.tchNoSearch(pMap);
			}break;
			case "tchIDSearch":{ // 강사 프로필 조회 - 번호찾기 - 아이디중복확인
				selResult = tLogic.tchIDSearch(pMap);
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
