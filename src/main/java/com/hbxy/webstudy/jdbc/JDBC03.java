package com.hbxy.webstudy.jdbc;

import java.sql.*;

public class JDBC03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&autoReconnect=true&useSSL=false&characterEncoding= utf8&useUnicode=true";
            String username = "root";
            String password = "147896325";
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from user";
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            System.out.print("02*'%/user_name:");
            rs.absolute(2);
            System.out.println(rs.getString("user_name"));
            System.out.print("01*'%/user_name:");
            rs.beforeFirst();
            rs.next();
            System.out.println(rs.getString("user_name"));
            System.out.print("04*'%/user_name:");
            rs.afterLast();
            rs.previous();
            System.out.println(rs.getString("user_name"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
