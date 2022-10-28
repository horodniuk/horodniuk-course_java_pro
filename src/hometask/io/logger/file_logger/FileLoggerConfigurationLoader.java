package hometask.io.logger.file_logger;

import hometask.io.logger.AbstractLoggerConfigurationLoader;
import hometask.io.logger.LoggingLevel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader extends AbstractLoggerConfigurationLoader {
    @Override
    public FileLoggerConfiguration load(File configFile) throws IOException {
        FileReader reader = new FileReader(configFile);
        Properties p = new Properties();
        p.load(reader);

        File file = new File(p.getProperty("FILE"));
        LoggingLevel loggingLevel = LoggingLevel.valueOf(p.getProperty("LEVEL"));
        long maxSize = Byte.parseByte(p.getProperty("MAX-SIZE"));
        String formatWritting = p.getProperty("FORMAT");

        reader.close();
        return new FileLoggerConfiguration(loggingLevel, formatWritting, file, maxSize);
    }
}
