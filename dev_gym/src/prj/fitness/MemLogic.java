package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;

public class MemLogic {

	Logger logger = Logger.getLogger(MemLogic.class);
	MemDao mDao = null;
	int result = 0;
	
	MyBatisBuilderMgr mbMgr = null;
	SqlSession sqlSession = null;
	
	public MemLogic() {
		logger.info("MemLogic 생성자 호출");
		mbMgr = MyBatisBuilderMgr.getInstance();
		sqlSession = mbMgr.openSession();
		this.mDao = new MemDao(sqlSession);
	}
	
	public List<Map<String, Object>> getMemDetail(Map<String, Object> pMap){//여유가 되면 Map으로 바꾸자
		logger.info("MemLogic - getMemDetail() 호출");
		List<Map<String, Object>> memDetail = null;
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
		result = mDao.memIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int memUpd(Map<String, Object> pMap) {
		logger.info("MemLogic - memUpd() 호출");
		result = mDao.memUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int memDel(Map<String, Object> pMap) {
		logger.info("MemLogic - memDel() 호출");
		result = mDao.memDel(pMap);
		setCommit(result);
		return result;
	}
	
	public int memInbodyIns(Map<String, Object> pMap) {
		logger.info("MemLogic - memInbodyIns() 호출");
		result = mDao.memInbodyIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int memInbodyUpd(Map<String, Object> pMap) {
		logger.info("MemLogic - memInbodyUpd() 호출");
		result = mDao.memInbodyUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int memInbodyDel(Map<String, Object> pMap) {
		logger.info("MemLogic - memInbodyDel() 호출");
		result = mDao.memInbodyDel(pMap);
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
