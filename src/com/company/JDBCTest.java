package com.company;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBCTest class
 *
 * @author apple
 * @date 2019/11/22
 */
public class JDBCTest {
    public static void main(String[] args) {
        connect();
    }
    public static void connect() {
        try (var manager = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "SweetieCan@0830")) {
            var preparedStatement = manager.prepareStatement("select * from Shop_Consumer;");
            var insertSQL = manager.prepareStatement("insert into Shop_Consumer (id, name, loginName, password) values (default, ?, ?, ?);");
            insertSQL.setString(1, "wangnima");
            insertSQL.setString(2, "root");
            insertSQL.setString(3, "123");
            var update = insertSQL.executeUpdate();
            if (update == 1) {
                System.out.println("正确");
            } else {
                System.out.println("错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
