package jsp.ch17;

import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/*
 * Servlet 으로 정의한 클래스를 web.xml문서에 등록하는 것 만으로 
 * 서버기동시 해당 객체를 주입받을 수 있다.
 * xml문서에 작성한 값들을 자바코드에서 사용할 수 있다.
 * 이 때 내가 직접 객체를 생성하는것이 아니라 xml문서에 미리 선언 해 두면
 * 톰캣이 내가 필요 할 때 대신 주입 해준다.[제어 역전]
 * 
 * IOC[Inversion Of Control]
 *  - 적절한 위치에서 톰캣에서 위림하여 처리하는 방식
 *    기존의 전통적인 개발방식
 *  - 적절한 위치에서 개발자가 개발코드를 이용해서 필요한 객체를 생성해서 사용하는 방식
 *  
 *  IOC의 개념을 적용함으로써 인해 얻을 수 있는 장점은?
 *   - 객체 간의 결합도를 떨어 뜨릴 수 있다.
 *  제어 : 객체에 대한 제어를 의미
 *  결합도 : 소프트 웨어 코드의 한 요소가 다른 것과 얼마나 강력하게 연결 되어 있는지를
 *  	     나타냄 
 */
public class DBCPInitVer2 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}

	private void loadJDBCDriver() {
		//
		String _DRIVER = getInitParameter("jdbcDriver");
		try {
			Class.forName(_DRIVER);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnectionPool() {
		try {
			//
			String jdbcUrl = getInitParameter("jdbcUrl");
			String username = getInitParameter("jdbcId");
			String pw = getInitParameter("jdbcPw");

			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl, username, pw);

			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1");

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxTotal(50);

			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			//
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = 
					(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			//
			String poolName = getInitParameter("poolName");
			driver.registerPool(poolName, connectionPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
