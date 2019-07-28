package com.company;

import java.sql.*;
import java.util.*;

/**
 * ConnectMySQL class
 *
 * @author apple
 * @date 2019-06-01
 */
public class ConnectMySQL {
    public static void main(String[] args) {
        var sqlURL = "jdbc:mysql://localhost:3306/Demo?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = GMT";
        try {
            var className = Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("对不起，驱动加载失败");
            e.printStackTrace();
        }
        try {
            var connection = DriverManager.getConnection(sqlURL, "root", "SweetieCan@0830");
            var statement = connection.createStatement();
            System.out.println(statement);
            var result = statement.executeQuery("select * from SC;");
            var stringBuilders = new ArrayList<StringBuilder>();
            while (result.next()) {
                var sno = result.getString("Sno");
                var cno = result.getString("Cno");
                var grade = result.getInt("Grade");
                var stringBuilder = new StringBuilder();
                stringBuilder.append(sno).append(" ").append(cno).append(" ").append(grade);
                stringBuilders.add(stringBuilder);
            }
            var iter = stringBuilders.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
            if (result.isClosed() && connection.isClosed() && statement.isClosed()) {
                result.close();
                connection.close();
                statement.close();
            }
        } catch (SQLException exception) {
            System.out.println("SQL");
            exception.printStackTrace();
        }
    }
}