package com.jalasoft.search.model;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbCon;
    private static Connection connection;

    private  DBConnection(){
        try {
            init();
        } catch (ClassNotFoundException e) {
            System.out.println("1" + e);
        } catch (SQLException e) {
            System.out.println("2" + e);
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
        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        Statement createDataBase = connection.createStatement();
        createDataBase.executeUpdate("create table if not exists search (id integer, criteria varchar(900), primary key(id))");
        ResultSet rs = createDataBase.executeQuery("select * from search");
        while(rs.next())
        {
            // read the result set
            System.out.println("name = " + rs.getString("criteria"));
            System.out.println("id = " + rs.getInt("id"));
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
