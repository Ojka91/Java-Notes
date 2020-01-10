package com.jdbc.jdbc.JDBCPractice;

import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;

import java.sql.*;

public class Conn {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
