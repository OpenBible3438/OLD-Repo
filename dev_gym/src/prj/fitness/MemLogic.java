package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class MemLogic {

	Logger logger = Logger.getLogger(MemLogic.class);
	MemDao mDao = null;
	int result = 0;
	
	public MemLogic() {
		logger.info("MemLogic 생성자 호출");
		this.mDao = new MemDao();
	}
	
	public Map<String, Object> getMemDetail(Map<String, Object> pMap){
		logger.info("MemLogic - getMemDetail() 호출");
		Map<String, Object> memDetail = null;
		memDetail = mDao.getMemDetail(pMap);
		return memDetail;
	}
	
	public List<Map<String, Object>> getMemInbody(Map<String, Object> pMap) {
		logger.info("MemLogic - getMemInbody() 호출");
		List<Map<String, Object>> memInbodyList = null;
		memInbodyList = mDao.getMemList(pMap);
		return memInbodyList;
	}
	
	public List<Map<String, Object>> getMemList(Map<String, Object> pMap) {
		logger.info("MemLogic - getMemList() 호출");
		List<Map<String, Object>> memList = null;
		memList = mDao.getMemList(pMap);
		return memList;
	}
	///////////////////////////////////////////////////////////////
	public int memIns(Map<String, Object> pMap) {
		logger.info("MemLogic - memIns() 호출");
		mDao.memIns(pMap);
		return result;
	}
	
	public int memUpd(Map<String, Object> pMap) {
		logger.info("MemLogic - memUpd() 호출");
		mDao.memUpd(pMap);
		return result;
	}
	
	public int memDel(Map<String, Object> pMap) {
		logger.info("MemLogic - memDel() 호출");
		mDao.memDel(pMap);
		return result;
	}
	
	public int memInbodyIns(Map<String, Object> pMap) {
		logger.info("MemLogic - memIns() 호출");
		mDao.memInbodyIns(pMap);
		return result;
	}
	
	public int memInbodyUpd(Map<String, Object> pMap) {
		logger.info("MemLogic - memUpd() 호출");
		mDao.memInbodyUpd(pMap);
		return result;
	}
	
	public int memInbodyDel(Map<String, Object> pMap) {
		logger.info("MemLogic - memDel() 호출");
		mDao.memInbodyDel(pMap);
		return result;
	}
	
	
}
