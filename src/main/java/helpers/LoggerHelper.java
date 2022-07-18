package helpers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
    private static Logger log;

    public static Logger getLogger(Class log) {
        if (log == null) {
            return Logger.getLogger(log);
        }
        PropertyConfigurator.configure("log4j.properties");
        return Logger.getLogger(log);
    }
}
