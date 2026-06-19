public class Logger {

    private static Logger loggerObject;

    private Logger() {
        System.out.println("Logger initialized");
    }

    public static Logger getLogger() {
        if (loggerObject == null) {
            loggerObject = new Logger();
        }
        return loggerObject;
    }

    public void writeLog(String text) {
        System.out.println("[LOG ENTRY] " + text);
    }
}