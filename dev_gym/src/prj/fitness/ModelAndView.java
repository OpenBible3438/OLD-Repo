package prj.fitness;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndView {

	HttpServletRequest req = null;
	HttpServletResponse res = null;
	String viewName = null;
	
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
	}
	
	
}
