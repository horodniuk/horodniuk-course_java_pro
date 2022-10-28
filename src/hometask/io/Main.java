package hometask.io;

import hometask.io.logger.AbstractLogger;
import hometask.io.logger.file_logger.FileLogger;
import hometask.io.logger.file_logger.FileLoggerConfiguration;
import hometask.io.logger.file_logger.FileLoggerConfigurationLoader;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String configPath = "src/hometask/io/config/config.properties";

        FileLoggerConfiguration fileLoggerConfiguration =
                new FileLoggerConfigurationLoader().load(new File(configPath));

        AbstractLogger fileLogger = new FileLogger(fileLoggerConfiguration);

        fileLogger.debug("debug");
        fileLogger.info("info");
    }
}
