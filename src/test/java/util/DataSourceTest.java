package util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jifang.spittr.config.SpittrConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * author: jifang
 * date: 18-4-9 下午4:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpittrConfig.class)
public class DataSourceTest {
    @Autowired
    private DruidDataSource dataSource;

    @Test
    public void runTest() throws SQLException {
        DruidPooledConnection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
        statement.executeUpdate("INSERT INTO Greetings VALUES ('Hello World!sdfsdf')");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Greetings");
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

        statement.executeUpdate("DROP TABLE Greetings");
    }
}
