package com.javatunes.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", "GUEST", "password");
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Connected as: " + dbmd.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close connection
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException ignored) {
            }
        }
    }
}
