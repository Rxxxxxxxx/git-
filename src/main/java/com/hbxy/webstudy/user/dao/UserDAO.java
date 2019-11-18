package com.hbxy.webstudy.user.dao;

import com.hbxy.webstudy.user.model.User;
import com.hbxy.webstudy.util.JDBCUtl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class UserDAO {
    // 添加用户的操作
    public boolean add(User user) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtl.getConnection();
            // 执行的 SQL 语句
            String sql = "INSERT INTO user (user_name, sex, birth_Place, clazz, user_No, address)" + "VALUES(?,?,?,?,?,?)";
            // 创建执行 SQL 语句的 PreparedStatement 对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getSex());
            preStmt.setString(3, user.getBirthPlace());
            preStmt.setString(4, user.getClazz());
            preStmt.setString(5, user.getUserNo());
            preStmt.setString(6, user.getAddress());
            int num=preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtl.release(rs, preStmt, conn);
        }
        return false;
    }
    // 查询所有的 User 对象
    public ArrayList<User> findAll() {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            // 获得数据的连接
            conn = JDBCUtl.getConnection();
            // SQL 语句
            String sql = "SELECT * FROM user";
            // 获得 Statement 对象
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setSex(rs.getString("sex"));
                user.setBirthPlace(rs.getString("birth_place"));
                user.setClazz(rs.getString("clazz"));
                user.setUserNo(rs.getString("user_no"));
                user.setAddress(rs.getString("address"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtl.release(rs, preStmt, conn);
        }
        return null;
    }
    // 根据 id 查找指定的 user
    public User find(int id) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtl.getConnection();
            // SQL 语句
            String sql = "SELECT * FROM user WHERE user_id=?";
            // 创建执行 SQL 语句的 PreparedStatement 对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1,id);
            rs = preStmt.executeQuery();
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setSex(rs.getString("sex"));
                user.setBirthPlace(rs.getString("birth_place"));
                user.setClazz(rs.getString("clazz"));
                user.setUserNo(rs.getString("user_no"));
                user.setAddress(rs.getString("address"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtl.release(rs, preStmt, conn);
        }
        return null;
    }
    // 删除用户
    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtl.getConnection();
            // SQL 语句
            String sql = "DELETE FROM user WHERE user_id=?";
            // 创建执行 SQL 语句的 PreparedStatement 对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1,id);
            int num = preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtl.release(rs, preStmt, conn);
        }
        return false;
    }
    // 修改用户
    public boolean update(User user) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtl.getConnection();
            // 执行的 SQL 语句
            String sql = "UPDATE user set user_name=?, sex=?, birth_Place=?, clazz=?, user_No=?, address=? "
                    + " where user_id=? ";
            // 创建执行 SQL 语句的 PreparedStatement 对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getSex());
            preStmt.setString(3, user.getBirthPlace());
            preStmt.setString(4, user.getClazz());
            preStmt.setString(5, user.getUserNo());
            preStmt.setString(6, user.getAddress());
            preStmt.setInt(7, user.getUserId());
            int num=preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtl.release(rs, preStmt, conn);
        }
        return false;
    }
}
