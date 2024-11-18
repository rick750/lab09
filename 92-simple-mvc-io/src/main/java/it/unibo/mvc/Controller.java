package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private final File file;
    private boolean setted = false;
    private final String PATH = System.getProperty("user.home")
            + File.separator;
    private final String DEF_NAME = "output.txt";

    public Controller(final File file) {
        this.file = file;
        this.setted = true;
    }

    public String getPath() {
        if (!setted) {
            return this.PATH + this.DEF_NAME;
        }
        return this.file.getPath();
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
