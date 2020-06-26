package prj.fitness;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import oracle.sql.BLOB;

public class GymDao {

	Logger logger = Logger.getLogger(GymDao.class);
	
	int result = 0;
	SqlSession sqlSession = null;
	
	public GymDao(SqlSession sqlSession) {
		logger.info("GymDao 생성자 호출");
		this.sqlSession = sqlSession;
	}
	///////////////////////////////////////////////////////////////////////////
	//매장 로그인
	public List<Map<String, Object>> getLogin(Map<String, Object> pMap) {//로그인
		logger.info("GymDao - getLogin() 호출");
		List<Map<String, Object>> loginResult = null;
		//loginResult = sqlSession.selectList("getLogin",pMap);
		sqlSession.selectOne("getProcLogin",pMap);
		loginResult = (List<Map<String, Object>>)pMap.get("gymLogin");
		logger.info(" - loginResult : "+loginResult.size()+"row");
		
		return loginResult;
	}
	//매장 아이디 중복확인
	public int getIdConfirm(Map<String, Object> pMap) {
		logger.info("GymDao - getIdConfirm() 호출");
		int idResult = 0;
		idResult = sqlSession.selectOne("getIdConfirm",pMap);
		return idResult;
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
	public List<Map<String, Object>> getTchNo(Map<String, Object> pMap) {
		logger.info("GymDao - getTchNo() 호출");
		List<Map<String, Object>> classList = null;
		classList = sqlSession.selectList("getTchNo", pMap);
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
		sqlSession.selectList("getContentList", pMap);
		contentList = (List<Map<String, Object>>)pMap.get("gymCont");
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
	//매장 이미지 가져오기 
	public byte[] gymProfImage(Map<String, Object> pMap) {
		logger.info("GymDao - getProfImage() 호출");
		byte[] image = null;
		BLOB blob = sqlSession.selectOne("gymProfImage", pMap);
		try {
			image = blob.getBytes(1, (int)blob.length());
			logger.info("image " + image.length);
			logger.info("image " + image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	//매장 콘텐츠 사진 가져오기
	public List<Map<String, Object>> gymContImage(Map<String, Object> pMap) {
		logger.info("GymDao - gymContImage() 호출");
		List<Map<String, Object>> contList = null;
		contList = sqlSession.selectList("gymContImage", pMap);
		logger.info("contList.size() : " + contList.size());
		return contList;
	}
	
	// 이미지 가져오기 
	public byte[] getImages(Map<String, Object> pMap) {
		logger.info("GymDao - getImages() 호출");
		byte[] image = null;
		BLOB blob = sqlSession.selectOne("getImages", pMap);
		try {
			image = blob.getBytes(1, (int)blob.length());
			logger.info("image " + image.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	
	public int classIns(Map<String, Object> pMap) {
		logger.info("GymDao - classIns() 호출");
		result = sqlSession.insert("classIns", pMap);
		logger.info("result : " + result);
		return result;
	}
	
	public int classUpd(Map<String, Object> pMap) {
		logger.info("GymDao - classUpd() 호출");
		result = sqlSession.update("classUpd", pMap);
		logger.info("result : " + result);
		return result;
	}
	
	public int classDel(Map<String, Object> pMap) {
		logger.info("GymDao - classDel() 호출");
		result = sqlSession.delete("classDel", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	
	public int classMemIns(Map<String, Object> pMap) {
		logger.info("GymDao - classMemIns() 호출");
		result = sqlSession.insert("classMemIns", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	public int classMemUpd(Map<String, Object> pMap) {
		logger.info("GymDao - classMemUpd() 호출");
		result = sqlSession.update("classMemUpd", pMap);
		logger.info("result : " + result);

		return result;
	}	
	
	public int classMemDel(Map<String, Object> pMap) {
		logger.info("GymDao - classMemDel() 호출");
		result = sqlSession.delete("classMemDel", pMap);
		logger.info("result : " + result);
		
		return result;
	}	
	
	public int chartIns(Map<String, Object> pMap) {
		logger.info("GymDao - chartIns() 호출");
		result = sqlSession.insert("chartIns", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	
	public int chartUpd(Map<String, Object> pMap) {
		logger.info("GymDao - chartUpd() 호출");
		result = sqlSession.update("chartUpd", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	
	public int chartDel(Map<String, Object> pMap) {
		logger.info("GymDao - contentDel() 호출");
		result = sqlSession.delete("chartDel", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	
	public int contentIns(Map<String, Object> pMap) {
		logger.info("GymDao - contentIns() 호출");
		result = sqlSession.insert("contentIns", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	public int contentUpd(Map<String, Object> pMap) {
		logger.info("GymDao - contentUpd() 호출");
		result = sqlSession.update("contentUpd", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	public int contentDel(Map<String, Object> pMap) {
		logger.info("GymDao - contentDel() 호출");
		result = sqlSession.delete("contentDel", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	public int gymInfoUpd(Map<String, Object> pMap) {
		logger.info("GymDao - gymInfoUpd() 호출");
		result = sqlSession.update("gymInfoUpd", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	public int gymNoticeIns(Map<String, Object> pMap) {
		logger.info("GymDao - gymNoticeIns() 호출");
		result = sqlSession.insert("gymNoticeIns", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	public int gymNoticeUpd(Map<String, Object> pMap) {
		logger.info("GymDao - gymNoticeUpd() 호출");
		result = sqlSession.update("gymNoticeUpd", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	public int gymNoticeDel(Map<String, Object> pMap) {
		logger.info("GymDao - gymNoticeDel() 호출");
		result = sqlSession.delete("gymNoticeDel", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	// 매장 회원가입 
	public int gymJoin(Map<String, Object> pMap) {
		logger.info("GymDao - gymJoin() 호출");
		result = sqlSession.insert("gymJoin", pMap);
		logger.info("result : " + result);
		return result;
	}
	//매장 이미지 입력
	public int gymJoinImg(Map<String, Object> pMap) {
		logger.info("GymDao - gymJoinImg() 호출");
		result = sqlSession.insert("gymJoinImg", pMap);
		logger.info("result : " + result);
		return result;
	}


}
