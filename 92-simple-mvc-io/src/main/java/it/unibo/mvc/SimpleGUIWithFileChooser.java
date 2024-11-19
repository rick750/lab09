package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 3;
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
        // Frame appearence instructions
        frame.setContentPane(mainPanel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        // Behavior on exit
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
