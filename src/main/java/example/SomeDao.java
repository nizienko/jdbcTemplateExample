package example;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by def on 13.06.2016.
 */
public class SomeDao {
    private JdbcTemplate jdbcTemplate;
    public SomeDao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:oracle:thin:@<host>:<port>/<database>");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setInitialSize(5);

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String selectSomething(String name) {
        String sql = "select something from sometable where name=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, String.class);
    }
}
