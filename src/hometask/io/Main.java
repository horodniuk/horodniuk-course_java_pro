package hometask.io;

import hometask.io.logger.file_logger.FileLogger;
import hometask.io.logger.file_logger.FileLoggerConfiguration;

public class Main {
    public static void main(String[] args) {
        FileLogger logger = new FileLogger(new FileLoggerConfiguration());
        logger.info("test-1 log-info");
        logger.debug("test-2 log-debug");
        logger.info("test-3 log-info");
    }
}
