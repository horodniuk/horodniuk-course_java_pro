package hometask.io.logger;

public abstract class AbstractLoggerConfiguration {
    private final LoggingLevel logginLevel;
    private final String formatWritting;

    public AbstractLoggerConfiguration(LoggingLevel logginLevel, String formatWritting) {
        this.logginLevel = logginLevel;
        this.formatWritting = formatWritting;
    }

    public LoggingLevel getLogginLevel() {
        return logginLevel;
    }

    public String getFormatWritting() {
        return formatWritting;
    }
}
