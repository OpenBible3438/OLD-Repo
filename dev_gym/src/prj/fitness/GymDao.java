package prj.fitness;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class GymDao {

	Logger logger = Logger.getLogger(GymDao.class);
	
	int result = 0;
	SqlSession sqlSession = null;
	
	public GymDao(SqlSession sqlSession) {
		logger.info("GymDao 생성자 호출");
		this.sqlSession = sqlSession;
	}
	///////////////////////////////////////////////////////////////////////////
	
	public List<Map<String, Object>> getLogin(Map<String, Object> pMap) {//로그인
		logger.info("GymDao - getLogin() 호출");
		List<Map<String, Object>> loginResult = null;
		//loginResult = sqlSession.selectList("getLogin",pMap);
		sqlSession.selectOne("getProcLogin",pMap);
		loginResult = (List<Map<String, Object>>)pMap.get("key");
		logger.info(" - loginResult : "+loginResult.size()+"row");
		
		return loginResult;
	}
	
	public List<Map<String, Object>> getClassMemList(Map<String, Object> pMap) {
		logger.info("GymDao - getClassMemList() 호출");
		List<Map<String, Object>> classMemList = null;
		classMemList = sqlSession.selectList("getClassMemList", pMap);
		logger.info("classMemList.size() : " + classMemList.size());
		return classMemList;
	}
	
	public List<Map<String, Object>> getClassDetail(Map<String, Object> pMap) {
		logger.info("GymDao - getClassDetail() 호출");
		List<Map<String, Object>> classDetail = null;
		classDetail = sqlSession.selectList("getClassDetail", pMap);
		logger.info("classDetail.size() : " + classDetail.size());
		return classDetail;
	}
	
	public List<Map<String, Object>> getClassList(Map<String, Object> pMap) {
		logger.info("GymDao - getClassList() 호출");
		List<Map<String, Object>> classList = null;
		classList = sqlSession.selectList("getClassList", pMap);
		logger.info("classList.size() : " + classList.size());
		return classList;
	}

	public List<Map<String, Object>> getNoticeList(Map<String, Object> pMap) {
		logger.info("GymDao - getNoticeList() 호출");
		List<Map<String, Object>> noticeList = null;
		noticeList = sqlSession.selectList("getNoticeList", pMap);
		logger.info("noticeList.size() : " + noticeList.size());
		return noticeList;
	}
	
	public List<Map<String, Object>> getChartList(Map<String, Object> pMap) {////////////chart 다시 생각해보기(한 페이지에 차트를 여러 개 나타낼 거니까)
		logger.info("GymDao - getChartList() 호출");
		List<Map<String, Object>> chartList = null;
		chartList = sqlSession.selectList("getChartList", pMap);
		logger.info("chartList.size() : " + chartList.size());
		return chartList;
	}
	
	public List<Map<String, Object>> getContentList(Map<String, Object> pMap) {
		logger.info("GymDao - getContentList() 호출");
		List<Map<String, Object>> contentList = null;
		contentList = sqlSession.selectList("getContentList", pMap);
		logger.info("contentList.size() : " + contentList.size());
		return contentList;
	}
	
	public List<Map<String, Object>> getInfoList(Map<String, Object> pMap) {
		logger.info("GymDao - getInfoList() 호출");
		List<Map<String, Object>> infoList = null;
		infoList = sqlSession.selectList("getInfoList", pMap);
		logger.info("infoList.size() : " + infoList.size());
		return infoList;
	}
	
	public List<Map<String, Object>> getReviewList(Map<String, Object> pMap) {
		logger.info("GymDao - getReviewList() 호출");
		List<Map<String, Object>> reviewList = null;
		reviewList = sqlSession.selectList("getReviewList", pMap);
		logger.info("reviewList.size() : " + reviewList.size());
		return reviewList;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	
	public int classIns(Map<String, Object> pMap) {
		logger.info("GymDao - classIns() 호출");
		result = sqlSession.insert("classIns");
		logger.info("result : " + result);
		return result;
	}
	
	public int classUpd(Map<String, Object> pMap) {
		logger.info("GymDao - classUpd() 호출");
		result = sqlSession.update("classUpd");
		logger.info("result : " + result);
		return result;
	}
	
	public int classDel(Map<String, Object> pMap) {
		logger.info("GymDao - classDel() 호출");
		result = sqlSession.delete("classDel");
		logger.info("result : " + result);
		
		return result;
	}
	
	public int classMemIns(Map<String, Object> pMap) {
		logger.info("GymDao - classMemIns() 호출");
		result = sqlSession.insert("classMemIns");
		logger.info("result : " + result);

		return result;
	}
	
	public int classMemUpd(Map<String, Object> pMap) {
		logger.info("GymDao - classMemUpd() 호출");
		result = sqlSession.update("classMemUpd");
		logger.info("result : " + result);

		return result;
	}	
	
	public int classMemDel(Map<String, Object> pMap) {
		logger.info("GymDao - classMemDel() 호출");
		result = sqlSession.delete("classMemDel");
		logger.info("result : " + result);
		
		return result;
	}	
	
	public int chartIns(Map<String, Object> pMap) {
		logger.info("GymDao - chartIns() 호출");
		result = sqlSession.insert("chartIns");
		logger.info("result : " + result);
		
		return result;
	}
	
	public int chartUpd(Map<String, Object> pMap) {
		logger.info("GymDao - chartUpd() 호출");
		result = sqlSession.update("chartUpd");
		logger.info("result : " + result);
		
		return result;
	}
	
	public int chartDel(Map<String, Object> pMap) {
		logger.info("GymDao - contentDel() 호출");
		result = sqlSession.delete("chartDel");
		logger.info("result : " + result);
		
		return result;
	}
	
	public int contentIns(Map<String, Object> pMap) {
		logger.info("GymDao - contentIns() 호출");
		result = sqlSession.insert("contentIns");
		logger.info("result : " + result);

		return result;
	}
	
	public int contentUpd(Map<String, Object> pMap) {
		logger.info("GymDao - contentUpd() 호출");
		result = sqlSession.update("contentUpd");
		logger.info("result : " + result);

		return result;
	}
	
	public int contentDel(Map<String, Object> pMap) {
		logger.info("GymDao - contentDel() 호출");
		result = sqlSession.delete("contentDel");
		logger.info("result : " + result);

		return result;
	}
	
	public int gymInfoUpd(Map<String, Object> pMap) {
		logger.info("GymDao - gymInfoUpd() 호출");
		result = sqlSession.update("gymInfoUpd");
		logger.info("result : " + result);

		return result;
	}
	
	public int gymNoticeIns(Map<String, Object> pMap) {
		logger.info("GymDao - gymNoticeIns() 호출");
		result = sqlSession.insert("gymNoticeIns");
		logger.info("result : " + result);

		return result;
	}
	
	public int gymNoticeUpd(Map<String, Object> pMap) {
		logger.info("GymDao - gymNoticeUpd() 호출");
		result = sqlSession.update("gymNoticeUpd");
		logger.info("result : " + result);

		return result;
	}
	
	public int gymNoticeDel(Map<String, Object> pMap) {
		logger.info("GymDao - gymNoticeDel() 호출");
		result = sqlSession.delete("gymNoticeDel");
		logger.info("result : " + result);
		
		return result;
	}
	
	
}
