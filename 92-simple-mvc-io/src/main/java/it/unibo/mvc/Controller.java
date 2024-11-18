package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final Logger logger = Logger.getLogger(System.class.getName());
    private static final String DEF_PATH = System.getProperty("user.home");
    private static final String DEF_NAME = "output.txt";
    private final File file = new File(DEF_PATH + File.separator + DEF_NAME);

    public String getPath() {
        return DEF_PATH;
    }

    public File getFile() {
        return this.file;
    }

    public void writeOnFile(final String str) {
        try (PrintStream pStream = new PrintStream(getPath(), StandardCharsets.UTF_8)) {
            pStream.print(str);
        } catch (FileNotFoundException e1) {
            logger.log(Level.SEVERE, "File not found", e1);
        } catch (IOException e2) {
            logger.log(Level.SEVERE, "IOException thrown", e2);
        }
    }
}
