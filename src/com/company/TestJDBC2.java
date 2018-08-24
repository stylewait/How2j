package com.company;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1?characterEncoding=UTF-8",
                "root", "chenliang1994427");
             Statement s = c.createStatement()
        )
        {
            System.out.println("连接数据库成功");
//            String name = "dashen";
//            String password = "thisispassword";



            ResultSet rs = s.executeQuery("SELECT * from t_users where Name='dashen' and password='thisispassword'");
            if (rs.next()) {
                System.out.println("账号密码正确");
            } else {
                System.out.println("账号密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
