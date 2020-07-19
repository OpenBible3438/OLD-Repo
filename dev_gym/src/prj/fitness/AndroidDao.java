package prj.fitness;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;

import oracle.sql.BLOB;

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
	//안드로이드 회원 로그인
	public List<Map<String, Object>> getMemberLogin(Map<String, Object> pMap) throws SQLException{
		logger.info("AndroidDao - getMemberLogin() 호출");
		List<Map<String, Object>> loginResult = null;
		//loginResult = sqlSession.selectList("getMemberLogin", pMap);
		sqlSession.selectOne("getProcMemLogin",pMap);
		loginResult = (List<Map<String, Object>>)pMap.get("memLogin");
		logger.info("==Member Login result : "+loginResult.size()+"row==");
		return loginResult;
	}
	//안드로이드 강사 로그인
	public List<Map<String, Object>> getTeacherLogin(Map<String, Object> pMap) throws SQLException{
		logger.info("AndroidDao - getTeacherLogin() 호출");
		List<Map<String, Object>> loginResult = null;
		sqlSession.selectOne("getProcTchLogin",pMap);
		loginResult = (List<Map<String, Object>>)pMap.get("tchLogin");
		logger.info("==Teacher Login result : "+loginResult.size()+"row==");
		return loginResult;
	}
	// 회원가입 회원 번호 채번 
	public int memberJoinGetNo(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidDao - memberJoinGetNo() 호출");
		result = sqlSession.selectOne("memberJoinGetNo", pMap);
		logger.info("회원번호:"+result);
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
	// 매장 공지사항 조회
	public List<Map<String, Object>> getGymNoticeList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getGymNoticeList() 호출");
		List<Map<String, Object>> gymNoticeList = null;
		gymNoticeList = sqlSession.selectList("getNoticeListApp", pMap);
		logger.info("gymNoticeList.size() : " + gymNoticeList.size());
		return gymNoticeList;
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
	//수업별 수강생 조회  ///고쳐야됨 ///고침
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
//		for(Map<String, Object> map : gymList) {
//			byte[] image = null;
//			Blob blob = (Blob)map.get("FILEDATA");
//			image = blob.getBytes(1, (int)blob.length());
//			logger.info("image " + image.length);
//			map.remove("FILEDATA");
//			map.put("filedata", image);
//			image = null;
//		}
		logger.info("gymList.size() : " + gymList.size());
		return gymList;
	}
