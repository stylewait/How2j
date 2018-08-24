package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlTest {
    public static void main(String[] args) {

        Connection c = null;
        Statement s =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

             c = DriverManager.getConnection("jdbc:mysql://localhost:3306/study1?characterEncoding=UTF-8",
                    "root", "chenliang1994427");
            System.out.println("连接成功，获取连接对象： " + c);

             s = c.createStatement();
            System.out.println("获取Statement对象：" + s);

            s.execute("insert into t_employees values(11, 'gareen', '1223', 24, 6300)");
            System.out.println("执行插入语句成功！");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(s != null){
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
