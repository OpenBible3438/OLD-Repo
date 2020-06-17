package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class TchDao {

	Logger logger = Logger.getLogger(TchDao.class);
	int result = 0;
	SqlSession sqlSession = null;
	
	public TchDao(SqlSession sqlSession) {
		logger.info("TchDao 생성자 호출");
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String, Object>> getTchList(Map<String, Object> pMap) {
		logger.info("TchDao - getTchList() 호출");
		List<Map<String, Object>> tchList = null;
		tchList = sqlSession.selectList("getTchList", pMap);
		return tchList;
	}
	
	public List<Map<String, Object>> getTchClassList(Map<String, Object> pMap) {
		logger.info("TchDao - getTchClassList() 호출");
		List<Map<String, Object>> tchClassList = null;
		tchClassList = sqlSession.selectList("getTchClassList", pMap);
		
		return tchClassList;
	}

	public List<Map<String, Object>> getTchProfile(Map<String, Object> pMap) {//강사 프로필 보기 //여유 되면 map으로
		logger.info("TchDao - getTchProfile() 호출");
		List<Map<String, Object>> tchProfile = null;
		tchProfile = sqlSession.selectList("getTchProfile", pMap);
		
		return tchProfile;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public int tchIns(Map<String, Object> pMap) {
		logger.info("TchDao - tchIns 호출");
		result = sqlSession.insert("tchIns");
		
		return result;
	}
	
	public int tchUpd(Map<String, Object> pMap) {
		logger.info("TchDao - tchUpd 호출");
		result = sqlSession.update("tchIns");
		
		return result;
	}
	
	public int tchDel(Map<String, Object> pMap) {
		logger.info("TchDao - tchDel 호출");
		result = sqlSession.delete("tchDel");
		
		return result;
	}
	
}