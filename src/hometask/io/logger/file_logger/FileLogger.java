package hometask.io.logger.file_logger;

import hometask.io.exception.FileMaxSizeReachedException;
import hometask.io.logger.AbstractLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger extends AbstractLogger {
    private FileLoggerConfiguration fileLoggerConfiguration;
    private File currentFileForLogging;


    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
        currentFileForLogging = new File(String.valueOf(fileLoggerConfiguration.getFile()));
    }

    @Override
    public void debug(String message) throws IOException {
        writeLog(currentFileForLogging, message);
    }

    @Override
    public void info(String message) throws IOException {
        if (fileLoggerConfiguration.getLogginLevel().toString().equals("INFO")) {
            writeLog(currentFileForLogging, message);
        }
    }

    private void writeLog(File file, String message) throws IOException {
        checkFileSize();

        String data = String.format(
                fileLoggerConfiguration.getFormatWritting(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                fileLoggerConfiguration.getLogginLevel(),
                message
        );
        try {
            FileWriter fileWriter = new FileWriter(currentFileForLogging, true);
            BufferedWriter output = new BufferedWriter(fileWriter);
            output.write(data);
            output.newLine();
            output.flush();
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void updateLoggerFile() {
        try {
            throw new FileMaxSizeReachedException(
                    "Maximum file size reached : max size file - " + fileLoggerConfiguration.getMaxSize() +
                    " current size file - " + fileLoggerConfiguration.getFile().length() + " Path to file - " +
                    currentFileForLogging.getPath());
        } catch (FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
        currentFileForLogging = new File(String.format("src/hometask/io/logs/Log_%s.txt", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"))));
        fileLoggerConfiguration.setFile(currentFileForLogging);
    }

    private void checkFileSize() {
        System.out.println(fileLoggerConfiguration.getFile().length());
        if (fileLoggerConfiguration.getFile().length() >= fileLoggerConfiguration.getMaxSize()) {
            updateLoggerFile();
        }
        ;
    }
}
