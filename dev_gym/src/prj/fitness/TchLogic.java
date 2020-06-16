package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;

public class TchLogic {

	Logger logger = Logger.getLogger(TchLogic.class);
	TchDao tDao = null;
	int result = 0;
	
	MyBatisBuilderMgr mbMgr = null;
	SqlSession sqlSession = null;
	
	public TchLogic() {
		logger.info("TchLogic 생성자 호출");
		mbMgr = MyBatisBuilderMgr.getInstance();
		sqlSession = mbMgr.openSession();
		this.tDao = new TchDao(sqlSession);
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

	public List<Map<String, Object>> getTchProfile(Map<String, Object> pMap) {//강사 프로필 보기 //여유 되면 map으로 바꾸기
		logger.info("TchLogic - getTchProfile() 호출");
		List<Map<String, Object>> tchProfile = null;
		tchProfile = tDao.getTchProfile(pMap);
		return tchProfile;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	public int tchIns(Map<String, Object> pMap) {
		logger.info("TchLogic - tchIns 호출");
		result = tDao.tchIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int tchUpd(Map<String, Object> pMap) {
		logger.info("TchLogic - tchUpd 호출");
		result = tDao.tchUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int tchDel(Map<String, Object> pMap) {
		logger.info("TchLogic - tchDel 호출");
		result = tDao.tchDel(pMap);
		setCommit(result);
		return result;
	}
	
	
	public void setCommit(int result) {
		logger.info("setCommit() 호출"); 
		if(result>0) {
			logger.info("sqlSession.commit() - result : " + result);
			sqlSession.commit();
		}
		else {
			logger.info("sqlSession.rollback() - result : " + result);
			sqlSession.rollback();
		}
	}
	
}
