package com.hbxy.webstudy.jdbc;

import java.sql.SQLException;
import java.sql.*;

public class JDBC01 {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/MyDB";
            String username = "root";
            String password = "147896325";
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            System.out.println("userId | userName | sex | birthPlace | clazz | userNo | address");
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String userName = rs.getString("user_name");
                String sex = rs.getString("sex");
                String birthPlace = rs.getString("birth_place");
                String clazz = rs.getString("clazz");
                String userNo = rs.getString("user_no");
                String address = rs.getString("address");
                System.out.println(userId + " | " + userName + " | " + sex + " | " + birthPlace + " | "
                        + clazz + " | " + userNo + " | " + address);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if(conn!=null) {
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
