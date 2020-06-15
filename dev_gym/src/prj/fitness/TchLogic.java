package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TchLogic {

	Logger logger = Logger.getLogger(TchLogic.class);
	TchDao tDao = null;
	int result = 0;
	
	public TchLogic() {
		logger.info("TchLogic 생성자 호출");
		this.tDao = new TchDao();
	}
	
	public List<Map<String, Object>> getTchList(Map<String, Object> pMap) {
		logger.info("TchLogic - getTchList() 호출");
		List<Map<String, Object>> tchList = null;
		tchList = tDao.getTchList(pMap);
		
		return tchList;
	}
	
	public List<Map<String, Object>> getTchClassList(Map<String, Object> pMap) {
		logger.info("TchLogic - getTchClassList() 호출");
		List<Map<String, Object>> tchClassList = null;
		tchClassList = tDao.getTchClassList(pMap);
		return tchClassList;
	}

	public Map<String, Object> getTchProfile(Map<String, Object> pMap) {//강사 프로필 보기
		logger.info("TchLogic - getTchProfile() 호출");
		Map<String, Object> tchProfile = null;
		tchProfile = tDao.getTchProfile(pMap);
		return tchProfile;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	public int tchIns(Map<String, Object> pMap) {
		logger.info("TchLogic - tchIns 호출");
		result = tDao.tchIns(pMap);
		return result;
	}
	
	public int tchUpd(Map<String, Object> pMap) {
		logger.info("TchLogic - tchUpd 호출");
		result = tDao.tchUpd(pMap);
		return result;
	}
	
	public int tchDel(Map<String, Object> pMap) {
		logger.info("TchLogic - tchDel 호출");
		result = tDao.tchDel(pMap);
		return result;
	}
	
}
