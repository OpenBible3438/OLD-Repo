<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String center = request.getParameter("center");
	String pick = null;
	//부분 갱신 될 url 매핑
	switch(center) {
		case "null"   : /* 쿠키가 없을 때(초기화면) */ 
		case "info"   : { pick = "../info/info.jsp?mode=info";  } break;
		case "gym"    : { pick = "../gym/gymInfo.jsp";          } break;
		case "chart"  : { pick = "../gym/gymChart.jsp";         } break;
		case "review" : { pick = "../gym/gymReviewList.jsp";    } break;
		case "content": { pick = "../gym/gymContentList.jsp";   } break;
		case "notice" : { pick = "../gym/gymNoticeList.jsp";    } break;
		case "tch"    : { pick = "../teacher/tchInfo.jsp";      } break;
		case "mem"    : { pick = "../member/memInfo.jsp";       } break;
		case "ibd"    : { pick = "../member/memInbodyList.jsp"; } break;
		case "cls"    : { pick = "../class/classInfo.jsp";      } break;
	}
	//center를 쿠키에 저장
	//다시 main.jsp로 이동하더라고 쿠키에 저장하면 마지막으로 보고있는 화면을 보여준다.
	Cookie centerPick = new Cookie("center", center);
	centerPick.setPath("/dev_gym/fitness");
	centerPick.setMaxAge(-1);
	response.addCookie(centerPick);
	//String path= centerPick.getPath();
	out.print(pick);	
	
	/* 
	if(mode != null) {
		//로그인
		if("make".equals(mode)) {
			Cookie cMemName = new Cookie("mem_name", mem_name);
			cMemName.setPath("/google/map");
			cMemName.setMaxAge(-1);
			response.addCookie(cMemName);
			out.print(mem_name);
		}
		//로그아웃
		else if("delete".equals(mode)) {
			Cookie cMemName = new Cookie("mem_name", "");
			cMemName.setMaxAge(0);
			response.addCookie(cMemName);
		}
		//조회
		else if("read".equals(mode)) {
			Cookie cs[] = request.getCookies();
			if(cs != null && cs.length>0) {
				for(int i=0; i<cs.length; i++) {
					if("mem_name".equals(cs[i].getName())) {
						mem_name = cs[i].getValue();
						break;
					}
				}
			}
			out.print(mem_name);
		}
	} 
	*/
%>