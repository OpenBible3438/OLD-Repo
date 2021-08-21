package prj.fitness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import oracle.sql.BLOB;

public class ModelAndView {

	public String type = "";
	HttpServletRequest req = null;
	public HttpServletResponse res = null;
	String viewName = null;
	List<Map<String, Object>> selResult = null;
	
	public ModelAndView(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
	}
	
	public void setViewName(String viewName) {
		//this.viewName = viewName;
//		this.viewName = req.getContextPath()+"/WEB-INF/fitness/"+viewName+".jsp";
		this.viewName = "/WEB-INF/fitness/"+viewName+".jsp";
	}
	public String getViewName() {
		return viewName;
	}
	public void addObject(String name, Object obj) {
		req.setAttribute(name, obj);
		if(type.equals("json")) {
			selResult = (List<Map<String, Object>>)obj;
		} else if(type.equals("img")) {
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", (BLOB)obj);
			list.add(map);
			selResult = list;
		}
	}
	public Object getObject() {
		return selResult;
	}
	
	
}
