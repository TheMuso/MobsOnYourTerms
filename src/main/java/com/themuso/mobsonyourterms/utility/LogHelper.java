package com.themuso.mobsonyourterms.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.themuso.mobsonyourterms.reference.Reference;

public final class LogHelper
{
    private static Logger logger;

    public static void init(Logger modLogger)
    {
        logger = modLogger;
    }

    public static void debug(Object object)
    {
        logger.debug(object);
    }

    public static void error(Object object)
    {
        logger.error(object);
    }

    public static void fatal(Object object)
    {
        logger.fatal(object);
    }

    public static void info(Object object)
    {
        logger.info(object);
    }

    public static void trace(Object object)
    {
        logger.trace(object);
    }

    public static void warn(Object object)
    {
        logger.warn(object);
    }
}
