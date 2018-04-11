/*
 * Log .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search.common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*
 * Singleton class to manage single logger class
 * @version  1.0
 * @author Eliana Navia
 */
public class Log {
    private static Log instance;
    Logger log = Logger.getLogger(getClass());

    /**
     * Log class constructor
     */
    private Log() {
        PropertyConfigurator.configure("log4j.properties");
    }

    /**
     * Method that return a single instance of log
     * @return single log instance
     */
    public static Log getInstance() {
        if(instance == null) {
            instance = new Log();
        }
        return instance;
    }

    /**
     * Method to get Logger
     * @return Logger instance
     */
    public Logger getLogger() {
        return log;
    }
}
