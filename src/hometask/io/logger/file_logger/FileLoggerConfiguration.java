package hometask.io.logger.file_logger;

import hometask.io.logger.AbstractLoggerConfiguration;
import hometask.io.logger.LoggingLevel;

import java.io.File;

public class FileLoggerConfiguration extends AbstractLoggerConfiguration {
    private File file;
    private long maxSize;

    public FileLoggerConfiguration(LoggingLevel logginLevel, String formatWritting, File file, long maxSize) {
        super(logginLevel, formatWritting);
        this.file = file;
        this.maxSize = maxSize;
    }

    public File getFile() {
        return file;
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

    public void setFile(File file) {
        this.file = file;
    }

    public void setLogginLevel(LoggingLevel logginLevel) {
        this.logginLevel = logginLevel;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public void setFormatWritting(String formatWritting) {
        this.formatWritting = formatWritting;
    }
}
