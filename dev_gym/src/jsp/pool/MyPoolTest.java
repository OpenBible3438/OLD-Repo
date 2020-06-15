package jsp.pool;

import java.sql.*;
import java.util.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.google.gson.Gson;

public class MyPoolTest {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT deptno, dname, loc FROM dept";
	
	Map<String, Object> pMap = null;
	List<Map<String,Object>> rList = null;
	
	public void poolDao() {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbPool");
			System.out.println(ds);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rList = new ArrayList<>();
			while(rs.next()) {
				pMap = new HashMap<>();
				pMap.put("deptno", rs.getInt("deptno"));
				pMap.put("dname", rs.getString("dname"));
				pMap.put("loc", rs.getString("loc"));
				rList.add(pMap);
			}
			
			Gson g = new Gson();
			String buffer = g.toJson(rList);
			System.out.println(buffer); /**/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyPoolTest mpt = new MyPoolTest();
		mpt.poolDao();
	}
}
