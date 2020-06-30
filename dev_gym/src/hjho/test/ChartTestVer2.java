package hjho.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartTestVer2 {

	public void setData() {
		System.out.println("Ver1");
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();

		map1.put("1", "1-1");
		map1.put("2", "2-1");
		map1.put("3", "3-1");

		map2.put("1", "1-2");
		map2.put("2", "2-2");
		map2.put("3", "3-2");

		map3.put("1", "1-3");
		map3.put("2", "2-3");
		map3.put("3", "3-3");

		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);

		System.out.println(list);
		System.out.println("Ver2");
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();

		list1.add(0, "1월");
		list1.add(1, "1-1");
		list1.add(2, "2-1");
		list1.add(3, "3-1");

		list2.add(0, "2월");
		list2.add(1, "1-2");
		list2.add(2, "2-2");
		list2.add(3, "3-2");

		list3.add(0, "3월");
		list3.add(1, "1-3");
		list3.add(2, "2-3");
		list3.add(3, "3-3");

		List<List<String>> listT = new ArrayList<List<String>>();
		listT.add(0,list1);
		listT.add(1,list2);
		listT.add(2,list3);

		System.out.println(listT);
		System.out.println();

		////////////////////////////////////////////////////////////////
		System.out.println("Ver3");
		Map<String, Object> tch1 = new HashMap<String, Object>();
		tch1.put("강사이름", "개똥이");
		tch1.put("1월", "개똥이1월");
		tch1.put("2월", "개똥이2월");
		tch1.put("3월", "개똥이3월");

		Map<String, Object> tch2 = new HashMap<String, Object>();
		tch2.put("강사이름", "소똥이");
		tch2.put("1월", "소똥이1월");
		tch2.put("2월", "소똥이2월");
		tch2.put("3월", "소똥이3월");

		Map<String, Object> tch3 = new HashMap<String, Object>();
		tch3.put("강사이름", "말똥이");
		tch3.put("1월", "말똥이1월");
		tch3.put("2월", "말똥이2월");
		tch3.put("3월", "말똥이3월");

		List<Map<String, Object>> listVer3 = new ArrayList<Map<String,Object>>();
		listVer3.add(0, tch1);
		listVer3.add(1, tch2);
		listVer3.add(2, tch3);
		//여기 까지는 DB에서 가져온 list 
		//컬럽(키)은 :    [0]강사이름       ,[1] 1월, [2] 2월, .... 
		//값(value)은  : [0]누구누구누구 ,[1] 얼마, [2] 얼마, ...
		// 컬럼을 담을 배열들 
		String monthStr[] = {"1월","2월","3월"};
//첫번쨰
		List<String> month1 = new ArrayList<String>();
		List<String> month2 = new ArrayList<String>();
		List<String> month3 = new ArrayList<String>();
		List<List<String>> listTotal = new ArrayList<List<String>>();
		listTotal.add(month1);
		listTotal.add(month2);
		listTotal.add(month3);
		//0번지에 월을 넣어준다. 
		for(int i=0; i<monthStr.length; i++) {
			listTotal.get(i).add(0, monthStr[i]);
		}
//두번쨰 
		List<List<String>> listTotal2 = new ArrayList<List<String>>();
		for(int i=0; i<monthStr.length; i++) {
			List<String> month = new ArrayList<String>();
			month.add(0, monthStr[i]);
			listTotal2.add(i,month);
		}
//

		// 출력
		System.out.println("이 부분은 꺽을선그래프? 선 주인 들... data.addColumn('number','개똥이')");
		System.out.println("  ㄴ List.get(i).get('강사이름')");
		System.out.print("  ㄴ 강사이름 : ");
		for(int i=0; i<listVer3.size(); i++) {
			Map<String, Object> bufMap = listVer3.get(i);
			System.out.print(bufMap.get("강사이름")+", ");
// 첫번째 
			month1.add(i+1,bufMap.get("1월").toString());
			month2.add(i+1,bufMap.get("2월").toString());
			month3.add(i+1,bufMap.get("3월").toString());
// 두번째 
			listTotal2.get(0).add(i+1, bufMap.get("1월").toString());
			listTotal2.get(1).add(i+1, bufMap.get("2월").toString());
			listTotal2.get(2).add(i+1, bufMap.get("3월").toString());
//
		}
		System.out.println();
//첫번째
		System.out.println(listTotal);
//두번째 
		System.out.println(listTotal2);
	}


	public static void main(String[] args) {
		ChartTestVer2 ct2 = new ChartTestVer2();
		ct2.setData();
	}
}