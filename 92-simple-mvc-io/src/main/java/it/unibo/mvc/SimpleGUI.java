package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

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
    }

    public static void main(String[] args) {
        final SimpleGUI gui = new SimpleGUI();
        //gui.display();
    }
}
