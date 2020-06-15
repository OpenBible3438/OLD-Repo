package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TchDao {

	Logger logger = Logger.getLogger(TchDao.class);
	int result = 0;
	
	public List<Map<String, Object>> getTchList(Map<String, Object> pMap) {
		logger.info("TchDao - getTchList() 호출");
		List<Map<String, Object>> tchList = null;
		
		return tchList;
	}
	
	public List<Map<String, Object>> getTchClassList(Map<String, Object> pMap) {
		logger.info("TchDao - getTchClassList() 호출");
		List<Map<String, Object>> tchClassList = null;
		
		return tchClassList;
	}

	public Map<String, Object> getTchProfile(Map<String, Object> pMap) {//강사 프로필 보기
		logger.info("TchDao - getTchProfile() 호출");
		Map<String, Object> tchProfile = null;
		
		return tchProfile;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public int tchIns(Map<String, Object> pMap) {
		logger.info("TchDao - tchIns 호출");
		
		return result;
	}
	
	public int tchUpd(Map<String, Object> pMap) {
		logger.info("TchDao - tchUpd 호출");
		
		return result;
	}
	
	public int tchDel(Map<String, Object> pMap) {
		logger.info("TchDao - tchDel 호출");
		
		return result;
	}
	
}