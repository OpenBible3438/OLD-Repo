package prj.fitness;

import java.util.Map;

public class ControllerMapper {

	public static Controller getController(Map<String, Object> pMap) {
		Controller controller = null;
		String work = pMap.get("work").toString();
		String reqName = pMap.get("reqName").toString();
		switch(work) {
			case "main": case "gym": case "class":{
				controller = new GymController(pMap);
			}break;
			case "member":{
				controller = new MemController(pMap);
			}break;
			case "teacher":{
				controller = new TchController(pMap);
			}break;
		}
		return controller;
	}
}
