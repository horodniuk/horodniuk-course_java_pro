package hometask.io.logger;

import java.io.File;


public abstract class AbstractLoggerConfigurationLoader {
    protected abstract AbstractLoggerConfiguration load(File configFile);
}