package hometask.io.logger.file_logger;

import hometask.io.exception.FileMaxSizeReachedException;
import hometask.io.logger.AbstractLogger;
import hometask.io.logger.LoggingLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger extends AbstractLogger {
    private final FileLoggerConfiguration fileLoggerConfiguration;
    private String currentPath;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
        currentPath = fileLoggerConfiguration.getPathFileLogger() + String.format("Log_%s.txt", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss.SSS")));

    }

    @Override
    public void debug(String message) {
        if (!fileLoggerConfiguration.getLogginLevel().equals(LoggingLevel.INFO)) {
            checkSizeCurrentFile(message);
            writeLog(message);
        }
    }

    @Override
    public void info(String message) {
        checkSizeCurrentFile(message);
        writeLog(message);
    }

    private void checkSizeCurrentFile(String message) {
        long currentFileSize = new File(currentPath).length();
        int messageSize = message.getBytes().length;

        if (currentFileSize + messageSize >= fileLoggerConfiguration.getMaxSize()) {
            try {
                throw new FileMaxSizeReachedException(fileLoggerConfiguration.getMaxSize(), currentFileSize, currentPath);
            } catch (FileMaxSizeReachedException e) {
                currentPath = createNewFilePath();
            }

        }
    }

    private void writeLog(String message) {
        try {
            FileWriter fileWriter = new FileWriter(currentPath, true);
            BufferedWriter output = new BufferedWriter(fileWriter);
            output.write(messageTemplate(message));
            output.newLine();
            output.flush();
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private String messageTemplate(String message) {
        return String.format(
                fileLoggerConfiguration.getFormatWritting(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm")),
                fileLoggerConfiguration.getLogginLevel(),
                message
        );
    }

    private String createNewFilePath() {
        return String.format("src/hometask/io/logs/Log_%s.txt",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss.SSS")));
    }
}
