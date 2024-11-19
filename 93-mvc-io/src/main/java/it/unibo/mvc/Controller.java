package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * 
     * @param str the next string to print.
     */
    void setNextStringToPrint(String str);

    /**
     * 
     * @return the next string to print
     */
    String getNextStringToPrint();

    /**
     * 
     * @return a List rappresenting the history of printed strings
     */
    List getPrintedStrings();

    /**
     * 
     */
    void printCurrentString();

}
