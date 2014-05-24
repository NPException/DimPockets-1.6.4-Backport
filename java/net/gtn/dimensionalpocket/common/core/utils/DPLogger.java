package net.gtn.dimensionalpocket.common.core.utils;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import cpw.mods.fml.relauncher.Side;

public class DPLogger {

    public static DPLogger log = new DPLogger();
    static Side side;

    private Logger dpLogger;

    public DPLogger() {
    }

    public static void init(Logger logger) {
        log.dpLogger = logger;
    }

    private static void log(Level logLevel, String levelName, Class<?> srcClass, Object object) {
        StringBuilder sb = new StringBuilder(levelName);
        if (srcClass != null)
            sb.append("<").append(srcClass.getSimpleName()).append("> ");
        sb.append(object);
        log.dpLogger.log(logLevel, sb.toString());
    }

    public static void info(Object object) {
        info(object, null);
    }

    public static void info(Object object, Class<?> srcClass) {
        log(Level.INFO, "[INFO] ", srcClass, object);
    }

    public static void debug(Object object) {
        debug(object, null);
    }

    public static void debug(Object object, Class<?> srcClass) {
        log(Level.FINEST, "[DEBUG] ", srcClass, object);
    }

    public static void warning(Object object) {
        warning(object, null);
    }

    public static void warning(Object object, Class<?> srcClass) {
        log(Level.WARNING, "[WARNING] ", srcClass, object);
    }

    public static void severe(Object object) {
        severe(object, null);
    }

    public static void severe(Object object, Class<?> srcClass) {
        log(Level.SEVERE, "[SEVERE] ", srcClass, object);
    }

    public static Logger getLogger() {
        return log.dpLogger;
    }

}
