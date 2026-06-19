public class LoggerDemo {

    public static void main(String[] args) {

        Logger firstRef = Logger.getLogger();
        Logger secondRef = Logger.getLogger();

        firstRef.writeLog("Application started");
        secondRef.writeLog("Processing request");

        if (firstRef == secondRef) {
            System.out.println("Both references point to the same object.");
        }
    }
}
