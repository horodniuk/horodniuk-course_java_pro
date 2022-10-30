package hometask.io.logger;

import java.io.IOException;

public abstract class AbstractLogger {
    public abstract void info(String message) throws IOException;
    public abstract void debug(String message) throws IOException;
}
