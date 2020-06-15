package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class MemDao {

	Logger logger = Logger.getLogger(MemDao.class);
	int result = 0;
	
	public Map<String, Object> getMemDetail(Map<String, Object> pMap) {//회원 자세히보기
		logger.info("MemDao - getMemDetail() 호출");
		Map<String, Object> memDetail = null;
		
		return memDetail;
	}
	
	public List<Map<String, Object>> getMemInbody(Map<String, Object> pMap){
		List<Map<String, Object>> memInbodyList = null;
		logger.info("MemDao - getMemInbody() 호출");
		
		return memInbodyList;
	}
	
	public List<Map<String, Object>> getMemList(Map<String, Object> pMap){////전체조회, 상세조회 모두 가능
		List<Map<String, Object>> memList = null;
		logger.info("MemDao - getMemList() 호출");
		
		return memList;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public int memIns(Map<String, Object> pMap) {
		logger.info("MemDao - classUpd() 호출");
		
		return result;
	}
	
	public int memUpd(Map<String, Object> pMap) {
		logger.info("MemDao - classUpd() 호출");
		
		return result;
	}
	
	public int memDel(Map<String, Object> pMap) {
		logger.info("MemDao - classUpd() 호출");
		
		return result;
	}
	
	public int memInbodyIns(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyIns() 호출");
		
		return result;
	}
	
	public int memInbodyUpd(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyUpd() 호출");
		
		return result;
	}
	
	public int memInbodyDel(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyDel() 호출");
		
		return result;
	}

}
