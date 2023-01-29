package hometask.io;

import hometask.io.logger.AbstractLogger;
import hometask.io.logger.AbstractLoggerConfiguration;
import hometask.io.logger.AbstractLoggerConfigurationLoader;
import hometask.io.logger.file_logger.FileLogger;
import hometask.io.logger.file_logger.FileLoggerConfiguration;
import hometask.io.logger.file_logger.FileLoggerConfigurationLoader;
import hometask.io.logger.stdout_logger.StdoutLogger;
import hometask.io.logger.stdout_logger.StdoutLoggerConfiguration;
import hometask.io.logger.stdout_logger.StdoutLoggerConfigurationLoader;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String configPath = "src/main/java/hometask/io/config/config.properties";

        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfigurationLoader().load(new File(configPath));
        StdoutLoggerConfiguration stdoutLoggerConfiguration = new StdoutLoggerConfigurationLoader().load(new File(configPath));

        AbstractLogger logger = new StdoutLogger(stdoutLoggerConfiguration);

        logger.info("test-1 log-info");
        logger.debug("test-2 log-debug");
        logger.info("test-3 log-info");
        logger.debug("test-4 log-debug");

        logger = new FileLogger(fileLoggerConfiguration);

        logger.info("test-5 log-info");
        logger.debug("test-6 log-debug");
        logger.info("test-7 log-info");
        logger.debug("test-8 log-debug");
    }
}
