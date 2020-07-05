package prj.fitness;

import java.sql.SQLException;
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
	
	public List<Map<String, Object>> getMemDetail(Map<String, Object> pMap) throws SQLException {//회원 자세히보기
		logger.info("MemDao - getMemDetail() 호출");
		List<Map<String, Object>> memDetail = null;
		memDetail = sqlSession.selectList("getMemDetail",pMap);/////여유가 된다면 Map으로 바꾸자
		
		return memDetail;
	}
	// 인바디 전체 조회 
	public List<Map<String, Object>> getMemInbody(Map<String, Object> pMap) throws SQLException {
		List<Map<String, Object>> memInbodyList = null;
		logger.info("MemDao - getMemInbody() 호출");
		sqlSession.selectOne("getMemInbody",pMap);
		memInbodyList = (List<Map<String, Object>>)pMap.get("inbodyList");
		return memInbodyList;
	}
	// 인바디 조건 검색 
	public List<Map<String, Object>> getMemInbodyOne(Map<String, Object> pMap) throws SQLException {
		List<Map<String, Object>> memInbodyList = null;
		logger.info("MemDao - getMemInbodyOne() 호출");
		sqlSession.selectOne("getMemInbodyOne",pMap);
		memInbodyList = (List<Map<String, Object>>)pMap.get("ibdOneList");
		return memInbodyList;
	}

	// 전체 조회에서 전체 조회를 눌렀을 때
	public List<Map<String, Object>> getMemList(Map<String, Object> pMap) throws SQLException {
		List<Map<String, Object>> memList = null;
		logger.info("MemDao - getMemList() 호출");
		sqlSession.selectOne("getMemList",pMap);
		memList = (List<Map<String, Object>>)pMap.get("gymMemList");
		logger.info("memList : "+memList.size()+"row");
		return memList;
	}
	// 회원 조건 검색 
	public List<Map<String, Object>> getMemListOne(Map<String, Object> pMap) throws SQLException {
		List<Map<String, Object>> memList = null;
		logger.info("MemDao - getMemListOne() 호출");
		sqlSession.selectOne("getMemListOne",pMap);
		memList = (List<Map<String, Object>>)pMap.get("gymMemOneList");
		logger.info("memList : "+memList.size()+"row");
		return memList;
	}
	
	
	// 한 회원에 대한 인바디 인미지 가져오기 
	public List<Map<String, Object>> getInbodyImg(Map<String, Object> pMap) throws SQLException {
		logger.info("MemDao - getInbodyImg() 호출");
		List<Map<String, Object>> memList = null;
		sqlSession.selectOne("getInbodyImg",pMap);
		memList =  (List<Map<String, Object>>)pMap.get("memInbodyMap");
		return memList;
	}
	
	// 한 회원에 대한 수업 리스트 조회 
	public List<Map<String, Object>> getOneMemClsList(Map<String, Object> pMap) throws SQLException {
		logger.info("MemDao - getOneMemClsList() 호출");
		List<Map<String, Object>> memList = null;
		sqlSession.selectOne("getOneMemClsList",pMap);
		memList =  (List<Map<String, Object>>)pMap.get("oneMemClsList");
		return memList;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 회원 인바디 테이블에 인바디 정보 등록
	public int memInbodyIns(Map<String, Object> pMap) throws SQLException {
		logger.info("MemDao - memInbodyIns() 호출");
		int inbd_seq = sqlSession.selectOne("getInbodySeq");
		pMap.put("inbd_seq", inbd_seq);
		result = sqlSession.insert("memInbodyIns",pMap);
		
		return result;
	}
	// 회원 인바디 테이블에 인바디 정보 등록 후 인바디 사진 등록 
	public int memInbodyImgIns(Map<String, Object> pMap) throws SQLException {
		logger.info("MemDao - memInbodyImgIns() 호출");
		result = sqlSession.insert("memInbodyImgIns",pMap);
		return result;
	}
	
	public int memInbodyUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("MemDao - memInbodyUpd() 호출");
		result = sqlSession.update("memInbodyUpd");
		
		return result;
	}
	
	public int memInbodyDel(Map<String, Object> pMap) throws SQLException {
		logger.info("MemDao - memInbodyDel() 호출");
		result = sqlSession.delete("memInbodyTableDel", pMap);
		
		return result;
	}
	
	public int memInbodyImgDel(Map<String, Object> pMap) throws SQLException {
		logger.info("MemDao - memInbodyImgDel() 호출");
		result = sqlSession.delete("memInbodyImgDel", pMap);
		
		return result;
	}




}
