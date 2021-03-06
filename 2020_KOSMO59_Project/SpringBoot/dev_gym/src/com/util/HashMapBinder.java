package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	//요청 객체는 사용자가 요청했을 때  요청을 받아주는 서블릿에서 
	//주소번지를 받아와야 한다.
	//그래야 그 사람에 대한 요청 정보를 확인할 수 있는 것이다.
	//이 말을 이해하고 설명할 수 있는지 확인해 볼것.
	HttpServletRequest req = null;
	//첨부 파일 처리에 필요한 변수 선언
	MultipartRequest multi = null;
	String realFolder = "";
	//첨부파일의 한글처리
	String encType = "utf-8";
	//첨부파일의 크기
	int maxSize = 9*1024*1024;//9MB
	public HashMapBinder() {}
	
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
		//realFolder = "C:\\workspace_KHL\\workspace_fitness\\project_fitness\\dev_fitness\\WebContent\\pds";
		//realFolder = "C:\\git_gym\\dev_gym\\WebContent\\pds";
		realFolder = "C:\\Users\\Public\\Pictures";
	}
	public void multiBind(Map<String,Object> pMap) {
		pMap.clear();
		try {
			multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("-============================");
			e.printStackTrace();
		}
		logger.info("multi : "+multi);
		
		Enumeration<String> en = multi.getParameterNames();
		//자료구조안에 데이터가 있나요?
		int i = 0;
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			pMap.put(key, multi.getParameter(key));
			logger.info((++i)+". "+key+": "+pMap.get(key));
		}
		//첨부파일에 대한 정보를 받아오는 코드 추가하기
		Enumeration<String> files = multi.getFileNames();
		File file = null;
		if(files!=null) {
			while(files.hasMoreElements()) {
				String fname = files.nextElement();
				logger.info("fname:"+fname);
				String filename = multi.getFilesystemName(fname);
				if(filename !=null && filename.length()>0) {
					try {
						//파일 객체 만들기
						//file2 = new File(realFolder+"\\"+filename);
						file = multi.getFile("img");
						logger.info("file : "+file);
						//logger.info("file2 : "+file2);
						//파일 이름 만들기
						pMap.put("filename", filename);
						logger.info("filename : "+filename);
						//파일 사이즈 만들기
						double size = file.length();
						size = file.length(); //단위가 바이트 단위file:///C:/git/jsp-source-repo/dev_jsp/WebContent/pds/flower.jpg
						size = size/(1024.0);
						size = Double.parseDouble(String.format("%.3f", size));//NUMBER(7,3); 0000.000;
						pMap.put("filesize", size);
						logger.info("filesize : "+size);
						//파일 데이터 만들기
						FileInputStream fis = new FileInputStream(file);
						pMap.put("file", file);				
						pMap.put("filedata", fis);				
						logger.info("filedata : "+fis);
					} catch (Exception e) {
						logger.info("HashMapBinder - multiBind img 에러");
						e.printStackTrace();
					}
				}
			}///////////////end of while
		}//////////////////end of if
		//체크박스 널 체크 
		if("gym".equals(pMap.get("type"))) {
			logger.info("체크박스 값 채움");
			if(!(pMap.containsKey("gym_parking"))) pMap.put("gym_parking", "off");
			if(!(pMap.containsKey("gym_wash")))    pMap.put("gym_wash", "off");
			if(!(pMap.containsKey("gym_uniform"))) pMap.put("gym_uniform", "off");
			if(!(pMap.containsKey("gym_locker")))  pMap.put("gym_locker", "off");
		}
		else {
			logger.info("gym.equalse(type) 아님 " + pMap.get("type"));
		}
	}
	public void binder(Map<String,Object> pMap) {
		logger.info("binder 호출");
		//기존에 들어 있던 값이 있다면 모두 비운다.
		pMap.clear();
		Enumeration<String> en = req.getParameterNames();
		//enumeration에 값이 들어있는지 체크해 줌.
		int i =0;
		while(en.hasMoreElements()) {
			String key = en.nextElement();//name, address, pet
			//pMap.put(key,HangulConversion.toUTF(req.getParameter(key)));
			pMap.put(key,req.getParameter(key));
			logger.info((++i)+". "+key+": "+pMap.get(key));
		}
		if(pMap.containsKey("img")) {
			try {
				// 파일을 바이트 배열로 받기 
				byte[] fileByte = pMap.get("img").toString().getBytes();
				String filename = pMap.get("filename").toString();
				logger.info("f. filename : "+filename);
				File file = new File(realFolder+"\\"+filename);
				// 파일 저장 시작 
		        FileOutputStream fos = new FileOutputStream(file);
		        fos.write(fileByte);
		        fos.close();
		        // 파일 저장 끝
		        //파일 사이즈 만들기
				double size = file.length();
				size = file.length(); //단위가 바이트 단위file:///C:/git/jsp-source-repo/dev_jsp/WebContent/pds/flower.jpg
				size = size/(1024.0);
				size = Double.parseDouble(String.format("%.3f", size));//NUMBER(7,3); 0000.000;
				pMap.put("filesize", size);
				logger.info("f. filesize : "+size);
				//파일 데이터 만들기
				FileInputStream fis = new FileInputStream(file);
				pMap.put("file", file);				
				pMap.put("filedata", fis);				
				logger.info("f. filedata : "+fis);
			} catch (Exception e) {
				logger.info("HashMapBinder - binder img 에러");
				e.printStackTrace();
			}
		}
		//logger.info("while문 다음");
		if("gym".equals(pMap.get("type"))) {
			logger.info("bind 체크박스 값 채움");
			if(!(pMap.containsKey("gym_parking"))) pMap.put("gym_parking", "off");
			if(!(pMap.containsKey("gym_wash")))    pMap.put("gym_wash", "off");
			if(!(pMap.containsKey("gym_uniform"))) pMap.put("gym_uniform", "off");
			if(!(pMap.containsKey("gym_locker")))  pMap.put("gym_locker", "off");
		}
		else {
			logger.info("gym.equalse(type) 아님 " + pMap.get("type"));
		}
	}
	
}






