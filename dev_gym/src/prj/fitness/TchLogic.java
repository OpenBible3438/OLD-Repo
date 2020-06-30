package prj.fitness;

import java.io.File;
import java.io.FileInputStream;
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
		
		mbMgr.clossSession(sqlSession);
		
		return tchList;
	}
	
	public List<Map<String, Object>> getTchClassList(Map<String, Object> pMap) {
		logger.info("TchLogic - getTchClassList() 호출");
		List<Map<String, Object>> tchClassList = null;
		tchClassList = tDao.getTchClassList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return tchClassList;
	}

	public List<Map<String, Object>> getTchProfile(Map<String, Object> pMap) {//강사 프로필 보기 //여유 되면 map으로 바꾸기
		logger.info("TchLogic - getTchProfile() 호출");
		List<Map<String, Object>> tchProfile = null;
		tchProfile = tDao.getTchProfile(pMap);
		mbMgr.clossSession(sqlSession);
		
		return tchProfile;
	}
	
	public List<Map<String, Object>> tchNoSearch(Map<String, Object> pMap) {
		logger.info("TchLogic - tchNoSearch() 호출");
		List<Map<String, Object>> selList = null;
		selList = tDao.tchNoSearch(pMap);
		mbMgr.clossSession(sqlSession);
		
		return selList;
	}
	public int tchIDSearch(Map<String, Object> pMap) {
		logger.info("TchLogic - tchIDSearch() 호출");
		int selID = tDao.tchIDSearch(pMap);
		mbMgr.clossSession(sqlSession);
		
		return selID;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	public int tchIns(Map<String, Object> pMap) {
		logger.info("TchLogic - tchIns 호출");
		result = tDao.tchIns(pMap);
		if(result == 1) {
			result = tDao.tchInsImg(pMap);
			try {
				((FileInputStream)pMap.get("filedata")).close();
				if(((File)pMap.get("file")).delete()) {
					logger.info("파일삭제 성공");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
