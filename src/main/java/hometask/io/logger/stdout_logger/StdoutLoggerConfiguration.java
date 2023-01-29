package hometask.io.logger.stdout_logger;

import hometask.io.logger.AbstractLoggerConfiguration;
import hometask.io.logger.LoggingLevel;

public class StdoutLoggerConfiguration extends AbstractLoggerConfiguration {
    public StdoutLoggerConfiguration(LoggingLevel logginLevel, String formatWritting) {
        super(logginLevel, formatWritting);
    }
}
