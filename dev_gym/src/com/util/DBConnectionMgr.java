package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
	Connection con = null;
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String _URL = "jdbc:oracle:thin:@192.168.0.191:1521:orcl11";
	public static String _USER = "gym";
	public static String _PW = "tiger";
	//static - 클래스 급. 공유(정적변수)->인스턴스화 필요없음
	static DBConnectionMgr dbMgr = null;
	private DBConnectionMgr() {}
	//싱글톤 패턴으로 객체 관리하기 - 인스턴스화 과정
	public static DBConnectionMgr getInstance() {
		if(dbMgr == null) {
			dbMgr = new DBConnectionMgr();
		}
		return dbMgr;
	}
	
	public Connection getConnection(){
		System.out.println("getConnection호출 성공");
		try {
			//con=new Connection(); 반드시 구현체 클래스가 있어야 한다.
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}//end of connection
	/*
	 * DBConnectionMgr은 여러 업무에서 공통으로 사용하는 클래스입니다.
	 * 사용한 자원(Connection, PreparedStatement, ResultSet)은 반드시 반납
	 * 동시 접속자 수가 많은 시스템에서 자원사용은 곧 메모리랑 직결되므로 서버가 다운되거나 시스템 장애 발생 원인
	 */
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch(Exception e) {
			System.out.println("Exception : "+e.toString());
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch(Exception e) {
			System.out.println("Exception : "+e.toString());
		}
	}
}
