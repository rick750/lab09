package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final Logger LOG = Logger.getLogger(System.class.getName());
    private static final String DEF_PATH = System.getProperty("user.home");
    private static final String DEF_NAME = "output.txt";
    private final File file = new File(DEF_PATH + File.separator + DEF_NAME);

    /**
     * Provides the current file path
     * 
     * @return the current file path
     */
    public String getPath() {
        return this.file.getPath();
    }

    /**
     * Provides the current file
     * 
     * @return the current file
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Writes {@code str} in the current file
     * 
     * @param str
     */
    public void writeOnFile(final String str) {
        try (PrintStream pStream = new PrintStream(getPath(), StandardCharsets.UTF_8)) {
            pStream.print(str);
        } catch (IOException e2) {
            LOG.log(Level.SEVERE, "IOException thrown", e2);
        }
    }
}
