package prj.fitness;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;

public class AndroidDao {
	Logger logger = Logger.getLogger(AndroidDao.class);
	int result = 0;
	SqlSession sqlSession = null;
	MyBatisBuilderMgr mbMgr = null;
	
	public AndroidDao(SqlSession sqlSession) {
		logger.info("AndroidDao 생성자 호출");
		this.sqlSession = sqlSession;
	}
// 편성경
	//안드로이드 회원 로그인 테스트
	public List<Map<String, Object>> getMemberLogin(Map<String, Object> pMap) throws SQLException{
		logger.info("AndroidDao - getMemberLogin() 호출");
		List<Map<String, Object>> loginResult = null;
		loginResult = sqlSession.selectList("getMemberLogin", pMap);
		logger.info("==Member Login result : "+loginResult.size()+"row==");
		return loginResult;
	}
	// 회원가입 회원 번호 채번 
	public int memberJoinGetNo(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidDao - memberJoinGetNo() 호출");
		result = sqlSession.selectOne("memberJoinGetNo", pMap);
		return result;
	}
	// 회원가입 회원 정보 insert
	public int memberJoinInfo(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidDao - memberJoinInfo() 호출");
		result = sqlSession.insert("memberJoinInfo", pMap);
		return result;
	}
	// 회원가입 회원 이미지 insert
	public int memberJoinImg(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidDao - memberJoinImg() 호출");
		result = sqlSession.insert("memberJoinImg", pMap);
		return result;
	}
// 김혜림
	//강사가 맡은 수업 목록 조회
	public List<Map<String, Object>> getTchClassList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getTchClassList() 호출");
		List<Map<String, Object>> classList = null;
		classList = sqlSession.selectList("getTchClassList_and", pMap);
		logger.info("classList.size() : " + classList.size());
		return classList;
	}
	//수업별 수강생 조회  ///고쳐야됨
	public List<Map<String, Object>> getclsMemList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getTchClassList() 호출");
		List<Map<String, Object>> clsMemList = null;
		clsMemList = sqlSession.selectList("getclsMemList_and", pMap);
		logger.info("clsMemList.size() : " + clsMemList.size());
		return clsMemList;
	}
	//회원 paylist 구하기
	public List<Map<String, Object>> getMemPayList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getMemPayList() 호출");
		List<Map<String, Object>> memPayList = null;
		memPayList = sqlSession.selectList("getMemPayList_and", pMap);
		logger.info("memPayList.size() : " + memPayList.size());
		return memPayList;
	}
	//주변 검색에 사용할 gymList 구하기
	public List<Map<String, Object>> getGymList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getGymList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getGymList_and", pMap);
		logger.info("gymList.size() : " + gymList.size());
		return gymList;
	}
	
	
// 김승현
	
// 박준규
	
// 김현빈
	
// 허준호
	// 매장 기준 콘텐츠 조회
	public List<Map<String, Object>> getGymContentsList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getGymContentsList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getGymContentsList", pMap);
		logger.info("getGymContentsList.size() : " + gymList.size());
		try {
			for(Map<String, Object> map : gymList) {
				byte[] image = null;
				Blob blob = (Blob)map.get("FILEDATA");
				image = blob.getBytes(1, (int)blob.length());
				logger.info("image " + image.length);
				map.remove("FILEDATA");
				map.put("FILEDATA", image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gymList;
	}
	// 매장 기준 강사 조회
	public List<Map<String, Object>> getGymTeacherList(Map<String, Object> pMap)  throws SQLException {
		logger.info("AndroidDao - getGymTeacherList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getGymTeacherList", pMap);
		logger.info("getGymTeacherList.size() : " + gymList.size());
		for(Map<String, Object> map : gymList) {
			byte[] image = null;
			Blob blob = (Blob)map.get("FILEDATA");
			image = blob.getBytes(1, (int)blob.length());
			logger.info("image " + image.length);
			map.remove("FILEDATA");
			map.put("FILEDATA", image);
		}
		return gymList;
	}
	// 매장 기준 수업 조회
	public List<Map<String, Object>> getGymClassList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getGymClassList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getGymClassList", pMap);
		logger.info("getGymClassList.size() : " + gymList.size());
		return gymList;
	}
	// 매장 기준 후기 조회 
	public List<Map<String, Object>> getGymReviewList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getGymReviewList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getGymReviewList", pMap);
		logger.info("getGymReviewList.size() : " + gymList.size());
		return gymList;
	}
	
	
}
