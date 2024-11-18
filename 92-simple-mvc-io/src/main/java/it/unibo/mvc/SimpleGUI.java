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

    public SimpleGUI() {
        frame.setLayout(new BorderLayout());
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.SOUTH);
        final JTextArea textArea = new JTextArea();
        final JButton bSave = new JButton("Save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(bSave, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void display() {
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
         * Resize the frame to the minimum size prior to displaying
        */
        frame.pack();
        /**
         *  Set the frame as visible 
         */        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final SimpleGUI gui = new SimpleGUI();
        gui.display();
    }
}
