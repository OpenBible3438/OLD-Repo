package prj.fitness;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;

import oracle.sql.BLOB;

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
	public List<Map<String, Object>> getLogin(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getLogin() 호출");
		List<Map<String, Object>> loginResult = null;
		loginResult = gDao.getLogin(pMap);
		mbMgr.clossSession(sqlSession);
		
		return loginResult;
	}
	//매장 아이디 중복확인
	public int getIdConfirm(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getIdConfirm() 호출");
		int idResult = 0;
		idResult = gDao.getIdConfirm(pMap);
		mbMgr.clossSession(sqlSession);
		
		return idResult;
	}

	public List<Map<String, Object>> getClassMemList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getClassMemList() 호출");
		List<Map<String, Object>> classMemList = null;
		classMemList = gDao.getClassMemList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return classMemList;
	}
	
	public List<Map<String, Object>> getPayMemList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getPayMemList() 호출");
		List<Map<String, Object>> payMemList = null;
		payMemList = gDao.getPayMemList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return payMemList;
	}
	public List<Map<String, Object>> getClassDetail(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getClassDetail() 호출");
		List<Map<String, Object>> classDetail = null;
		classDetail = gDao.getClassDetail(pMap);
		mbMgr.clossSession(sqlSession);
		
		return classDetail;
	}

	public List<Map<String, Object>> getClassList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getClassList() 호출");
		List<Map<String, Object>> classList = null;
		classList = gDao.getClassList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return classList;
	}
	public List<Map<String, Object>> getTypeNo(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getTypeNo() 호출");
		List<Map<String, Object>> typeNo = null;
		typeNo = gDao.getTypeNo(pMap);
		mbMgr.clossSession(sqlSession);
		
		return typeNo;
	}
	public List<Map<String, Object>> getComboList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getComboList() 호출");
		List<Map<String, Object>> comboList = null;
		comboList = gDao.getComboList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return comboList;
	}
	
	public List<Map<String, Object>> getNoticeList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getNoticeList() 호출");
		List<Map<String, Object>> noticeList = null;
		noticeList = gDao.getNoticeList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return noticeList;
	}

	public List<Map<String, Object>> get_c_accum_members(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - get_c_accum_members() 호출");
		List<Map<String, Object>> chartList = null;
		chartList = gDao.get_c_accum_members(pMap);
		mbMgr.clossSession(sqlSession);
		
		return chartList;
	}
	
	public List<Map<String, Object>> get_c_ex_time_avg(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - get_c_ex_time_avg() 호출");
		List<Map<String, Object>> chartList = null;
		chartList = gDao.get_c_ex_time_avg(pMap);
		mbMgr.clossSession(sqlSession);
		
		return chartList;
	}
	
	public List<Map<String, Object>> get_cnt_mem_extime(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - get_cnt_mem_extime() 호출");
		List<Map<String, Object>> chartList = null;
		chartList = gDao.get_cnt_mem_extime(pMap);
		mbMgr.clossSession(sqlSession);
		
		return chartList;
	}
	
	public List<Map<String, Object>> get_newmem(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - get_newmem() 호출");
		List<Map<String, Object>> chartList = null;
		chartList = gDao.get_newmem(pMap);
		mbMgr.clossSession(sqlSession);
		
		return chartList;
	}
	
	public List<Map<String, Object>> get_tchChart(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - get_tchChart() 호출");
		List<Map<String, Object>> chartList = null;
		chartList = gDao.get_tchChart(pMap);
		
		mbMgr.clossSession(sqlSession);
		
		return chartList;
	}
	
	public List<Map<String, Object>> get_gym_sale(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - get_gym_sale() 호출");
		List<Map<String, Object>> gymSaleList = null;
		gymSaleList = gDao.get_gym_sale(pMap);
		mbMgr.clossSession(sqlSession);
		
		return gymSaleList;
	}
	// 매장 컨테츠 조회
	public List<Map<String, Object>> getContentList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getContentList() 호출");
		List<Map<String, Object>> contentList = null;
		contentList = gDao.getContentList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return contentList;
	}
	
	public List<Map<String, Object>> getInfoList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getInfoList() 호출");
		List<Map<String, Object>> infoList = null;
		infoList = gDao.getInfoList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return infoList;
	}
	
	public List<Map<String, Object>> getReviewList(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getReviewList() 호출");
		List<Map<String, Object>> reviewList = null;
		reviewList = gDao.getReviewList(pMap);
		mbMgr.clossSession(sqlSession);
		
		return reviewList;
	}
	// 매장 프로필 사진 가져오기
	public byte[] gymProfImage(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getProfImage() 호출");
		byte[] image = null;
		image = gDao.gymProfImage(pMap);
		mbMgr.clossSession(sqlSession);
		return image;
	}
	// 매장 콘텐츠 사진 가져오기
	public List<Map<String, Object>> gymContImage(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - gymContImage() 호출");
		List<Map<String, Object>> contList = null;
		contList = gDao.gymContImage(pMap);
		mbMgr.clossSession(sqlSession);
		return contList;
	}
	// 이미지 가져오기
	public byte[] getImages(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - getImages() 호출");
		byte[] image = null;
		image = gDao.getImages(pMap);
		mbMgr.clossSession(sqlSession);
		return image;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//	응답페이지는 SELECT 하는 페이지. 그 페이지에 가기 전에 INS, UPD, DEL 중 어떤 업무를 할 것인지는 cud로 구분
	
	public int classIns(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - classIns() 호출");
		result = gDao.classIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int classUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - classUpd() 호출");
		result = gDao.classUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int classDel(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - classDel() 호출");
		result = gDao.classDel(pMap);
		setCommit(result);
		return result;
	}
	
	public int classMemIns(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - classMemIns() 호출");
		result = gDao.classMemIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int classMemUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - classMemUpd() 호출");
		result = gDao.classMemUpd(pMap);
		setCommit(result);
		return result;
	}	
	
	public int classMemDel(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - classMemDel() 호출");
		result = gDao.classMemDel(pMap);
		setCommit(result);
		return result;
	}	
	
	public int chartIns(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - chartIns() 호출");
		result = gDao.chartIns(pMap);
		setCommit(result);
		return result;
	}
	
	public int chartUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - chartUpd() 호출");
		result = gDao.chartUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int chartDel(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - chartDel() 호출");
		result = gDao.chartDel(pMap);
		setCommit(result);
		return result;
	}
	// 매장 콘텐츠 등록 후 이미지 등록 
	public int contentIns(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - contentIns() 호출");
		result = gDao.contentIns(pMap);
		if(result == 1) {
			result = gDao.contentImgIns(pMap);
			try {
				((FileInputStream)pMap.get("filedata")).close();
				if(((File)pMap.get("file")).delete()) {
					logger.info("파일삭제 성공");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setCommit(result);
		return result;
	}
	// 매장 콘텐츠 수정 후 이미지 수정 
	public int contentUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - contentUpd() 호출");
		result = gDao.contentUpd(pMap);
		if(result == 1) {
			result = gDao.contentImgUpd(pMap);
		}
		setCommit(result);
		return result;
	}
	// 매장 콘텐츠 삭제 후 이미지 삭제 
	public int contentDel(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - contentDel() 호출");
		result = gDao.contentDel(pMap);
		if(result == 1) {
			result = gDao.contentImgDel(pMap);
		}
		setCommit(result);
		return result;
	}
	
	public int gymInfoUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - gymInfoUpd() 호출");
		result = gDao.gymInfoUpd(pMap);
		if(result == 1) {
			result = gDao.gymInfoImgUpd(pMap);
			try {
				((FileInputStream)pMap.get("filedata")).close();
				if(((File)pMap.get("file")).delete()) {
					logger.info("파일삭제 성공");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setCommit(result);
		return result;
	}
	
	public int gymNoticeIns(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - gymNoticeIns() 호출");
		result = gDao.gymNoticeIns(pMap);
		logger.info("result 아래");
		setCommit(result);
		return result;
	}
	
	public int gymNoticeUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - gymNoticeUpd() 호출");
		result = gDao.gymNoticeUpd(pMap);
		setCommit(result);
		return result;
	}
	
	public int gymNoticeDel(Map<String, Object> pMap) throws SQLException {
		logger.info("GymLogic - gymNoticeDel() 호출");
		result = gDao.gymNoticeDel(pMap);
		setCommit(result);
		return result;
	}
	//매장 회원가입
	public int gymJoin(Map<String, Object> pMap) throws SQLException, IOException {
		logger.info("GymLogic - gymJoin() 호출");
		result = gDao.gymJoin(pMap);
		if(result == 1 && pMap.get("filename")!=null) {
			result = gDao.gymJoinImg(pMap);
			if(result == 1) {
				// 디폴드 강사 등록 
				//((FileInputStream)pMap.get("filedata")).close();
				result = gDao.gymJoinTch(pMap);
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
	// Set Commit
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
