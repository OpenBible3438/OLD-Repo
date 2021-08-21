package hjho.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class HjhoTest {

	public void setJSON() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		Map<String,Object> rMap = null;
		Map<String,Object> rMap2 = null;
		Map<String,Object> rMap3 = null;
		Map<String,Object> rMap4 = null;
		
		//DB1
		rMap = new HashMap<String, Object>();
		rMap.put("test", "test");
		rMap.put("test2", "test2");
		list.add(rMap);
		rMap = new HashMap<String, Object>();
		rMap.put("test", "test");
		rMap.put("test2", "test2");
		list.add(rMap);

		//DB2
		rMap2 = new HashMap<String, Object>();
		rMap2.put("test", "test");
		rMap2.put("test2", "test2");
		list2.add(rMap);
		rMap2 = new HashMap<String, Object>();
		rMap2.put("test", "test");
		rMap2.put("test2", "test2");
		list2.add(rMap);
		
		//Cell
		rMap3 = new HashMap<String, Object>();
		rMap3.put("c", list); //DB1
		Map<String,Object> rMap5 = new HashMap<String, Object>();
		rMap5.put("c", list2); //DB2
		list3.add(rMap3);
		list3.add(rMap5);
		
		//col, row
		rMap4 = new HashMap<String, Object>();
		rMap4.put("col",list);  //DB1 -> 손수 넣어야하는
		rMap4.put("row",list3); //Cell -> DB값
		
		Gson g = new Gson();
		String temp = g.toJson(rMap4);
		System.out.println(temp);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("허준호 git 테스트 완료");
		HjhoTest tt = new HjhoTest();
		tt.setJSON();
	}
}


