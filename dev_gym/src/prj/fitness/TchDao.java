package prj.fitness;

import java.sql.SQLException;
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
	// 강사 전체 조회 
	public List<Map<String, Object>> getTchList(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - getTchList() 호출");
		List<Map<String, Object>> tchList = null;
		//
		sqlSession.selectOne("getProcTchList", pMap);
		
		tchList = (List<Map<String, Object>>)pMap.get("gymTchList");
		
		logger.info(" - tchList : "+tchList.size()+"row");
		//logger.info(" - tchList : "+tchList.toString());
		return tchList;
	}
	
	//강사 조건 검색 
	public List<Map<String, Object>> getTchListOne(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - getTchListOne() 호출");
		List<Map<String, Object>> tchList = null;
		//
		sqlSession.selectOne("getTchListOne", pMap);
		tchList = (List<Map<String, Object>>)pMap.get("tchOneList");
		logger.info(" - tchList : "+tchList.size()+"row");
		//logger.info(" - tchList : "+tchList.toString());
		return tchList;
	}
	
	public List<Map<String, Object>> getTchClassList(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - getTchClassList() 호출");
		List<Map<String, Object>> tchClassList = null;
		//tchClassList = sqlSession.selectList("getTchClassList", pMap);
		sqlSession.selectList("getProcTchClassList", pMap);
		tchClassList = (List<Map<String, Object>>)pMap.get("gymClsList");
		//
		return tchClassList;
	}

	public List<Map<String, Object>> getTchProfile(Map<String, Object> pMap) throws SQLException {//강사 프로필 보기 //여유 되면 map으로
		logger.info("TchDao - getTchProfile() 호출");
		List<Map<String, Object>> tchProfile = null;
		tchProfile = sqlSession.selectList("getTchProfile", pMap);
		
		return tchProfile;
	}
	public List<Map<String, Object>> tchNoSearch(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - tchNoSearch() 호출");
		List<Map<String, Object>> tchList = null;
		tchList = sqlSession.selectList("tchNoConfirm",pMap);
		if(tchList.get(0).get("CONFIRM")!=null 
				&& "0".equals(tchList.get(0).get("CONFIRM").toString())) {
			sqlSession.selectList("tchNoSearch", pMap);
			tchList = (List<Map<String, Object>>)pMap.get("gymTchList");
		}
		logger.info(" - tchList : "+tchList.toString());
		return tchList;
	}

	public int tchProfNo(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - tchProfNo() 호출");
		result = sqlSession.selectOne("tchProfNo", pMap);
		return result;
	}
	
	public int tchIDSearch(Map<String, Object> pMap) {
		logger.info("TchDao - tchIDSearch() 호출");
		result = sqlSession.selectOne("tchIDSearch", pMap);
		return result;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	
	//강사 회원가입 
	public int tchIns(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - tchIns 호출");
		if(pMap.get("tch_no") != null && pMap.get("tch_no").toString().length() == 0) {
			result = sqlSession.selectOne("getTchNo",pMap);
			pMap.put("tch_no",result);
		}
		result = sqlSession.insert("tchIns", pMap);
		return result;
	}
	// 강사 회원가입 이미지 인서트 
	public int tchInsImg(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - tchInsImg 호출");
		result = sqlSession.insert("tchInsImg", pMap);
		return result;
	}
	// 강사 프로필 등록 
	public int tchProfIns(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - tchProfIns 호출");
		result = sqlSession.update("tchProfIns",pMap);
		
		return result;
	}
	// 강사 프로필 수정 
	public int tchProfUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - tchProfUpd 호출");
		result = sqlSession.update("tchProfUpd",pMap);
		
		return result;
	}
	
	public int tchDel(Map<String, Object> pMap) throws SQLException {
		logger.info("TchDao - tchDel 호출");
		result = sqlSession.delete("tchDel",pMap);
		
		return result;
	}



}