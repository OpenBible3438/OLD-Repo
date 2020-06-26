package hjho.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.util.MyBatisBuilderMgr;
import com.util.SetData;

public class JsonTest_SetChart extends HttpServlet {

	Logger logger = Logger.getLogger(JsonTest.class);
	int result = 0;
	
	MyBatisBuilderMgr mbMgr = null;
	SqlSession sqlSession = null;
	
	public JsonTest_SetChart() {
		logger.info("JsonTest_SetChart 생성자 호출");
		mbMgr = MyBatisBuilderMgr.getInstance();
		sqlSession = mbMgr.openSession();
	}
	
	public void getData(HttpServletRequest req, HttpServletResponse res) {
		logger.info("getData 호출");
		List<Map<String, Object>> dataList = null;
		dataList = sqlSession.selectList("jsonTest");
		logger.info("dataList.size() : " + dataList.size());
		String data = null;
		SetData sc = new SetData();
		data = sc.dataToJson(dataList, "DAY");
		req.setAttribute("data", data);
		
		RequestDispatcher view = req.getRequestDispatcher("./jsonTestSetChart.jsp");
		try {
			logger.info("try문 들어옴");
			view.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("오류 발생");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet() 호출");
		getData(req, res);
	
	}
	

}
