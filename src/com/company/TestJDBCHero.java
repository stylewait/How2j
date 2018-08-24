package com.company;

import java.sql.*;

public class TestJDBCHero {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO t_hero VALUES (null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             PreparedStatement ps = c.prepareStatement(sql))
        {
            System.out.println("链接成功！");

            for(int i = 5; i < 100; i++) {
                ps.setString(1, "英雄" + i);
                ps.setInt(2, (int)(Math.random() * 1000));
                ps.setInt(3, (int)(Math.random() * 100));
                ps.execute();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
