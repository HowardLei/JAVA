package com.company;

import java.sql.*;

/**
 * ConnectMySQL class
 *
 * @author apple
 * @date 2019-06-01
 */
public class ConnectMySQL {
    public static void main(String[] args) throws Exception {
        var sqlURL = "jdbc:mysql://localhost:3306/Demo?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = GMT";
        Class.forName("com.mysql.jdbc.Driver");
        var connection = DriverManager.getConnection(sqlURL, "root", "SweetieCan@0830");
        System.out.println(connection);
        var statement = connection.createStatement();
        System.out.println(statement);
        var result = statement.executeQuery("select * from SC;");
        while (result.next()) {
            var sno = result.getString("Sno");
            var cno = result.getString("Cno");
            var grade = result.getInt("Grade");
            System.out.println(sno + " " + cno + " " + grade);
        }
        result.close();
        connection.close();
        statement.close();
    }
}
