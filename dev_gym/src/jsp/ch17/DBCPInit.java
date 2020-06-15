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
public class DBCPInit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}

	private void loadJDBCDriver() {
		try {
			//커넥션 풀에서 사용할 jdbc 드라이버를 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnectionPool() {
		try {
			String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
			String username = "scott";
			String pw = "tiger";
			
			//커넥션 팩토리 생성. 커넥션 팩토리는 새로운 커넥션을 생성할 때 사용한다.
			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl, username, pw);
			
			//DBCP가 커넥션 풀에 커넥션을 보관 할 때 사용 하는 PoolableConnectionFactory생성
			//실제로 내부적으로 커넥션을 담고 있고 커넥션을 관리하는데 기능을 제공한다. ex) 커넥션을 close하면 종료하지 않고 커넥션 풀에 반환
			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			
			//커넥션이 유효한지 확인 할 때 사용하는 쿼리를 설정한다.
			poolableConnFactory.setValidationQuery("select 1");
			
			//커넥션 풀의 설정 정보를 생성한다.
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			//유휴 커넥션 검사주기
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			//풀에 있는 커넥션이 유효한지 검사 유무 설정
			poolConfig.setTestWhileIdle(true);
			//커넥션 최소 갯수 설정
			poolConfig.setMinIdle(4);
			//커넥션 최대 갯수 설정
			poolConfig.setMaxTotal(50);

			//커넥션 풀 생성. 인자로는 위에서 생성한 PoolableConnectionFactory와 GenericObjectPoolConfig을 사용한다.
			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			
			//PoolableConnectionFactory에도 커넥션 풀을 연결
			poolableConnFactory.setPool(connectionPool);
			//커넥션 풀을 제공하는 jdbc 드라이버를 등록
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = 
					(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			//위에서 커넥션 풀 드라이버에 생성한 커넥션 풀을 등록한다. 이름은 chap14이다.
			driver.registerPool("chap14", connectionPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