//	//이미지 한 장 구하기
//	public List<Map<String, Object>> getImageOne(Map<String, Object> pMap) throws SQLException  {
//		logger.info("AndroidDao - getGymList() 호출");
//		List<Map<String, Object>> imageData = null;
//		imageData = sqlSession.selectList("getImageOne_and", pMap);
//		logger.info("imageData : " + imageData);
//		return imageData;
//	}
	//강사 요일별 수업 구하기
	public List<Map<String, Object>> getTchWeekCls(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getTchWeekCls() 호출");
		List<Map<String, Object>> tchClsList = null;
		tchClsList = sqlSession.selectList("getTchWeekCls_and", pMap);
		logger.info("tchClsList.size() : " + tchClsList.size());
		return tchClsList;
	}
	//회원 요일별 수업 구하기
	public List<Map<String, Object>> getMemWeekCls(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getMemWeekCls() 호출");
		List<Map<String, Object>> memClsList = null;
		memClsList = sqlSession.selectList("getMemWeekCls_and", pMap);
		logger.info("memClsList.size() : " + memClsList.size());
		return memClsList;
	}
	//매장 메인화면 - 매장 정보 조회하기
	public List<Map<String, Object>> getGymProfile(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getGymProfile() 호출");
		List<Map<String, Object>> gymProfileData = null;
		gymProfileData = sqlSession.selectList("getGymProfile_and", pMap);
		logger.info("getGymContentsList.size() : " + gymProfileData.size());
//		try {
//			byte[] image = null;
//			Blob blob = (Blob)gymProfileData.get(0).get("FILEDATA");
//			image = blob.getBytes(1, (int)blob.length());
//			logger.info("image " + image.length);
//			gymProfileData.get(0).remove("FILEDATA");
//			gymProfileData.get(0).put("FILEDATA", image);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		logger.info("imageData : " + gymProfileData);
		return gymProfileData;
	}
	//회원 요일별 수업 구하기
	public List<Map<String, Object>> getMyClass(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getMyClass() 호출");
		List<Map<String, Object>> myClassList = null;
		myClassList = sqlSession.selectList("getMyClassList_and", pMap);
		logger.info("myClassList.size() : " + myClassList.size());
		return myClassList;
	}
	//매장 - 강사진 리스트 가져오기 
	public List<Map<String, Object>> getTchList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getTchList() 호출");
		List<Map<String, Object>> tchList = null;
		tchList = sqlSession.selectList("getTchList_and", pMap);
		logger.info("tchList.size() : " + tchList.size());
		return tchList;
	}
	//매장 - 수업 - 자세히 보기 
	public List<Map<String, Object>> getClsDetail(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getClsDetail() 호출");
		List<Map<String, Object>> dtlList = null;
		dtlList = sqlSession.selectList("getClsDetail_and", pMap);
		logger.info("dtlList.size() : " + dtlList.size());
		return dtlList;
	}
	//회원이 듣는 수업들의 강사 구하기(메시지에 사용)
	public List<Map<String, Object>> getMemTchList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getMemTchList() 호출");
		List<Map<String, Object>> memTchList = null;
		memTchList = sqlSession.selectList("getMemTchList_and", pMap);
		logger.info("memTchList.size() : " + memTchList.size());
		return memTchList;
	}
	//강사의 전체 회원 리스트(메시지에 사용) 성경추가
	public List<Map<String, Object>> getTchChatMemList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getTchChatMemList() 호출");
		List<Map<String, Object>> tchMemList = null;
		tchMemList = sqlSession.selectList("getTchChatMemList", pMap);
		logger.info("memTchList.size() : " + tchMemList.size());
		return tchMemList;
	}
	// 전체 콘텐츠 가져오기  
		public List<Map<String, Object>> getContentsList(Map<String, Object> pMap) {
			logger.info("AndroidDao - getContentsList() 호출");
			List<Map<String, Object>> gymList = null;
			gymList = sqlSession.selectList("getContentsList_and", pMap);
			logger.info("getContentsList.size() : " + gymList.size());
			return gymList;
		}
		//강사가 수업하고 있는 매장 구하기
		public List<Map<String, Object>> getTchGymList(Map<String, Object> pMap) throws SQLException  {
			logger.info("AndroidDao - getTchGymList() 호출");
			List<Map<String, Object>> tchGymList = null;
			tchGymList = sqlSession.selectList("getTchGymList_and", pMap);
			logger.info("tchGymList.size() : " + tchGymList.size());
			return tchGymList;
		}	
	
// 김승현
	
// 박준규
	// 회원 리뷰 등록
	public int memReviewIns(Map<String, Object> pMap) {
		logger.info("AndroidDao - memReviewIns() 호출");
		result = sqlSession.insert("memReviewIns",pMap);
		return result;
	}
	public List<Map<String, Object>> getMemReview(Map<String, Object> pMap) {
		logger.info("AndroidDao - getMemReview() 호출");
		List<Map<String, Object>> revList = null;
		revList = sqlSession.selectList("getMemReview", pMap);
		logger.info("getMemReview.size() : " + revList.size());
		return revList;
	}

// 김현빈
	
