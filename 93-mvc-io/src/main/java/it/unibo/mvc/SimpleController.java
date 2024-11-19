package it.unibo.mvc;

import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    @Override
    public void setNextStringToPrint(String str) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNextStringToPrint() {
        throw new UnsupportedOperationException("Not supported yet.");
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
