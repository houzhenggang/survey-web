package edu.akdeniz.softeng.surveyrest.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Mustafa Sisman, Mustafa Fatih
 */

public class LoggerWrapper {

    private final Logger logger;

    public LoggerWrapper(Class<?> clazz) {
        PropertyConfigurator.configure("src/main/resources/log4j-alpha.properties");
        logger = Logger.getLogger(clazz);
    }

    public void info(String parameter) {
        if (logger.isInfoEnabled()) {
            logger.info(parameter);
        }
    }

    public void warn(String parameter) {
        logger.warn(parameter);
    }

    public void debug(String parameter) {
        if (logger.isDebugEnabled()) {
            logger.debug(parameter);
        }
    }

    public void error(String parameter) {
        logger.error(parameter);
    }

    public void fatal(String parameter) {
        logger.fatal(parameter);
    }
}
