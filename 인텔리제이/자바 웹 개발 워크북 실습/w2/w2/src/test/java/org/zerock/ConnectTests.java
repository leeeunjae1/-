package org.zerock;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {
    @Test
    /* @Test 이노테이션을 사용하는 메서드를 작성한다. @Test를 사용하는 메서드는 반드시 public으로 선언
    파라미터나 리턴 타입이 없다. */
    public void test1() {
        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1,v2);
        // junit 라이브러리에서 제공되는 메서드로 v1과 v2를 비교하여 값이 다를 경우 오류를 출력한다.

    }
    @Test
    public void testConnection() throws Exception{
        Class.forName("org.mariadb.jdbc.Driver");
        //jdbc 드라이버 클래스를 메모리 상으로 로딩하는 역할을 하는 메서드

        Connection connection = DriverManager.getConnection(
        //Connection 인터페이스 타입의 변수, 데이터베이스와 네트워크 연결을 의미//
        //DriverManager.getConnection는 데이터베이스에 있는 여러 정보들을 통해 특정 데이터에 연결(여기선 webdb)
                "jdbc:mariadb://localhost:3306/webdb",
                //jdbc 프로토콜을 이용하고 localhost:3306은 네트워크 연결 정보, webdb는 연결하려는 db정보!
                "root", //userid
                "1234" //userpassword
        );

        Assertions.assertNotNull(connection);
        //DB가 정상적으로 연결된다면 Connection 타입의 객체는 null이 아니라고 확신한다는 의미

        connection.close();
        //DB와 연결 종료
    }
    @Test
    public void testHikariCP() throws Exception{
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("root");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();
    }
}
