package com.company;

import java.sql.*;

public class TestJDBC3 {
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
            ResultSet rs = s.executeQuery("SELECT * from t_employees");
            int total = 0;

            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("表t_employees中总共有： " + total + " 条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
