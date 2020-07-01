package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import oracle.net.aso.p;

public class MemDao {


	Logger logger = Logger.getLogger(MemDao.class);
	int result = 0;
	SqlSession sqlSession = null;
	
	public MemDao(SqlSession sqlSession) {
		logger.info("MemDao 생성자 호출");
		this.sqlSession = sqlSession;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Map<String, Object>> getMemDetail(Map<String, Object> pMap) {//회원 자세히보기
		logger.info("MemDao - getMemDetail() 호출");
		List<Map<String, Object>> memDetail = null;
		memDetail = sqlSession.selectList("getMemDetail",pMap);/////여유가 된다면 Map으로 바꾸자
		
		return memDetail;
	}
	
	public List<Map<String, Object>> getMemInbody(Map<String, Object> pMap){
		List<Map<String, Object>> memInbodyList = null;
		logger.info("MemDao - getMemInbody() 호출");
		sqlSession.selectOne("getMemInbody",pMap);
		memInbodyList = (List<Map<String, Object>>)pMap.get("inbodyList");
		return memInbodyList;
	}
	
	public List<Map<String, Object>> getMemList(Map<String, Object> pMap){////전체조회, 상세조회 모두 가능
		List<Map<String, Object>> memList = null;
		logger.info("MemDao - getMemList() 호출");
		memList = sqlSession.selectList("getMemList",pMap);
		return memList;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int memIns(Map<String, Object> pMap) {
		logger.info("MemDao - classUpd() 호출");
		result = sqlSession.insert("memIns");
		
		return result;
	}
	
	public int memUpd(Map<String, Object> pMap) {
		logger.info("MemDao - classUpd() 호출");
		result = sqlSession.update("memUpd");
		
		return result;
	}
	
	public int memDel(Map<String, Object> pMap) {
		logger.info("MemDao - memDel() 호출");
		result = sqlSession.delete("memDel");
		
		return result;
	}
	// 회원 인바디 테이블에 인바디 정보 등록
	public int memInbodyIns(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyIns() 호출");
		int inbd_seq = sqlSession.selectOne("getInbodySeq");
		pMap.put("inbd_seq", inbd_seq);
		result = sqlSession.insert("memInbodyIns",pMap);
		
		return result;
	}
	// 회원 인바디 테이블에 인바디 정보 등록 후 인바디 사진 등록 
	public int memInbodyImgIns(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyImgIns() 호출");
		result = sqlSession.insert("memInbodyImgIns",pMap);
		return result;
	}
	
	public int memInbodyUpd(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyUpd() 호출");
		result = sqlSession.update("memInbodyUpd");
		
		return result;
	}
	
	public int memInbodyDel(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyDel() 호출");
		result = sqlSession.delete("memInbodyTableDel", pMap);
		
		return result;
	}
	
	public int memInbodyImgDel(Map<String, Object> pMap) {
		logger.info("MemDao - memInbodyImgDel() 호출");
		result = sqlSession.delete("memInbodyImgDel", pMap);
		
		return result;
	}


}
