package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    private static final Logger log = LogManager.getLogger(LoggerHelper.class);

    public static Logger getLogger(Class<?> cls) {
        return LogManager.getLogger(cls);
    }
}
