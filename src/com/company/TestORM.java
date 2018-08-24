package com.company;

import java.sql.*;

public class TestORM {
    public static void main(String[] args) {
        Hero h = get(22);
        System.out.println(h.name);
    }
    public static Hero get(int id){
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             Statement s = c.createStatement();
        ) {
            String sql = "select * from t_hero where id = " + id;
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                int hp = rs.getInt(3);
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }
}
