package prj.fitness;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;

import oracle.sql.BLOB;

public class GymDao {

	Logger logger = Logger.getLogger(GymDao.class);
	
	int result = 0;
	SqlSession sqlSession = null;
	MyBatisBuilderMgr mbMgr = null;
	
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
	
	//수강생 조회
	public List<Map<String, Object>> getClassMemList(Map<String, Object> pMap) {
		logger.info("GymDao - getClassMemList() 호출");
		List<Map<String, Object>> classMemList = null;
		classMemList = sqlSession.selectList("getClassMemList", pMap);
		logger.info("classMemList.size() : " + classMemList.size());
		return classMemList;
	}
	public List<Map<String, Object>> getPayMemList(Map<String, Object> pMap) {
		logger.info("GymDao - getPayMemList() 호출");
		List<Map<String, Object>> PayMemList = null;
		PayMemList = sqlSession.selectList("getPayMemList", pMap);
		logger.info("getPayMemList.size() : " + PayMemList.size());
		return PayMemList;
	}
	
	//수업 자세히보기
	public List<Map<String, Object>> getClassDetail(Map<String, Object> pMap) {
		logger.info("GymDao - getClassDetail() 호출");
		List<Map<String, Object>> classDetail = null;
		classDetail = sqlSession.selectList("getClassDetail", pMap);
		logger.info("classDetail.size() : " + classDetail.size());
		return classDetail;
	}
	
	//수업 목록 조회
	public List<Map<String, Object>> getClassList(Map<String, Object> pMap) {
		logger.info("GymDao - getClassList() 호출");
		List<Map<String, Object>> classList = null;
		classList = sqlSession.selectList("getClassList", pMap);
		logger.info("classList.size() : " + classList.size());
		return classList;
	}
	public List<Map<String, Object>> getTypeNo(Map<String, Object> pMap) {
		logger.info("GymDao - getTypeNo() 호출");
		List<Map<String, Object>> typeNo = null;
		typeNo = sqlSession.selectList("getTypeNo", pMap);
		logger.info("classList.size() : " + typeNo.size());
		return typeNo;
	}
	public List<Map<String, Object>> getComboList(Map<String, Object> pMap) {
		logger.info("GymDao - getComboList() 호출");
		List<Map<String, Object>> comboList = null;
		comboList = sqlSession.selectList("getComboList", pMap);
		logger.info("classList.size() : " + comboList.size());
		return comboList;
	}

	public List<Map<String, Object>> getNoticeList(Map<String, Object> pMap) {
		logger.info("GymDao - getNoticeList() 호출");
		List<Map<String, Object>> noticeList = null;
		noticeList = sqlSession.selectList("getNoticeList", pMap);
		logger.info("noticeList.size() : " + noticeList.size());
		return noticeList;
	}
	
	public List<Map<String, Object>> get_c_accum_members(Map<String, Object> pMap) {
		logger.info("GymDao - get_c_accum_members() 호출");
		List<Map<String, Object>> accumList = null;
		logger.info("&&&&&" + sqlSession);
		accumList = sqlSession.selectList("get_c_accum_members", pMap);
		logger.info("chartList.size() : " + accumList.size());
		return accumList;
	}
	
	public List<Map<String, Object>> get_c_ex_time_avg(Map<String, Object> pMap) {
		logger.info("GymDao - get_c_ex_time_avg() 호출");
		List<Map<String, Object>> accumList = null;
		accumList = sqlSession.selectList("get_c_ex_time_avg", pMap);
		logger.info("chartList.size() : " + accumList.size());
		return accumList;
	}
	
	public List<Map<String, Object>> get_cnt_mem_extime(Map<String, Object> pMap) {//회원 운동시간
		logger.info("GymDao - get_cnt_mem_extime() 호출");
		List<Map<String, Object>> cntList = null;
		sqlSession.selectList("get_cnt_mem_extime", pMap);
		cntList = (List<Map<String, Object>>)pMap.get("rfc_cnt_mem");
		logger.info("cntList.size() : " + cntList.size());
		return cntList;
	}
	
	public List<Map<String, Object>> get_newmem(Map<String, Object> pMap) {//월별 수강생 증가
		logger.info("GymDao - get_newmem() 호출");
		List<Map<String, Object>> newMemList = null;
		sqlSession.selectList("get_newmem", pMap);
		newMemList = (List<Map<String, Object>>)pMap.get("chart_newmem");
		logger.info("newMemList.size() : " + newMemList.size());
		return newMemList;
	}
	
