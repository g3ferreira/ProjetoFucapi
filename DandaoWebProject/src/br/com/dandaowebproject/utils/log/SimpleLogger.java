/************************************************************************************************************
 * @filename    SimpleLogger.java                                                                            
 * @copyright   (c) 2012 - Instituto Ambiental e Tecnologico da Amazonia. ALL RIGHTS RESERVED        
 * @brief                                                                                           
 *                                                                                                    
 * @details                                                                                         
 *                                                                                                    
 * @author      Luis Iuri Vieira                                                                    
 * @since       18-set-2012 08:45:15                                                                        
 *                                                                                                    
 * @sa                                                                                                                                                                                   $$
 ***********************************************************************************************************/

package br.com.dandaowebproject.utils.log;

import org.apache.log4j.Logger;

/**
 * Abstration of log4J calls
 * 
 * @author Genilson Ferreira <gr.ferreira@live.com>
 * 
 * @version 1.0
 * @created 16-04-2014 10:44:15
 */
public class SimpleLogger {

    public static final int CATEGORY_DEBUG = 1;

    public static final int CATEGORY_INFO = 2;

    public static final int CATEGORY_WARNING = 3;

    public static final int CATEGORY_ERROR = 4;

    public static final int CATEGORY_FATAL = 5;

    // Logger object
    private Logger sLogger;

    // Logging category keys
    private boolean logDebug = false;
    private boolean logInfo = false;
    private boolean logWarn = false;
    private boolean logError = false;
    private boolean logFatal = false;

    /**
     * Constructor using Log4J configuration
     * 
     * @param className
     */
    public SimpleLogger(String className) {

        this.sLogger = Logger.getLogger(className);

    }

    
    /**
     * Constructor using Log4J configuration
     * 
     * @param className
     */
    public SimpleLogger(String className, int loglevel) {

        this.sLogger = Logger.getLogger(className);
        setLogLevel(loglevel);
    }
    
    /**
     * Return sLogger content
     * 
     * @return
     */
    public Logger GetLogger() {

        return this.sLogger;
    }

    /**
     * Create a debug logging category
     * 
     * @param message
     */
    public void debug(String message) {

        if (logDebug == true) {
            sLogger.debug(message);
        }
    }

    /**
     * Create a info logging category
     * 
     * @param message
     */
    public void info(String message) {

        if (logInfo == true) {
            sLogger.info(message);
        }
    }

    /**
     * Create a warning logging category
     * 
     * @param message
     */
    public void warn(String message) {

        if (logWarn == true) {
            sLogger.warn(message);
        }
    }

    /**
     * Create a error logging
     * 
     * @param message
     */
    public void error(String message) {

        if (logError == true) {
            sLogger.error(message);
        }
    }

    /**
     * Create a fatal logging category
     * 
     * @param message
     */
    public void fatal(String message) {

        if (logFatal == true) {
            sLogger.fatal(message);
        }
    }

    /**
     * Activate or deactivate a specific logging category
     * 
     * @param category
     * @param key
     */
    public void setLog(int category, boolean key) {

        switch(category){
        case CATEGORY_DEBUG:
        	setLogDebug(key);
            break;
        case CATEGORY_INFO:
        	setLogInfo(key);
            break;
        case CATEGORY_WARNING:
        	setLogWarn(key);
        	break;
        case CATEGORY_ERROR:
        	setLogError(key);
        	break;
        case CATEGORY_FATAL:
        	setLogFatal(key);
        	break;
        default:
            setLogWarn(key);
        }
    }

    /**
     * Activate a specific logging level possible log levels: fatal, error, warn, info, debug.
     * 
     * @param level
     */
    public void setLogLevel(int level) {
        
    	 switch(level){
         case CATEGORY_DEBUG:
         	setLogDebug(true);
         	setLogInfo(true);
         	setLogWarn(true);
         	setLogError(true);
         	setLogFatal(true);
             break;
         case CATEGORY_INFO:
        	 setLogInfo(true);
        	 setLogWarn(true);
        	 setLogError(true);
        	 setLogFatal(true);
         case CATEGORY_WARNING:
        	 setLogWarn(true);
        	 setLogError(true);
        	 setLogFatal(true);
         case CATEGORY_ERROR:
        	 setLogError(true);
        	 setLogFatal(true);
         case CATEGORY_FATAL:
        	 setLogFatal(true);
         default:
        	 
    	 }
    }

    /**
     * Activate every debug loggers
     * 
     * @param key
     */
    private void setLogDebug(boolean key) {

        logDebug = key;
    }

    /**
     * Activate every info loggers
     * 
     * @param key
     */
    private void setLogInfo(boolean key) {

        logInfo = key;
    }

    /**
     * Activate every warn loggers
     * 
     * @param key
     */
    private void setLogWarn(boolean key) {
        
        logWarn = key;
    }

    /**
     * Activate every error loggers
     * 
     * @param key
     */
    private void setLogError(boolean key) {

        logError = key;
    }

    /**
     * Activate every fatal loggers
     * 
     * @param key
     */
    public void setLogFatal(boolean key) {

        logFatal = key;
    }

    /**
	 * 
	 */
    public void finalize() throws Throwable {

    }

}