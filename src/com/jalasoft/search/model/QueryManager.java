/*
 * QueryManager .java
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

import com.google.gson.Gson;
import com.jalasoft.search.common.Log;
import com.jalasoft.search.controller.SearchCriteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap;


/**
 *
 This class implements methods to perform queries to data base
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class QueryManager {
    private static Connection connection;
    private Statement statement;
    private Gson gson;

    /**
     * Constructor initializes database connection using DBConnection Singleton Class
     * */
    public QueryManager() {
        connection = DBConnection.getInstance().getConnection();
        gson = new Gson();
    }

    /**
     * This method stores criteria string on search table
     * @param criteriaString this string is a criteria serialized on Json String to save on DB
     * */
    public String addCriteria(String criteriaString) throws SQLException {
        String insertString = "insert into search (id, criteria) values(?,?)";
        PreparedStatement insertCriteria = connection.prepareStatement(insertString);
        insertCriteria.setString(2, criteriaString);
        if(insertCriteria.execute()){
            return "Criteria successfull save on the Data Base";
        } else {
            return "Criteria was not stored on the Data Base";
        }
    }

    /**
     * This method returns all Criterias from data base
     * */
    public ResultSet getAllCriterials(){
        ResultSet rs;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from search");
            return rs;
        } catch (SQLException e) {
            Log.getInstance().getLogger().error("DB Exception: " + e);
            return null;
        }
    }

    /**
     * This method returns all Criterias from data base
     * */
    public HashMap<String, Object > getHashCriteria(){
        HashMap<String, Object> allCriteria = new HashMap<String,Object>();
        ResultSet allCriterias = getAllCriterials();
        try{
            while(allCriterias.next()){
                SearchCriteria criteria = gson.fromJson(allCriterias.getString("criteria"), SearchCriteria.class);
                allCriteria.put(allCriterias.getString("id"), criteria);
            }
        } catch (Exception e){

        }
        return allCriteria;
    }
}
