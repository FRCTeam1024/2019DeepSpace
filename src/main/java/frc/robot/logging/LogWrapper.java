package frc.robot.logging;

import java.util.logging.*;

public class LogWrapper {

    private Logger mLog;

    // See here for a bunch of useful code
    //  https://github.com/FRC3620/FRC3620_2015_AverageJava/blob/master/FRC3620_2015_AverageJava/src/org/usfirst/frc3620/EventLogging.java

    /**
     * Wrap an instance of java.util.logging.Logger with more useful logging methods
     * @param logClass
     */
    public LogWrapper(String logClass) {
        mLog = Logger.getLogger(logClass);
    }


    public void info(String msg) {
        if (mLog.isLoggable(Level.INFO)) {
            mLog.log(Level.INFO, msg);
        }
    }

    /**
     * @param msg   message in a java.text.MessageFormat format
     * @param params
     */
    public void infomf(String msg, Object... params) {
        if (mLog.isLoggable(Level.INFO)) {
            mLog.log(Level.INFO, msg, params);
        }
    }


    /**
     * @param msg   message in String.format() format
     * @param params
     */
    public void info(String msg, Object... params) {
        if (mLog.isLoggable(Level.INFO)) {
            mLog.log(Level.INFO, String.format(msg, params));
        }
    }


    public void debug(String msg) {
        if (mLog.isLoggable(Level.FINE)) {
            mLog.log(Level.FINE, msg);
        }
    }

    public void debugmf(String msg, Object... params) {
        if (mLog.isLoggable(Level.FINE)) {
            mLog.log(Level.FINE, msg, params);
        }
    }

    public void debug(String msg, Object... params) {
        if (mLog.isLoggable(Level.FINE)) {
            mLog.log(Level.FINE, String.format(msg, params));
        }
    }


    public void severe(String msg, Object... params) {
        if (mLog.isLoggable(Level.SEVERE)) {
            mLog.log(Level.SEVERE, String.format(msg, params));
        }
    }

    public void severe(Throwable t, String msg, Object... params) {
        if (mLog.isLoggable(Level.SEVERE)) {
            mLog.log(Level.SEVERE, "*****************************************************************************");
            mLog.log(Level.SEVERE, String.format(msg + "\n" + exceptionToString(t), params), t);
            mLog.log(Level.SEVERE, "*****************************************************************************");
        }
    }


    /**
     * Create a String representation of an Exception.
     * 
     * @param t
     * @return
     */
    public static final String exceptionToString(Throwable t) {
        final StackTraceElement[] stackTrace = t.getStackTrace();
        final StringBuilder message = new StringBuilder();
        final String padding = "--    ";
        final Throwable cause = t.getCause();

        message.append(padding).append("Exception: ").append(t.getClass().getName()).append('\n');
        message.append(padding).append("Message: ").append(t.getMessage()).append('\n');
        message.append(padding).append('\n');
        for (int i = 0; i < stackTrace.length; i++) {
            message.append(padding).append(stackTrace[i]).append('\n');
        }

        if (cause != null) {
            final StackTraceElement[] causeTrace = cause.getStackTrace();
            message.append(padding).append("Caused by ").append(cause.getClass().getName()).append('\n');
            message.append(padding).append("Because: ").append(cause.getMessage()).append('\n');
            message.append(padding).append(causeTrace[0]).append('\n');
            message.append(padding).append(causeTrace[2]).append('\n');
            message.append(padding).append(causeTrace[3]);
        }

        return message.toString();
    }


}