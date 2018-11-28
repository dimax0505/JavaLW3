package java3.lesson2Application;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

class Connection {

    JdbcTemplate jdbcTemplate;

    Connection(){
        DriverManagerDataSource dataSource = new SingleConnectionDataSource("jdbc:sqlite:sample.db", true);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


}
