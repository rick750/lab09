package it.unibo.mvc;

import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void printCurrentString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
