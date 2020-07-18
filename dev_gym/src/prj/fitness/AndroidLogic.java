package prj.fitness;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.util.MyBatisBuilderMgr;

import oracle.sql.BLOB;

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
	public List<Map<String, Object>> getMemberLogin(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getMemberLogin() 호출 ");
		List<Map<String, Object>> loginResult = null;
		loginResult = aDao.getMemberLogin(pMap);
		mbMgr.clossSession(sqlSession);
		
		return loginResult;
	}
	//강사 로그인
	public List<Map<String, Object>> getTeacherLogin(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getTeacherLogin() 호출 ");
		List<Map<String, Object>> loginResult = null;
		loginResult = aDao.getTeacherLogin(pMap);
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
	// 매장 공지사항 조회
	public Object getGymNoticeList(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getGymNoticeList() 호출 ");
		List<Map<String, Object>> gymNoticeList = null;
		gymNoticeList = aDao.getGymNoticeList(pMap);
		return gymNoticeList;
	}
// 김혜림
	//강사별 수업 조회
	public Object getTchClassList(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getTchClassList() 호출 ");
		List<Map<String, Object>> classList = null;
		classList = aDao.getTchClassList(pMap);
		return classList;
	}
	//수업별 수강생 조회 ///고쳐야됨
	public Object getclsMemList(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getclsMemList() 호출 ");
		List<Map<String, Object>> clsMemList = null;
		clsMemList = aDao.getclsMemList(pMap);
		return clsMemList;
	}
	//회원 paylist 구하기
	public List<Map<String, Object>> getMemPayList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getMemPayList() 호출");
		List<Map<String, Object>> memPayList = null;
		memPayList = aDao.getMemPayList(pMap);
		return memPayList;
	}
	//주변 검색에 사용할 gymList 구하기
	public List<Map<String, Object>> getGymList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getGymList() 호출");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getGymList(pMap);
		return gymList;
	}
	//이미지 한 장 구하기
	public List<Map<String, Object>> getImageOne(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getImageOne() 호출");
		List<Map<String, Object>> imageData = null;
		imageData = aDao.getImageOne(pMap);
		
		return imageData;
	}
	//회원 요일별 수업 구하기
	public List<Map<String, Object>> getMemWeekCls(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getMemWeekCls() 호출");
		List<Map<String, Object>> memClsList = null;
		memClsList = aDao.getMemWeekCls(pMap);
		
		return memClsList;
	}
	//매장 메인화면 - 매장 정보 조회하기
	public List<Map<String, Object>> getGymProfile(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getGymProfile() 호출");
		List<Map<String, Object>> gymProfileData = null;
		gymProfileData = aDao.getGymProfile(pMap);
		return gymProfileData;
	}
	//매장 - 강사진 리스트 가져오기 
	public List<Map<String, Object>> getTchList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getTchList() 호출");
		List<Map<String, Object>> tchList = null;
		tchList = aDao.getTchList(pMap);
		return tchList;
	}
	//회원 - 수업 정보
	public List<Map<String, Object>> getMyClass(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getMyClass() 호출");
		List<Map<String, Object>> myClassList = null;
		myClassList = aDao.getMyClass(pMap);
		return myClassList;
	}
	//매장 - 수업 - 자세히 보기 
	public List<Map<String, Object>> getClsDetail(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getClsDetail() 호출");
		List<Map<String, Object>> dtlList = null;
		dtlList = aDao.getClsDetail(pMap);
		return dtlList;
	}
	//회원이 듣는 수업들의 강사 구하기(메시지에 사용)
	public List<Map<String, Object>> getMemTchList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getMemTchList() 호출");
		List<Map<String, Object>> memTchList = null;
		memTchList = aDao.getMemTchList(pMap);
		logger.info("memTchList.size() : " + memTchList.size());
		return memTchList;
	}	
// 김승현
		
