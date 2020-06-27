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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.util.MyBatisBuilderMgr;


public class JsonTest extends HttpServlet {

	Gson g = new Gson();
	JsonObject jo = new JsonObject();

	Logger logger = Logger.getLogger(JsonTest.class);
	int result = 0;
	
	MyBatisBuilderMgr mbMgr = null;
	SqlSession sqlSession = null;
	
	public JsonTest() {
		logger.info("JsonTest 생성자 호출");
		mbMgr = MyBatisBuilderMgr.getInstance();
		sqlSession = mbMgr.openSession();
	}
	
	public void getData(HttpServletRequest req, HttpServletResponse res) {
		logger.info("getData 호출");
		List<Map<Object, String>> dataList = null;
		dataList = sqlSession.selectList("jsonTest");
		
		JsonObject col1 = new JsonObject();
		JsonObject col2 = new JsonObject();
		JsonObject col3 = new JsonObject();
		
		JsonArray cols = new JsonArray();
		
		col1.addProperty("type", "string");
		col1.addProperty("label", "first");
		//첫 번째 컬럼 설정
		
		col2.addProperty("type", "string");
		col2.addProperty("label", "second");
		//두 번째 컬럼 설정
		
		col3.addProperty("type", "string");
		col3.addProperty("label", "third");
		//세 번째 컬럼 설정
		
		cols.add(col1);
		cols.add(col2);
		cols.add(col3);
		
		
		JsonArray rows = new JsonArray();
		
		for(int i=0; i<dataList.size(); i++) {
			JsonObject one = new JsonObject();//map
			JsonObject two = new JsonObject();//map
			JsonObject three = new JsonObject();//map
			one.addProperty("v", dataList.get(i).get("FIRST"));
			one.addProperty("f", "");
				//첫 번째 컬럼 값 채우기
			two.addProperty("v",dataList.get(i).get("SECOND"));
			two.addProperty("f", "");
				//두 번째 컬럼 값 채우기
			three.addProperty("v", dataList.get(i).get("THIRD"));
			three.addProperty("f", "");
				//세 번째 컬럼 값 채우기
			
			JsonArray oneRow = new JsonArray();//list
			oneRow.add(one);
			oneRow.add(two);
			oneRow.add(three);
			//첫 번째 ~ 세 번째 컬럼 합쳐주기
			
			JsonObject row = new JsonObject();//map
			row.add("c", oneRow);// 합친 로우에 "c"라는 값을 주기 위에 map에 담아주기
			
			rows.add(row);//map 형식으로 맞춰준 한 로우를 list에 담아주기
		}
		
		JsonObject data = new JsonObject();
		data.add("cols", cols);
		data.add("rows", rows);
		
		req.setAttribute("data", data);
		RequestDispatcher view = req.getRequestDispatcher("./testResult.jsp");
		try {
			view.forward(req, res);
			
		} catch (Exception e) {
			logger.info("오류 발생");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet() 호출");
		getData(req, res);
	
	}
	
	
}
