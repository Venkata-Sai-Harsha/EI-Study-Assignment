package Exercise_1.Creational_Design_pattern;
//usecase-3: Singleton Pattern [Creational]

// Singleton Logger class
class Logger {
    // Static variable to hold the single instance of the Logger
    private static Logger loggerInstance;
    
    // Private constructor to prevent instantiation from outside
    private Logger() { }
    
    // Public method to get the single instance
    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }
    
    // Logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Demo to test Singleton Pattern
public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Both logger1 and logger2 should point to the same instance
        logger1.log("Singleton pattern demo - This is the first log message.");
        logger2.log("This is the second log message.");
        
        // Check if both instances are the same
        System.out.println("logger1 == logger2: " + (logger1 == logger2));  // Should print true
    }
}
