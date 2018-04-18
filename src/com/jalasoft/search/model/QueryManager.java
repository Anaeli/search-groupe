package com.jalasoft.search.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryManager {
    private static Connection connection;
    private Statement statement;


    public QueryManager(){
        connection = DBConnection.getInstance().getConnection();
    }

    public String addCriteria() throws SQLException {
//        statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("select * from search");
//        while(rs.next())
//        {
//            // read the result set
//            System.out.println("Criteria = " + rs.getString("Criteria"));
//            System.out.println("id = " + rs.getInt("Id"));
//        }
        return "asd";
    }
}
