package hometask.io.logger.file_logger;

import hometask.io.logger.AbstractLoggerConfigurationLoader;
import hometask.io.logger.LoggingLevel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader extends AbstractLoggerConfigurationLoader {
    @Override
    public FileLoggerConfiguration load(File configFile) {
        String pathFileLogger = null;
        LoggingLevel loggingLevel = null;
        long maxSize = 0;
        String formatWritting = null;

        try (FileReader reader = new FileReader(configFile)) {
            Properties p = new Properties();
            p.load(reader);

            pathFileLogger = p.getProperty("FILE_PATH");
            loggingLevel = LoggingLevel.valueOf(p.getProperty("LEVEL"));
            maxSize = Long.parseLong((p.getProperty("MAX-SIZE")));
            formatWritting = p.getProperty("FORMAT");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileLoggerConfiguration(loggingLevel, formatWritting, pathFileLogger, maxSize);
    }
}
