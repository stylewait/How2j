package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlTest2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1?characterEncoding=UTF-8",
                "root", "chenliang1994427");
             Statement s = c.createStatement();
        ) {
            s.execute("insert into t_employees values(12, 'allen', '1314', 23, 10000.21)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
