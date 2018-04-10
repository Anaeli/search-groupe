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
    Logger log = Logger.getLogger(getClass());

    private Log() {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static Log getInstance() {
        return new Log();
    }

}
