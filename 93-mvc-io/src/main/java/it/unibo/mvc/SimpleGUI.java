package it.unibo.mvc;

import javax.swing.JFrame;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    public SimpleGUI(final Controller controller) {
        
    }

    /**
     * Set the frame as visible
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Launch the gui with a new controller
     */
    public static void main(String[] args) {
        private final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }
}
