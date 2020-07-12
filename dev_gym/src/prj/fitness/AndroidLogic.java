package prj.fitness;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.util.MyBatisBuilderMgr;

public class AndroidLogic {
	
	Logger logger = Logger.getLogger(AndroidLogic.class);
	AndroidDao aDao = null;
	int result = 0;
	MyBatisBuilderMgr mbMgr = null;
	SqlSession sqlSession = null;
	
	public AndroidLogic() {
		logger.info("AndroidLogic 생성자 호출");
		mbMgr = MyBatisBuilderMgr.getInstance();
		sqlSession = mbMgr.openSession();
		this.aDao = new AndroidDao(sqlSession);
	}
	
// 편성경
	//회원 로그인
	public Object getMemberLogin(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getMemberLogin() 호출 ");
		List<Map<String, Object>> loginResult = null;
		loginResult = aDao.getMemberLogin(pMap);
		mbMgr.clossSession(sqlSession);
		
		return loginResult;
	}
	// 회원 회원가입	
	public int memberJoin(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - memberJoin() 호출 ");
		// 회원 번호 채번 
		result = aDao.memberJoinGetNo(pMap);
		if(result != 0) {
			pMap.put("mem_no", result);
			// 회원 정보 insert
			result = aDao.memberJoinInfo(pMap);
			if(result == 1) {
				// 회원 이미지 insert
				result = aDao.memberJoinImg(pMap);
				try {
					((FileInputStream)pMap.get("filedata")).close();
					if(((File)pMap.get("file")).delete()) {
						logger.info("파일삭제 성공");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		setCommit(result);
		return result;
	}
// 김혜림
	//강사별 수업 조회
	public Object getTchClassList(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getTchClassList() 호출 ");
		List<Map<String, Object>> classList = null;
		classList = aDao.getTchClassList(pMap);
		return classList;
	}
	public Object getclsMemList(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getclsMemList() 호출 ");
		List<Map<String, Object>> clsMemList = null;
		clsMemList = aDao.getclsMemList(pMap);
		return clsMemList;
	}
		
// 김승현
		
// 박준규
		
// 김현빈
		
// 허준호

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
		mbMgr.clossSession(sqlSession);
	}

}
