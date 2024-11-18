package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Constructor of a SimpleGUI.
     */
    public SimpleGUI() {
        final BorderLayout brdLayout = new BorderLayout();
        frame.setLayout(brdLayout);
        final JPanel panel = new JPanel();
        panel.setLayout(brdLayout);
        frame.add(panel, BorderLayout.SOUTH);
        final JTextArea textArea = new JTextArea();
        final JButton bSave = new JButton("Save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(bSave, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        /**
         * Make the frame one fifth the resolution of the screen.
        */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /** 
         * The OS window manager take care of the default positioning
         * on screen.
         */
        frame.setLocationByPlatform(true);
        /**
         * Resize the frame to the minimum size prior to displaying.
        */
        frame.pack();
    }

    /**
     * Set the frame as visible.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Create a new SimpleGUI and make it start.
     * 
     * @param args the argument passed when the file is called.
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI();
        gui.display();
    }
}
