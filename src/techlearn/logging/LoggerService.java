package techlearn.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerService {
    private static final LoggerService INSTANCE = new LoggerService();
    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LoggerService() {
    }

    public static LoggerService getInstance() {
        return INSTANCE;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        System.out.println(timestamp + " - " + message);
    }
}
