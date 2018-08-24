package com.company;

import java.sql.*;

public class TestJDBC4 {
    public static void main(String[] args) {
        System.out.println("分页查询");
        list(0,5);
    }

    public static void list(int start, int counts) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1?characterEncoding=UTF-8",
                "root", "chenliang1994427");
             PreparedStatement ps = c.prepareStatement("SELECT * FROM t_employees limit ?, ?");
        ) {
            //ResultSet rs = s.executeQuery("select * form t_employees limit " + start + ", " + counts);
            ps.setInt(1,start);
            ps.setInt(2,counts);
            ResultSet rs = ps.executeQuery();
            //ResultSet rs = s.executeQuery("SELECT * FROM t_users");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(4);
                System.out.printf("ID:%d\t  Name:%s\t  Age:%d\t  |", id, name, age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
