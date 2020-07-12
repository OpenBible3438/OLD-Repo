package prj.fitness;

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
// 김혜림
	//강사가 맡은 수업 목록 조회
	public List<Map<String, Object>> getTchClassList(Map<String, Object> pMap) {
		logger.info("AndroidDao - getTchClassList() 호출");
		List<Map<String, Object>> classList = null;
		classList = sqlSession.selectList("getTchClassList_and", pMap);
		logger.info("classList.size() : " + classList.size());
		return classList;
	}
	//수업별 수강생 조회
	public List<Map<String, Object>> getclsMemList(Map<String, Object> pMap) {
		logger.info("AndroidDao - getTchClassList() 호출");
		List<Map<String, Object>> clsMemList = null;
		clsMemList = sqlSession.selectList("getclsMemList_and", pMap);
		logger.info("clsMemList.size() : " + clsMemList.size());
		return clsMemList;
	}
	
	
// 김승현
	
// 박준규
	
// 김현빈
	
// 허준호
	
	
}
