package hometask.io.logger;

import java.io.File;
import java.io.IOException;

public abstract class AbstractLoggerConfigurationLoader {
    protected abstract AbstractLoggerConfiguration load(File configFile) throws IOException;
}
