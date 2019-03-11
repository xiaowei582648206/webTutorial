package com.hnu.cloudmining.dbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2019/3/8.
 */
public class DatabaseConnection {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private Connection conn = null;

    public DatabaseConnection() throws ClassNotFoundException, SQLException, IOException {
        Properties p = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("conf/jdbc.properties");
        p.load(in);
        driver = p.getProperty("driver");
        url = p.getProperty("url");
        user = p.getProperty("user");
        password = p.getProperty("password");
        Class.forName(driver);
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
