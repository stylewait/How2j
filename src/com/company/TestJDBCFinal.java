package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBCFinal {
    public static Hero get(int id) {
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             Statement s = c.createStatement()
        ) {
            String sql = "select * from t_hero where id = " + id;


            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                hero = new Hero();
                hero.name = rs.getString(2);
                hero.hp = rs.getInt(3);
                hero.damage = rs.getInt(4);
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public static void add(Hero h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into t_hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             PreparedStatement ps = c.prepareStatement(sql);
             )
        {
            ps.setString(1, h.name);
            ps.setInt(2, h.hp);
            ps.setInt(3, h.damage);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Hero h){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             PreparedStatement ps = c.prepareStatement("DELETE FROM t_hero WHERE id = ?");
        )
        {
            ps.setInt(1, h.id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Hero h){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             PreparedStatement ps = c.prepareStatement("UPDATE t_hero SET name = ?, hp = ?, damage = ? WHERE id = ?");
        ) {
            ps.setString(1, h.name);
            ps.setInt(2, h.hp);
            ps.setInt(3, h.damage);
            ps.setInt(4, h.id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Hero> list(){
        List<Hero> heros = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                "liang", "l");
             Statement s = c.createStatement();)
        {
            ResultSet rs = s.executeQuery("SELECT * from t_hero");

            while (rs.next()) {
                Hero hero = new Hero();
                hero.id = rs.getInt(1);
                hero.name = rs.getString(2);
                hero.hp = rs.getInt(3);
                hero.damage = rs.getInt(4);
                heros.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

    public static void main(String[] args) {
        List<Hero> hs = list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        Hero h = new Hero();
        h.name = "新的英雄";

        System.out.println("新加一条数据");
        add(h);
        hs = list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        System.out.println("取出id=101的数据，它的name是：");

        h = get(5);
        System.out.println(h.name);
        System.out.println("把名字改为 英雄101，并且更新到新数据库");

        h.name = "英雄101";
        update(h);
        System.out.println("取出id=5的数据，它的name是：");
        h = get(5);
        System.out.println(h.name);
        System.out.println("删除id=5的数据");
        delete(h);
        hs = list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");

    }
}
