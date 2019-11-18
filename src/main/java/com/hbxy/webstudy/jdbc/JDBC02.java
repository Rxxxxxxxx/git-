package com.hbxy.webstudy.jdbc;

import java.sql.*;

public class JDBC02 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&autoReconnect=true&useSSL=false&character Encoding=utf8&useUnicode=true";
            String username = "root";
            String password = "147896325";
            conn = DriverManager.getConnection(url, username, password);
            for(int i=1; i<=10 ; i++){
                String sql = "INSERT INTO user (user_name, sex, birth_Place, clazz, user_No, address)" + "VALUES(?,?,?,?,?,?)";
                preStmt = conn.prepareStatement(sql);
                preStmt.setString(1, "张三"+i);
                preStmt.setString(2, "0");
                preStmt.setString(3, "河北");
                preStmt.setString(4, "'计科1604");
                preStmt.setString(5, ""+(16000+i));
                preStmt.setString(6, "海滨学院");
                preStmt.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                preStmt = null;
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
