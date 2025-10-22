package lld.logger;

// Logger Singleton Class
class Logger {
    // private static instance
    private static Logger instance;

    // private constructor to prevent instantiation
    private Logger() { }

    // Thread-safe lazy initialization
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Log levels
    public enum LogLevel { INFO, WARN, ERROR }

    // Log a message
    public void log(LogLevel level, String message) {
        String timeStamp = java.time.LocalDateTime.now().toString();
        System.out.println("[" + timeStamp + "] [" + level + "] " + message);
    }

    // Convenience methods
    public void info(String message) { log(LogLevel.INFO, message); }
    public void warn(String message) { log(LogLevel.WARN, message); }
    public void error(String message) { log(LogLevel.ERROR, message); }
}

// Demo
public class LoggerDemo {
    public static void main(String[] args) {
        try {
            Logger logger1 = Logger.getInstance();
            Logger logger2 = Logger.getInstance();

            // Verify singleton
            System.out.println("Are both instances same? " + (logger1 == logger2));

            logger1.info("Application started");
            logger1.warn("Low disk space");
            logger1.error("Unhandled exception occurred");

            logger2.info("Logging from second reference");

        } catch (Exception e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}
