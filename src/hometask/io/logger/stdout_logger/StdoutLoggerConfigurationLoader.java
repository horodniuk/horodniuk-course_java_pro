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
        Properties p = new Properties();

        try (FileReader reader = new FileReader(configFile)) {
            p = new Properties();
            p.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StdoutLoggerConfiguration(
                LoggingLevel.valueOf(p.getProperty("LEVEL")),
                p.getProperty("FORMAT"));
    }
}
