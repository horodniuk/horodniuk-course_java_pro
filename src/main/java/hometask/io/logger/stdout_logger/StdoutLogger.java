package hometask.io.logger.stdout_logger;

import hometask.io.logger.AbstractLogger;
import hometask.io.logger.AbstractLoggerConfiguration;
import hometask.io.logger.LoggingLevel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StdoutLogger extends AbstractLogger {
    StdoutLoggerConfiguration loggerConfiguration;

    public StdoutLogger(StdoutLoggerConfiguration loggerConfiguration) {
        this.loggerConfiguration = loggerConfiguration;
    }

    @Override
    public void info(String message) {
        System.out.println(messageTemplate(message));
    }

    @Override
    public void debug(String message) {
        if (!loggerConfiguration.getLogginLevel().equals(LoggingLevel.INFO)) {
            System.out.println(messageTemplate(message));
        }
    }

    private String messageTemplate(String message) {
        return String.format(
                loggerConfiguration.getFormatWritting(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm")),
                loggerConfiguration.getLogginLevel(),
                "Message ",
                message);
    }
}
