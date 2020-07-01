package prj.fitness;

import java.io.File;
import java.io.FileInputStream;
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
		logger.info("MemLogic - getMemDetail() 호출"+pMap.get("mem_no"));
		List<Map<String, Object>> memDetail = null;
		memDetail = mDao.getMemDetail(pMap);
		return memDetail;
	}
	
	public List<Map<String, Object>> getMemInbody(Map<String, Object> pMap) {
		logger.info("MemLogic - getMemInbody() 호출");
		List<Map<String, Object>> memInbodyList = null;
		memInbodyList = mDao.getMemInbody(pMap);
		
		return memInbodyList;
	}
	// 한 회원에 대한 인바디 이미지 불러오기 
	public List<Map<String, Object>> getInbodyImg(Map<String, Object> pMap) {
		logger.info("MemLogic - getMemInbody() 호출");
		List<Map<String, Object>> inbodyList = null;

		inbodyList = mDao.getInbodyImg(pMap);
		mbMgr.clossSession(sqlSession);
		
		return inbodyList;
	}
	/****************************************************************************************************
	 * 회원전체 조회 구현
	 * @param pMap - 파라미터 값 담기
	 * @return - List<Map> -> Gson -> json포맷
	 ***************************************************************************************************/
	public List<Map<String, Object>> getMemList(Map<String, Object> pMap) {
		logger.info("MemLogic - getMemList() 호출");
		List<Map<String, Object>> memList = null;
		memList = mDao.getMemList(pMap);
		return memList;
	}
	
	///////////////////////////////////////////////////////////////
	
	public int memInbodyIns(Map<String, Object> pMap) {
		logger.info("MemLogic - memInbodyIns() 호출");
		result = mDao.memInbodyIns(pMap);
		if(result == 1 && pMap.get("filename")!=null) {
			result = mDao.memInbodyImgIns(pMap);
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
	
	public int memInbodyUpd(Map<String, Object> pMap) {
		logger.info("MemLogic - memInbodyUpd() 호출");
		result = mDao.memInbodyUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int memInbodyDel(Map<String, Object> pMap) {
		logger.info("MemLogic - memInbodyDel() 호출");
		result = mDao.memInbodyDel(pMap);
		if(result == 1) {		
			result = mDao.memInbodyImgDel(pMap);
		}
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
