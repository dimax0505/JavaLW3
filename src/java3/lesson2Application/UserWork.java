package java3.lesson2Application;

import java3.lesson2DB.Goods;
import java.util.List;
import java.util.Scanner;

class UserWork {
    private Scanner scanner = new Scanner(System.in);
    private Connection con;

    UserWork(Connection con) {
        this.con = con;
    }

    void userInput() {
        System.out.println("Введите запрос:");
        label:
        while (true) {
            String input = scanner.nextLine();
            String[] inputParse = input.split(" ");

            switch (inputParse[0]) {
                case "/цена": {
                    List<Goods> results = con.jdbcTemplate.query(
                            "select * from goods where title = ?", new Object[]{inputParse[1]},
                            (rs, rowNum) -> new Goods(rs.getInt("ID"), rs.getInt("prodID"),rs.getString("title"),
                                    rs.getDouble("cost")));

                    if (results.isEmpty()) {
                        System.out.println("Такого товара нет в базе");
                    } else {
                        printResult(results);
                    }
                    System.out.println("Введите новый запрос:");
                    break;
                }
                case "/товарыпоцене": {
                    List<Goods> results = con.jdbcTemplate.query(
                            "SELECT * FROM goods " +
                                    "WHERE cost BETWEEN ? AND ?", new Object[]{inputParse[1], inputParse[2]},
                            (rs, rowNum) -> new Goods(rs.getInt("ID"), rs.getInt("prodID"),rs.getString("title"),
                                    rs.getDouble("cost")));
                    if (results.isEmpty()) {
                        System.out.println("Нет таких товаров");
                    } else {
                        printResult(results);
                    }
                    System.out.println("Введите новый запрос:");
                    break;
                }
                case "/сменитьцену": {
                    List<Goods> results = con.jdbcTemplate.query(
                            "SELECT * FROM goods " +
                                    "WHERE title = ?", new Object[]{inputParse[1]},
                            (rs, rowNum) -> new Goods(rs.getInt("ID"), rs.getInt("prodID"),rs.getString("title"),
                                    rs.getDouble("cost")));
                    if (results.isEmpty()) {
                        System.out.println("Нет таких товаров");
                    } else {
                        con.jdbcTemplate.update("UPDATE goods SET cost = ? where title = ?", inputParse[2], inputParse[1]);
                    }
                    System.out.println("Введите новый запрос:");
                    break;
                }
                case "end":
                    break label;
                default:
                    System.out.println("Некорректный ввод запроса, попробуйте повторить запрос(end - закончить работу):");
                    break;
            }
        }

    }

    private void printResult(List<Goods> results) {
        for (Goods good : results) {
            System.out.println(good);
        }
    }
}
