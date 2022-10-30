package hometask.io.logger;

import java.io.File;

public abstract class AbstractLoggerConfigurationLoader {
    public abstract AbstractLoggerConfiguration load(File configFile);
}