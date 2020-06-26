package prj.fitness;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;

public class GymLogic {

	Logger logger = Logger.getLogger(GymLogic.class);
	GymDao gDao = null;
	int result = 0;
	
	MyBatisBuilderMgr mbMgr = null;
	SqlSession sqlSession = null;
	
	public GymLogic() {
		logger.info("GymLogic 생성자 호출");
		mbMgr = MyBatisBuilderMgr.getInstance();
		sqlSession = mbMgr.openSession();
		this.gDao = new GymDao(sqlSession);
	}
//////////////////////////////////////////////////////////
	//로그인
	public List<Map<String, Object>> getLogin(Map<String, Object> pMap) {
		logger.info("GymLogic - getLogin() 호출");
		List<Map<String, Object>> loginResult = null;
		loginResult = gDao.getLogin(pMap);
		mbMgr.clossSession(sqlSession);
		
		return loginResult;
	}
	//매장 아이디 중복확인
	public int getIdConfirm(Map<String, Object> pMap) {
		logger.info("GymLogic - getIdConfirm() 호출");
		int idResult = 0;
		idResult = gDao.getIdConfirm(pMap);
		mbMgr.clossSession(sqlSession);
		
		return idResult;
	}
	
	public List<Map<String, Object>> getClassMemList(Map<String, Object> pMap) {//수강생 조회
		logger.info("GymLogic - getClassMemList() 호출");
		List<Map<String, Object>> classMemList = null;
		classMemList = gDao.getClassMemList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return classMemList;
	}
	public List<Map<String, Object>> getClassDetail(Map<String, Object> pMap) {
		logger.info("GymLogic - getClassDetail() 호출");
		List<Map<String, Object>> classDetail = null;
		classDetail = gDao.getClassDetail(pMap);
		mbMgr.clossSession(sqlSession);
		
		return classDetail;
	}

	public List<Map<String, Object>> getClassList(Map<String, Object> pMap) {
		logger.info("GymLogic - getClassList() 호출");
		List<Map<String, Object>> classList = null;
		classList = gDao.getClassList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return classList;
	}
	public List<Map<String, Object>> getTchNo(Map<String, Object> pMap) {
		logger.info("GymLogic - getTchNo() 호출");
		List<Map<String, Object>> classList = null;
		classList = gDao.getTchNo(pMap);
		mbMgr.clossSession(sqlSession);
		
		return classList;
	}
	
	public List<Map<String, Object>> getNoticeList(Map<String, Object> pMap) {
		logger.info("GymLogic - getNoticeList() 호출");
		List<Map<String, Object>> noticeList = null;
		noticeList = gDao.getNoticeList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return noticeList;
	}

	public List<Map<String, Object>> getChartList(Map<String, Object> pMap) {////////////chart 다시 생각해보기(한 페이지에 차트를 여러 개 나타낼 거니까)
		logger.info("GymLogic - getChartList() 호출");
		List<Map<String, Object>> chartList = null;
		chartList = gDao.getChartList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return chartList;
	}
	
	public List<Map<String, Object>> getContentList(Map<String, Object> pMap) {
		logger.info("GymLogic - getContentList() 호출");
		List<Map<String, Object>> contentList = null;
		contentList = gDao.getContentList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return contentList;
	}
	
	public List<Map<String, Object>> getInfoList(Map<String, Object> pMap) {
		logger.info("GymLogic - getInfoList() 호출");
		List<Map<String, Object>> infoList = null;
		infoList = gDao.getInfoList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return infoList;
	}
	
	public List<Map<String, Object>> getReviewList(Map<String, Object> pMap) {
		logger.info("GymLogic - getReviewList() 호출");
		List<Map<String, Object>> reviewList = null;
		reviewList = gDao.getReviewList(pMap);
		
		return reviewList;
	}
	// 매장 프로필 사진 가져오기
	public byte[] gymProfImage(Map<String, Object> pMap) {
		logger.info("GymLogic - getProfImage() 호출");
		byte[] image = null;
		image = gDao.gymProfImage(pMap);
		return image;
	}
	// 매장 콘텐츠 사진 가져오기
	public List<Map<String, Object>> gymContImage(Map<String, Object> pMap) {
		logger.info("GymLogic - gymContImage() 호출");
		List<Map<String, Object>> contList = null;
		contList = gDao.gymContImage(pMap);
		return contList;
	}
	// 이미지 가져오기
	public byte[] getImages(Map<String, Object> pMap) {
		logger.info("GymLogic - getImages() 호출");
		byte[] image = null;
		image = gDao.getImages(pMap);
		return image;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//	응답페이지는 SELECT 하는 페이지. 그 페이지에 가기 전에 INS, UPD, DEL 중 어떤 업무를 할 것인지는 cud로 구분
	
	public int classIns(Map<String, Object> pMap) {
		logger.info("GymLogic - classIns() 호출");
		result = gDao.classIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int classUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - classUpd() 호출");
		result = gDao.classUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int classDel(Map<String, Object> pMap) {
		logger.info("GymLogic - classDel() 호출");
		result = gDao.classDel(pMap);
		setCommit(result);
		return result;
	}
	
	public int classMemIns(Map<String, Object> pMap) {
		logger.info("GymLogic - classMemIns() 호출");
		result = gDao.classMemIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int classMemUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - classMemUpd() 호출");
		result = gDao.classMemUpd(pMap);
		setCommit(result);
		return result;
	}	
	
	public int classMemDel(Map<String, Object> pMap) {
		logger.info("GymLogic - classMemDel() 호출");
		result = gDao.classMemDel(pMap);
		setCommit(result);
		return result;
	}	
	
	public int chartIns(Map<String, Object> pMap) {
		logger.info("GymLogic - chartIns() 호출");
		result = gDao.chartIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int chartUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - chartUpd() 호출");
		result = gDao.chartUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int chartDel(Map<String, Object> pMap) {
		logger.info("GymLogic - chartDel() 호출");
		result = gDao.chartDel(pMap);
		setCommit(result);
		return result;
	}
	
	public int contentIns(Map<String, Object> pMap) {
		logger.info("GymLogic - contentIns() 호출");
		result = gDao.contentIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int contentUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - contentUpd() 호출");
		result = gDao.contentUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int contentDel(Map<String, Object> pMap) {
		logger.info("GymLogic - contentDel() 호출");
		result = gDao.contentDel(pMap);
		setCommit(result);
		return result;
	}
	
	public int gymInfoUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - gymInfoUpd() 호출");
		result = gDao.gymInfoUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int gymNoticeIns(Map<String, Object> pMap) {
		logger.info("GymLogic - gymNoticeIns() 호출");
		result = gDao.gymNoticeIns(pMap);
		logger.info("result 아래");
		setCommit(result);
		return result;
	}
	
	public int gymNoticeUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - gymNoticeUpd() 호출");
		result = gDao.gymNoticeUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int gymNoticeDel(Map<String, Object> pMap) {
		logger.info("GymLogic - gymNoticeDel() 호출");
		result = gDao.gymNoticeDel(pMap);
		setCommit(result);
		return result;
	}
	//매장 회원가입
	public int gymJoin(Map<String, Object> pMap) {
		logger.info("GymLogic - gymJoin() 호출");
		result = gDao.gymJoin(pMap);
		if(result == 1 && pMap.get("filename")!=null) {
			result = gDao.gymJoinImg(pMap);
//			if(result == 1) {
//				try {
//					((FileInputStream)pMap.get("filedata")).close();
//					if(((File)pMap.get("file")).delete()) {
//						logger.info("파일삭제 성공");
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
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
		mbMgr.clossSession(sqlSession);
	}




}
