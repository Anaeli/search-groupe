package com.jalasoft.search.model;

import com.jalasoft.search.common.Log;

import java.sql.*;

public class QueryManager {
    private static Connection connection;
    private Statement statement;


    public QueryManager() throws SQLException {
        connection = DBConnection.getInstance().getConnection();

    }

    public String addCriteria(String criteriaString) throws SQLException {
        String insertString = "insert into search (id, criteria) values(?,?)";
        PreparedStatement insertCriteria = connection.prepareStatement(insertString);
        insertCriteria.setString(2, criteriaString);
        insertCriteria.execute();
        return "asd";
    }

    public String getAllCriterials(){
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from search");
            while(rs.next()){
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("Criteria = " + rs.getString("criteria"));
            }
        } catch (SQLException e) {
            Log.getInstance().getLogger().info("DB Exception: " + e);
        }
        return "asd";
    }
}
