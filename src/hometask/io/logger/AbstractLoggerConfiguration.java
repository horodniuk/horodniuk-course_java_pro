package hometask.io.logger;

public abstract class AbstractLoggerConfiguration {
    protected LoggingLevel logginLevel;
    protected String formatWritting;

    public AbstractLoggerConfiguration(LoggingLevel logginLevel, String formatWritting) {
        this.logginLevel = logginLevel;
        this.formatWritting = formatWritting;
    }
}
