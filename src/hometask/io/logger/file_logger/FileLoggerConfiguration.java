package hometask.io.logger.file_logger;

import hometask.io.logger.AbstractLoggerConfiguration;
import hometask.io.logger.LoggingLevel;

import java.io.File;

public class FileLoggerConfiguration extends AbstractLoggerConfiguration {
    private String pathFileLogger;
    private long maxSize;

    public FileLoggerConfiguration(LoggingLevel logginLevel, String formatWritting, String pathFileLogger, long maxSize) {
        super(logginLevel, formatWritting);
        this.pathFileLogger = pathFileLogger;
        this.maxSize = maxSize;
    }

    public String getPathFileLogger() {
        return pathFileLogger;
    }

    public LoggingLevel getLogginLevel() {
        return logginLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormatWritting() {
        return formatWritting;
    }


}
