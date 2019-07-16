import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
  private static final Logger loggerInstance = new Logger();

  public static enum LogLevel {
    INFO, ERROR, WARNING, FATAL
  }

  private Logger() {
  }

  public static Logger getInstance() {
    return loggerInstance;
  }

  public void log(String className, LogLevel level, String message) {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println(formattedDate + " " + className + " " + level + " " + message);
  }
}
