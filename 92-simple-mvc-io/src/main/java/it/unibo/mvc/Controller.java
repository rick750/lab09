package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
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
        } catch (IOException e1) {
            System.out.println(str);
        }
    }
}
