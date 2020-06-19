package com.util;

import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class MyBatisBuilderMgr {
	//전역변수
	public static String _RESOURCE = "com/mybatis/Configuration.xml";
	
	private static MyBatisBuilderMgr mbMgr = null; 
	private static Reader reader = null;
	private static SqlSessionFactory sqlMapper = null;
	private SqlSession sqlSes = null;
	
	private MyBatisBuilderMgr() {} 
	
/**********************************************************************************************
 * MyBatisBuilderMgr, Reader, SqlSessionFactory 싱글톤으로 관리하는 메소드
 * @return MyBatisBuilderMgr
 * @author 허준호
 */
	public static MyBatisBuilderMgr getInstance() {
		if(mbMgr == null) {
			try {
				mbMgr = new MyBatisBuilderMgr();
				reader = Resources.getResourceAsReader(_RESOURCE);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return mbMgr;
	}
/**************************************************************************************************
 * SqlSession를 인스턴스화 해주는 메소드
 * @return SqlSession : 인스턴스화 
 * @author 허준호
 */
	public SqlSession openSession() {
		//Commit과 Rollback을 처리하는 애
//		SqlSession sqlSes = null;
		try {
			this.sqlSes = sqlMapper.openSession();
//			sqlSes = sqlMapper.openSession();
		} catch (Exception e) {
			System.out.println("예외가 발생했음. 정상적으로 처리가 안됨. ");
		}
		return this.sqlSes; 
	}
/*********************************************************************************************************
 * SqlSession를 자원반납하는 메소드
 * @param sqlSes : 인스턴스화 된 SqlSession
 * @author 허준호
 */
	public void clossSession(SqlSession sqlSes) {
		try {
			if(sqlSes!=null) {
				sqlSes.close();
			}
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}
	}
}