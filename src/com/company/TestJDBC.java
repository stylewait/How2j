package com.company;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost/study1?characterEncoding=UTF-8",
                "root", "chenliang1994427");
             Statement s = c.createStatement();
        ) {
            String sql = "select * from t_employees";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString(2);
                int age = rs.getInt(4);

                System.out.printf("ID:%d\t Name:%s\t Age: %d\t  |", id, name, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
