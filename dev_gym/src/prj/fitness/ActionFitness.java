package prj.fitness;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.CommonLogic;
import com.util.HashMapBinder;

public class ActionFitness extends HttpServlet {
	
	Logger logger = Logger.getLogger(ActionFitness.class);
	CommonLogic cLogic = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet() 호출");
		doService(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doPost() 호출");
		doService(req, res);
	}
	
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		logger.info("doService() 호출");
		Map<String, Object> pMap = new HashMap<String, Object>(); 
		//pMap을 세팅 binder
		//new HashMapBinder(req).multiBind(pMap);
		new HashMapBinder(req).binder(pMap);

		Controller controller = null;
		
		cLogic = new CommonLogic(req, res);
		cLogic.setCommands(pMap);
		
		controller = ControllerMapper.getController(pMap);
		
		if(pMap.containsKey("cud")) {
			String cud = pMap.get("cud").toString();
			controller.process(cud, req, res);
		}
		else {
			controller.process(req, res);
		}
		
		
		
		
	}
	
}
