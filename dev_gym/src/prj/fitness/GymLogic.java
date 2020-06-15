package prj.fitness;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class GymLogic {

	Logger logger = Logger.getLogger(GymLogic.class);
	GymDao gDao = null;
	int result = 0;
	
	public GymLogic() {
		logger.info("GymLogic 생성자 호출");
		this.gDao = new GymDao();
	}
//////////////////////////////////////////////////////////
	public Map<String, Object> getClassDetail(Map<String, Object> pMap) {
		logger.info("GymLogic - getClassDetail() 호출");
		Map<String, Object> detailMap = null;
		
		return detailMap;
	}

	public List<Map<String, Object>> getClassList(Map<String, Object> pMap) {
		logger.info("GymLogic - getClassList() 호출");
		List<Map<String, Object>> classList = null;
		
		return classList;
	}
	
	public List<Map<String, Object>> getClassMemList(Map<String, Object> pMap) {//수강생 조회
		logger.info("GymLogic - getClassMemList() 호출");
		List<Map<String, Object>> classMemList = null;
		classMemList = gDao.getClassMemList(pMap);
		return classMemList;
	}

	public List<Map<String, Object>> getGymChart(Map<String, Object> pMap) {////////////chart 다시 생각해보기(한 페이지에 차트를 여러 개 나타낼 거니까)
		logger.info("GymLogic - getGymChart() 호출");
		List<Map<String, Object>> chartList = null;
		
		return chartList;
	}
	
	public List<Map<String, Object>> getGymContent(Map<String, Object> pMap) {
		logger.info("GymLogic - getGymContent() 호출");
		List<Map<String, Object>> contentList = null;
		
		return contentList;
	}
	
	public List<Map<String, Object>> getGymMain(Map<String, Object> pMap) {
		logger.info("GymLogic - getGymMain() 호출");
		List<Map<String, Object>> infoList = null;
		
		return infoList;
	}
	
	public List<Map<String, Object>> getGymNotice(Map<String, Object> pMap) {
		logger.info("GymLogic - getGymNotice() 호출");
		List<Map<String, Object>> noticeList = null;
		
		return noticeList;
	}
	
	public List<Map<String, Object>> getGymReview(Map<String, Object> pMap) {
		logger.info("GymLogic - getGymReview() 호출");
		List<Map<String, Object>> reviewList = null;
		
		return reviewList;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//	응답페이지는 SELECT 하는 페이지. 그 페이지에 가기 전에 INS, UPD, DEL 중 어떤 업무를 할 것인지는 cud로 구분
	
	public int classIns(Map<String, Object> pMap) {
		logger.info("GymLogic - classIns() 호출");
		result = gDao.classIns(pMap);
		return result;
	}
	
	public int classUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - classUpd() 호출");
		result = gDao.classUpd(pMap);
		return result;
	}
	
	public int classDel(Map<String, Object> pMap) {
		logger.info("GymLogic - classDel() 호출");
		result = gDao.classDel(pMap);
		return result;
	}
	
	public int classMemIns(Map<String, Object> pMap) {
		logger.info("GymLogic - classMemIns() 호출");
		result = gDao.classMemIns(pMap);
		return result;
	}
	
	public int classMemUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - classMemUpd() 호출");
		result = gDao.classMemUpd(pMap);
		return result;
	}	
	
	public int classMemDel(Map<String, Object> pMap) {
		logger.info("GymLogic - classMemDel() 호출");
		result = gDao.classMemDel(pMap);
		return result;
	}	
	
	public int contentIns(Map<String, Object> pMap) {
		logger.info("GymLogic - contentIns() 호출");
		result = gDao.contentIns(pMap);
		return result;
	}
	
	public int contentUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - contentUpd() 호출");
		result = gDao.contentUpd(pMap);
		return result;
	}
	
	public int contentDel(Map<String, Object> pMap) {
		logger.info("GymLogic - contentDel() 호출");
		result = gDao.contentDel(pMap);
		return result;
	}
	
	public int gymInfoUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - gymInfoUpd() 호출");
		result = gDao.gymInfoUpd(pMap);
		return result;
	}
	
	public int gymNoticeIns(Map<String, Object> pMap) {
		logger.info("GymLogic - gymNoticeIns() 호출");
		result = gDao.gymNoticeIns(pMap);
		return result;
	}
	
	public int gymNoticeUpd(Map<String, Object> pMap) {
		logger.info("GymLogic - gymNoticeUpd() 호출");
		result = gDao.gymNoticeUpd(pMap);
		return result;
	}
	

}
