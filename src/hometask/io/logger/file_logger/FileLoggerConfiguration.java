package hometask.io.logger.file_logger;

import hometask.io.logger.LoggingLevel;

public class FileLoggerConfiguration {
    private final LoggingLevel logginLevel = LoggingLevel.DEBUG;
    private final String formatWritting = "%s %s %s %s";
    private final String pathFileLogger = "src/hometask/io/logs/";
    private final long maxSize = 100;

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