// 박준규
	// 회원 자세히 보기 
	public List<Map<String, Object>> getMemDetail(Map<String, Object> pMap) throws SQLException {//여유가 되면 Map으로 바꾸자
		logger.info("MemLogic - getMemDetail() 호출"+pMap.get("mem_no"));
		List<Map<String, Object>> memDetail = null;
		memDetail = aDao.getMemDetail(pMap);
		return memDetail;
	}
	// 인바디 전체 조회 
	public List<Map<String, Object>> getMemInbody(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - getMemInbody() 호출");
		List<Map<String, Object>> memInbodyList = null;
		memInbodyList = aDao.getMemInbody(pMap);
		return memInbodyList;
	}
	// 인바디 조건 검색 
	public Object getMemInbodyOne(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - getMemInbodyOne() 호출");
		List<Map<String, Object>> memInbodyList = null;
		memInbodyList = aDao.getMemInbodyOne(pMap);
		return memInbodyList;
	}
	// 한 회원에 대한 인바디 이미지 불러오기 
	public List<Map<String, Object>> getInbodyImg(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - getMemInbody() 호출");
		List<Map<String, Object>> inbodyList = null;
		inbodyList = aDao.getInbodyImg(pMap);
		mbMgr.clossSession(sqlSession);
		return inbodyList;
	}
	// 한 회원에 대한 등록한 수업 조회 
	public List<Map<String, Object>> getOneMemClsList(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - getMemInbody() 호출");
		List<Map<String, Object>> classList = null;
		classList = aDao.getOneMemClsList(pMap);
		mbMgr.clossSession(sqlSession);
		return classList;
	}
	//회원 조회
	public List<Map<String, Object>> getMemList(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - getMemList() 호출");
		List<Map<String, Object>> memList = null;
		memList = aDao.getMemList(pMap);
		return memList;
	}
	// 회원 조건 검색 
	public List<Map<String, Object>> getMemListOne(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - getMemListOne() 호출");
		List<Map<String, Object>> memList = null;
		memList = aDao.getMemListOne(pMap);
		return memList;
	}
	//회원 인바디 등록
	public int memInbodyIns(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - memInbodyIns() 호출");
		result = aDao.memInbodyIns(pMap);
		if(result == 1 && pMap.get("filename")!=null) {
			result = aDao.memInbodyImgIns(pMap);
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
	public int memInbodyUpd(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - memInbodyUpd() 호출");
		result = aDao.memInbodyUpd(pMap);
		setCommit(result);
		return result;
	}
	public int memInbodyDel(Map<String, Object> pMap) throws SQLException {
		logger.info("MemLogic - memInbodyDel() 호출");
		result = aDao.memInbodyDel(pMap);
		if(result == 1) {		
			result = aDao.memInbodyImgDel(pMap);
		}
		setCommit(result);
		return result;
	}
// 김현빈
		
// 허준호
	// 매장 기준 콘텐츠 조회
	public List<Map<String, Object>> getGymContentsList(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getGymContentsList() 호출 ");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getGymContentsList(pMap);
		return gymList;
	}
	// 매장 기준 강사 조회
	public List<Map<String, Object>> getGymTeacherList(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getGymContentsList() 호출 ");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getGymTeacherList(pMap);
		return gymList;
	}
	// 매장 기중 수업 조회
	public List<Map<String, Object>> getGymClassList(Map<String, Object> pMap) throws SQLException  {
		logger.info("AndroidLogic - getGymContentsList() 호출 ");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getGymClassList(pMap);
		return gymList;
	}
	// 매장 기준 후기 조회 
	public List<Map<String, Object>> getGymReviewList(Map<String, Object> pMap) throws SQLException {
		logger.info("AndroidLogic - getGymReviewList() 호출 ");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getGymReviewList(pMap);
		return gymList;
	}
	// 강사> 수업/회원관리 > 수업리스트 > 수강생 보기> 인바디(그 회원에 대한) 
	public List<Map<String, Object>> getTchClsMemIbd(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getTchClsMemIbd() 호출 ");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getTchClsMemIbd(pMap);
		return gymList;
	}
	// 전체 콘텐츠 가져오기  
	public List<Map<String, Object>> getContentsList(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getContentsList() 호출 ");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getContentsList(pMap);
		return gymList;
	}
	// 강사 프로필 가져오기   
	public List<Map<String, Object>> getTeacherProf(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getTeacherProf() 호출 ");
		List<Map<String, Object>> gymList = null;
		gymList = aDao.getTeacherProf(pMap);
		return gymList;
	}
	// 회원 > 내정보 > 후기 리스트  
	public List<Map<String, Object>> getRevMemList(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getRevMemList() 호출 ");
		List<Map<String, Object>> revList = null;
		revList = aDao.getRevMemList(pMap);
		return revList;
	}
	// 회원 > 내정보 > 후기 리스트 > 등록 수업리스트    
	public List<Map<String, Object>> getRevClsList(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getRevClsList() 호출 ");
		List<Map<String, Object>> revList = null;
		revList = aDao.getRevClsList(pMap);
		return revList;
	}
	//강사 출결 
	public List<Map<String, Object>> getTeacherAttend(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getTeacherAttend() 호출 ");
		List<Map<String, Object>> atdList = null;
		atdList = aDao.getTeacherAttend(pMap);
		return atdList;
	}
	//회원 출결 
	public List<Map<String, Object>> getMemberAttend(Map<String, Object> pMap) {
		logger.info("AndroidLogic - getMemberAttend() 호출 ");
		List<Map<String, Object>> atdList = null;
		atdList = aDao.getMemberAttend(pMap);
		return atdList;
	}
	//준호 insert////////////////////////////////
	// 회원이 콘텐츠에 좋아요 눌렀을 때 
	public int contLikeINS(Map<String, Object> pMap) {
		logger.info("AndroidLogic - contLikeINS() 호출 ");
		result = aDao.contLikeINS(pMap);
		if(result == 1) {
			result = aDao.contLikeInsUPD(pMap);
		}
		setCommit(result);
		return result;
	}
	// 회원이 콘텐츠에 좋아요 뺐을 때
	public int contLikeDEL(Map<String, Object> pMap) {
		logger.info("AndroidLogic - contLikeDEL() 호출 ");
		result = aDao.contLikeDEL(pMap);
		if(result == 1) {
			result = aDao.contLikeDelUPD(pMap);
		}
		setCommit(result);
		return result;
	}
	
	public BLOB getImg(Map<String, Object> pMap) {
		logger.info("GymLogic - getImg() 호출");
		BLOB blob = null;
		blob = aDao.getImg(pMap);
		mbMgr.clossSession(sqlSession);
		return blob;
	}

	
// setCommit
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
