package java3.lesson2Application;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Application {



    public static void main(String[] args) {
        Connection con = new Connection();
        UserWork userWork = new UserWork(con);
        userWork.userInput();

//        DriverManagerDataSource dataSource = new SingleConnectionDataSource("jdbc:sqlite:sample.db", true);
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);



    }
}
