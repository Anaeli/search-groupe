/*
 * Search .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.model;

import com.jalasoft.search.common.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 This class implements methods to create and connect to data base.
 using sqlite jdbc library
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class DBConnection {
    private static DBConnection dbCon;
    private static Connection connection;

    /**
     * private constructor because this class is based on Singleton pattern,
     * in order to have only an instance of database connection
     * */
    private  DBConnection(){
        try {
            init();
        } catch (ClassNotFoundException e) {
            Log.getInstance().getLogger().info("DB Exception: " + e);
        } catch (SQLException e) {
            Log.getInstance().getLogger().info("DB Exception: " + e);
        }
    }

    /**
     * This method return new DBConnection instance if it is null
     * */
    public static DBConnection getInstance(){
        if (dbCon == null){
            dbCon = new DBConnection();
        }
        return dbCon;
    }

    /**
     * This method initialize the connection to Data base and create the table if not exists
     * */
    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:searchGroupE.db");
        Statement createDataBase = connection.createStatement();
        createDataBase.executeUpdate("create table if not exists search (id INTEGER PRIMARY KEY AUTOINCREMENT, criteria varchar(900))");
    }

    /**
     * This method return database connection
     * */
    public static Connection getConnection(){
        return connection;
    }
}
