package prj.fitness;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		}
	}
	public Object getObject() {
		return selResult;
	}
	
	
}
