package com.jalasoft.search.model;

import com.jalasoft.search.common.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static DBConnection dbCon;
    private static Connection connection;

    private  DBConnection(){
        try {
            init();
        } catch (ClassNotFoundException e) {
            Log.getInstance().getLogger().info("DB Exception: " + e);
        } catch (SQLException e) {
            Log.getInstance().getLogger().info("DB Exception: " + e);
        }
    }

    public static DBConnection getInstance(){
        if (dbCon == null){
            dbCon = new DBConnection();
        }
        return dbCon;
    }

    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:searchGroupE.db");
        Statement createDataBase = connection.createStatement();
        createDataBase.executeUpdate("create table if not exists search (id INTEGER PRIMARY KEY AUTOINCREMENT, criteria varchar(900))");
    }

    public static Connection getConnection(){
        return connection;
    }
}
