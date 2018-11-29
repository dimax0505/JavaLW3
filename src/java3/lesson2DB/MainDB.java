package java3.lesson2DB;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


public class MainDB {
    private static int size = 10000;
    private static Goods[] goods;
    private static String nameTable = "goods";


    public static void main(String[] args) {
        DriverManagerDataSource dataSource = makeConnectToDB();

        makeGoodsArray(size);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Создаем базу данных или подключаемся к существующей");


        ClearTableAndMakeNew(jdbcTemplate);


        for (Goods good: goods) {
            jdbcTemplate.update("insert into goods (prodID, title, cost) values(?,?,?)",good.getProdid(),good.getTitle(), good.getPrice());
        }
    }

    private static void ClearTableAndMakeNew(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("drop table if exists " + nameTable);
        jdbcTemplate.execute("create table " + nameTable +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, prodID integer, title varchar(255), cost double)");
    }

    private static DriverManagerDataSource makeConnectToDB() {
        DriverManagerDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUsername("");
        dataSource.setUrl("jdbc:sqlite:sample.db");
        dataSource.setPassword("");
        return dataSource;
    }

    private static void makeGoodsArray(int size) {
        goods = new Goods[size];
        for (int i=0; i<size; i++){
            goods[i] = new Goods(i,101+i,"товар"+(i+1),1.5+i);
        }
    }

}

