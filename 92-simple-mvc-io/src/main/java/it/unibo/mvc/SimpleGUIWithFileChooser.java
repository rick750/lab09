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

    public SimpleGUIWithFileChooser(final Controller controller) {
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

    /**
     * Set the frame as visible.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Create a new SimpleGUIWithFileChooser and make it start.
     * 
     * @param args the argument passed when the file is called.
     */
    public static void main(final String[] args) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }
}
