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
    private final String PATH = System.getProperty("user.home")
            + File.separator
            + Controller.class.getSimpleName() + ".txt";

    public Controller(final File file) {
        this.file = file;
    }

    public String getPATH() {
        return this.PATH;
    }

    public File getFile() {
        final File defensiveCopyFile = this.file;
        return defensiveCopyFile;
    }

    public boolean writeOnFile(final String str) {
        try (PrintStream pStream = new PrintStream(PATH, StandardCharsets.UTF_8)) {
            pStream.print(str);
        } catch (IOException e1) {
            System.out.println(str);
        }
        return false;
    }
}
