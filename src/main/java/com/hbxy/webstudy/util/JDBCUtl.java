package com.hbxy.webstudy.util;

import java.sql.*;
public class JDBCUtl {
    // 加载驱动，并建立数据库连接
    public static Connection getConnection() throws
            SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/MyDB?serverTimezone=UTC&autoReconne ct=true&useSSL=false&characterEncoding=utf8&useUnicode=true";
        String username = "root";
        String password = "147896325";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    // 关闭数据库连接，释放资源
    public static void release(Statement stmt, Connection conn)
    {
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
    public static void release(ResultSet rs, Statement stmt,
                               Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt, conn);
    }
}
