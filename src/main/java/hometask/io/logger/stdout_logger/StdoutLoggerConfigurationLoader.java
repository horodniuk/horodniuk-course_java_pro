package hometask.io.logger.stdout_logger;

import hometask.io.logger.AbstractLoggerConfigurationLoader;
import hometask.io.logger.LoggingLevel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StdoutLoggerConfigurationLoader extends AbstractLoggerConfigurationLoader {
    @Override
    public StdoutLoggerConfiguration load(File configFile) {
        try (FileReader reader = new FileReader(configFile)) {
            Properties p = new Properties();
            p.load(reader);
            return new StdoutLoggerConfiguration(
                    LoggingLevel.valueOf(p.getProperty("LEVEL")),
                    p.getProperty("FORMAT"));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
