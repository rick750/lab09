package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
        // Creating components
        final JPanel mainPanel = new JPanel();
        final JPanel secondPanel = new JPanel();
        final JTextField textField = new JTextField();
        final JButton btnBrowse = new JButton("Browse...");
        // Set layout
        frame.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        secondPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        frame.add(mainPanel);
        mainPanel.add(secondPanel, BorderLayout.NORTH);
        secondPanel.add(textField);
        secondPanel.add(btnBrowse);
    }
}