	public List<Map<String, Object>> get_tchChart(Map<String, Object> pMap) {//강사별 월별 매출
		logger.info("GymDao - get_tchChart() 호출");
		List<Map<String, Object>> tchChartList = null;
		sqlSession.selectList("get_tchChart", pMap);
		tchChartList = (List<Map<String, Object>>)pMap.get("chart_tchChart");
		logger.info("tchChartList.size() : " + tchChartList.size());
		return tchChartList;
	}
	
	public List<Map<String, Object>> get_gym_sale(Map<String, Object> pMap) {//매장 월별 매출
		logger.info("GymDao - get_gym_sale() 호출");
		List<Map<String, Object>> gymSaleList = null;
		sqlSession.selectList("get_gym_sale", pMap);
		gymSaleList = (List<Map<String, Object>>)pMap.get("chart_gym_sale");
		logger.info("gymSaleList.size() : " + gymSaleList.size());
		return gymSaleList;
	}
	
	public List<Map<String, Object>> getContentList(Map<String, Object> pMap) {
		logger.info("GymDao - getContentList() 호출");
		List<Map<String, Object>> contentList = null;
		if(pMap.get("cont_seq") != null) {
			sqlSession.selectOne("getContentListOne", pMap);
		} else {
			sqlSession.selectOne("getContentList", pMap);
		}
		contentList = (List<Map<String, Object>>)pMap.get("gymContList");
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
	// 콘텐츠 등록 
	public int chartIns(Map<String, Object> pMap) {
		logger.info("GymDao - chartIns() 호출");
		result = sqlSession.insert("chartIns", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	// 콘텐츠 이미지 등록 
	public int contentImgIns(Map<String, Object> pMap) {
		logger.info("GymDao - chartIns() 호출");
		result = sqlSession.insert("contentImgIns", pMap);
		logger.info("result : " + result);
		return result;
	}
	// 콘텐츠 수정
	public int chartUpd(Map<String, Object> pMap) {
		logger.info("GymDao - chartUpd() 호출");
		result = sqlSession.update("chartUpd", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	// 콘텐츠 삭제 
	public int chartDel(Map<String, Object> pMap) {
		logger.info("GymDao - contentDel() 호출");
		result = sqlSession.delete("chartDel", pMap);
		logger.info("result : " + result);
		
		return result;
	}
	
	public int contentIns(Map<String, Object> pMap) {
		logger.info("GymDao - contentIns() 호출");
		int gym_cont_seq = sqlSession.selectOne("getContentNo");
		pMap.put("gym_cont_seq", gym_cont_seq);
		result = sqlSession.insert("contentIns", pMap);
		logger.info("result : " + result);

		return result;
	}
	// 매장 콘텐츠 수정 
	public int contentUpd(Map<String, Object> pMap) {
		logger.info("GymDao - contentUpd() 호출");
		result = sqlSession.update("contentUpd", pMap);
		logger.info("result : " + result);

		return result;
	}
	// 매장 콘텐츠 이미지 수정 
	public int contentImgUpd(Map<String, Object> pMap) {
		logger.info("GymDao - contentImgUpd() 호출");
		result = sqlSession.update("contentImgUpd", pMap);
		logger.info("result : " + result);

		return result;
	}
	
	// 매장 콘텐츠 삭제 
	public int contentDel(Map<String, Object> pMap) {
		logger.info("GymDao - contentDel() 호출");
		result = sqlSession.delete("contentDel", pMap);
		logger.info("result : " + result);

		return result;
	}
	// 매장 콘텐츠 이미지 삭제 
	public int contentImgDel(Map<String, Object> pMap) {
		logger.info("GymDao - contentImgDel() 호출");
		result = sqlSession.delete("contentImgDel", pMap);
		logger.info("result : " + result);

		return result;
	}
	// 매장 정보 수정
	public int gymInfoUpd(Map<String, Object> pMap) {
		logger.info("GymDao - gymInfoUpd() 호출");
		result = sqlSession.update("gymInfoUpd", pMap);
		logger.info("result : " + result);

		return result;
	}
	// 매장 정보 이미지 수정 
	public int gymInfoImgUpd(Map<String, Object> pMap) {
		logger.info("GymDao - gymInfoImgUpd() 호출");
		result = sqlSession.update("gymInfoImgUpd", pMap);
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
		int gym_no = sqlSession.selectOne("getGymNo");
		pMap.put("gym_no", gym_no);
		logger.info("gym_no : " + gym_no);
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
