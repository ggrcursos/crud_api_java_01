package com.crud.ApiCrud.observability;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleLogger {

    public static enum LogLevel {
        ERROR, INFO, DEBUG, WARN
    }

    private final Class<?> fromClass;

    public SimpleLogger(Class<?> fromClass) {
        this.fromClass = fromClass;
    }

    private String getFormattedMessage(LogLevel level, String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = formatter.format(new Date());
        String className = fromClass.getSimpleName();
        return String.format("[%s] [%s] [%s] %s", dateTime, level.name(), className, message);
    }

    public void log(LogLevel level, String message) {
        String output = getFormattedMessage(level, message);
        switch (level) {
            case ERROR:
                System.err.println(output);
                break;
            case INFO:
            case DEBUG:
            case WARN:
                System.out.println(output);
                break;
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}