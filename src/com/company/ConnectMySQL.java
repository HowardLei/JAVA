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
    public static void main(String[] args) throws Exception {
        var sqlURL = "jdbc:mysql://localhost:3306/Demo?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = GMT";
        var sql = "jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(sqlURL, "root", "SweetieCan@0830");
        System.out.println(connection);
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
        result.close();
        connection.close();
        statement.close();
    }
}
