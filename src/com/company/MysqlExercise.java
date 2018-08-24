package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlExercise {
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
            for(int i = 0; i < 100; i++) {
                int j = i + 18;
                String x = String.valueOf(j);
                int o = Integer.parseInt(x);

                s.execute("INSERT INTO t_employees VALUES (" + j + ", '英雄', '121'," + 24 + "," + 89 + ")" );
            }
            //System.out.println("100个英雄数据库插入完毕");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
