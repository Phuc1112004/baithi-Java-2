package com.contact.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. Create connection
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=contact","sa","12345678");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return conn;

    }
}
