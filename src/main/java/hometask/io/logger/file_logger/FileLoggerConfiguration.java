package hometask.io.logger.file_logger;

import hometask.io.logger.AbstractLoggerConfiguration;
import hometask.io.logger.LoggingLevel;

public class FileLoggerConfiguration extends AbstractLoggerConfiguration {
    private final String pathFileLogger;
    private final long maxSize;

    public FileLoggerConfiguration(LoggingLevel logginLevel, String formatWritting, String pathFileLogger, long maxSize) {
        super(logginLevel, formatWritting);
        this.pathFileLogger = pathFileLogger;
        this.maxSize = maxSize;
    }

    public String getPathFileLogger() {
        return pathFileLogger;
    }

    public long getMaxSize() {
        return maxSize;
    }
}
