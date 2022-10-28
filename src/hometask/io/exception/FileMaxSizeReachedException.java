package hometask.io.exception;

import java.io.IOException;

public class FileMaxSizeReachedException extends IOException {
    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
