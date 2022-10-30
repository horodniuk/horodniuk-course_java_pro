package hometask.io.exception;

public class FileMaxSizeReachedException extends RuntimeException {
    public FileMaxSizeReachedException(long maxSize, long currentSize, String path) {
        System.err.println("Maximum file size reached : max size file - " + maxSize +
                           " current size file - " + currentSize + ", Path to file - " +
                           path);
    }
}