// 허준호
	// 매장 기준 콘텐츠 조회
	public List<Map<String, Object>> getGymContentsList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidDao - getGymContentsList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getGymContentsList", pMap);
		logger.info("getGymContentsList.size() : " + gymList.size());
		return gymList;
	}
	// 매장 기준 강사 조회
	public List<Map<String, Object>> getGymTeacherList(Map<String, Object> pMap)  throws SQLException {
		logger.info("AndroidDao - getGymTeacherList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getGymTeacherList", pMap);
		logger.info("getGymTeacherList.size() : " + gymList.size());
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
	// 강사> 수업/회원관리 > 수업리스트 > 수강생 보기> 인바디(그 회원에 대한) 
	public List<Map<String, Object>> getTchClsMemIbd(Map<String, Object> pMap) {
		logger.info("AndroidDao - getTchClsMemIbd() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getTchClsMemIbd", pMap);
		logger.info("getTchClsMemIbd.size() : " + gymList.size());
		return gymList;
	}
	// 강사 프로필 가져오기   
	public List<Map<String, Object>> getTeacherProf(Map<String, Object> pMap) {
		logger.info("AndroidDao - getTeacherProf() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getTeacherProf", pMap);
		logger.info("getTeacherProf.size() : " + gymList.size());
		return gymList;
	}
	// 회원 > 내정보 > 후기 리스트  
	public List<Map<String, Object>> getRevMemList(Map<String, Object> pMap) {
		logger.info("AndroidDao - getRevMemList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getRevMemList_and", pMap);
		logger.info("getRevMemList.size() : " + gymList.size());
		return gymList;
	}
	// 회원 > 내정보 > 후기 리스트 > 등록 수업리스트   
	public List<Map<String, Object>> getRevClsList(Map<String, Object> pMap) {
		logger.info("AndroidDao - getRevClsList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = sqlSession.selectList("getRevClsList_and", pMap);
		logger.info("getRevClsList.size() : " + gymList.size());
		return gymList;
	}
	// 강사 출석 조회
	public List<Map<String, Object>> getTeacherAttend(Map<String, Object> pMap) {
		logger.info("AndroidDao - getTeacherAttend() 호출");
		List<Map<String, Object>> atdList = null;
		atdList = sqlSession.selectList("getTeacherAttend", pMap);
		logger.info("getTeacherAttend.size() : " + atdList.size());
		return atdList;
	}
	// 회원 출석 조회
	public List<Map<String, Object>> getMemberAttend(Map<String, Object> pMap) {
		logger.info("AndroidDao - getMemberAttend() 호출");
		List<Map<String, Object>> atdList = null;
		atdList = sqlSession.selectList("getMemberAttend", pMap);
		logger.info("getMemberAttend.size() : " + atdList.size());
		return atdList;
	}
	
	// 회원이 콘텐츠에 좋아요 눌렀을 때1-1
	public int contLikeINS(Map<String, Object> pMap) {
		logger.info("AndroidDao - contLikeINS() 호출");
		result = sqlSession.insert("contLikeINS", pMap);
		return result;
	}
	// 회원이 콘텐츠에 좋아요 눌렀을 때1-2
	public int contLikeInsUPD(Map<String, Object> pMap) {
		logger.info("AndroidDao - contLikeInsUPD() 호출");
		result = sqlSession.update("contLikeInsUPD", pMap);
		return result;
	}
	// 회원이 콘텐츠에 좋아요 뺐을 때1-1
	public int contLikeDEL(Map<String, Object> pMap) {
		logger.info("AndroidDao - contLikeDEL() 호출");
		result = sqlSession.delete("contLikeDEL", pMap);
		return result;
	}
	// 회원이 콘텐츠에 좋아요 뺐을 때1-2
	public int contLikeDelUPD(Map<String, Object> pMap) {
		logger.info("AndroidDao - contLikeDelUPD() 호출");
		result = sqlSession.update("contLikeDelUPD", pMap);
		return result;
	}
	public BLOB getImg(Map<String, Object> pMap) {
		logger.info("GymDao - getImg() 호출");
		BLOB blob = sqlSession.selectOne("getImg", pMap);
		return blob;
	}
}
