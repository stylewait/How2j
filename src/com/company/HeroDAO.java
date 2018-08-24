package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO{

    public HeroDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://mouseisbest.kmdns.net:1037/liang?characterEncoding=UTF-8",
                                            "liang","l");
    }

    public int getTotal(){
        int total = 0;
        try (Connection c = getConnection();
             Statement s = c.createStatement();)
        {
            ResultSet rs = s.executeQuery("select count(*) from t_hero");

            while (rs.next()) {
                total = rs.getInt(1);
            }

            System.out.println("total:" + total);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(Hero hero) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO t_hero VALUES (null,?,?,?)");)
        {
            ps.setString(1, hero.name);
            ps.setInt(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                hero.id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero hero) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("UPDATE t_hero set name=?,hp=?,damage=? WHERE id=?");) {
            ps.setString(1, hero.name);
            ps.setInt(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(4, hero.id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM t_hero WHERE id = ?");
        )
        {
            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hero get(int id) {
        Hero hero = null;
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM t_hero WHERE id = ?");) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                hero = new Hero();
                hero.id = id;
                hero.name = rs.getString(1);
                hero.hp = rs.getInt(2);
                hero.damage = rs.getInt(3);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Hero> list(int start, int counts) {
        List<Hero> heros = new ArrayList<>();
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM t_hero ORDER BY id desc limit ?,?");) {
            ps.setInt(1, start);
            ps.setInt(2, counts);

            ResultSet rs = ps.executeQuery();

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
}
