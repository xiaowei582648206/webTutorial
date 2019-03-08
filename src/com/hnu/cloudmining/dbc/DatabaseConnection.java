package com.hnu.cloudmining.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/3/8.
 */
public class DatabaseConnection {
    private static final String dirver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://192.168.122.128:3306/cloudmining";
    private static final String user = "root";
    private static final String password = "123";
    private Connection conn = null;

    public DatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dirver);
        conn = DriverManager.getConnection(url, user, password);
    }

    public Connection getConn() {
        return this.conn;
    }

    public void close() throws SQLException {
        if (conn != null) {
            this.conn.close();
        }
    }
}
