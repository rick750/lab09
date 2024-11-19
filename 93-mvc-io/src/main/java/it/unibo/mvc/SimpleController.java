package it.unibo.mvc;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;
    private final List<String> history = new LinkedList<>();

    @Override
    public void setNextStringToPrint(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null values are not acceptable");
        }
        this.nextString = str;
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    @Override
    public List getPrintedStrings() {
        return List.copyOf(history);
    }

    @Override
    public void printCurrentString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
