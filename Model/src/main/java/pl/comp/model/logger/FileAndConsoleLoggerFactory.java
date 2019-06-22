package pl.comp.model.logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FileAndConsoleLoggerFactory {

    private static boolean loggerConfigured = false;

    public static Logger getConfiguredLogger(final String name) {
        if (!loggerConfigured) {
            try (InputStream stream = FileAndConsoleLoggerFactory.class.getResourceAsStream("/logging.properties")) {
                LogManager.getLogManager().readConfiguration(stream);
                loggerConfigured = true;
            } catch (IOException e) {
            }
        }
        return Logger.getLogger(name);
    }
}
