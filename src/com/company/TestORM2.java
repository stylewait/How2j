package com.company;

import java.sql.*;

public class TestORM2 {
    public static void main(String[] args) {
        Hero h = get(18);
        System.out.println(h.damage);
    }

    public static Hero get(int id) {
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             PreparedStatement ps = c.prepareStatement("SELECT * FROM t_hero WHERE id = " + id);

        )
        {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hero = new Hero();
                hero.id = rs.getInt(1);
                hero.name = rs.getString(2);
                hero.hp = rs.getInt(3);
                hero.damage = rs.getInt(4);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hero;
    }
}
