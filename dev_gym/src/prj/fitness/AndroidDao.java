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
	
// 김승현
	
// 박준규
	// 회원 인바디 테이블에 인바디 정보 등록
		public int memInbodyIns(Map<String, Object> pMap) throws SQLException {
			logger.info("MemDao - memInbodyIns() 호출");
			int inbd_seq = sqlSession.selectOne("getInbodySeq");
			pMap.put("inbd_seq", inbd_seq);
			result = sqlSession.insert("memInbodyIns",pMap);
			
			return result;
		}
// 김현빈
	
// 허준호
	
	
}
