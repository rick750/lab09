package it.unibo.mvc;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {    
    private static final int PROPORTION = 2;
    private final JFrame frame = new JFrame();

    public SimpleGUI(final Controller controller) {
        // Components
        final JPanel panel = new JPanel();
        final JTextArea textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton btnPrint = new JButton("Print");
        final JButton btnHistory = new JButton("Show history");
        // Set layout
        frame.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(btnPrint, BorderLayout.SOUTH);
        panel.add(btnHistory, BorderLayout.SOUTH);
        // Frame appearence instructions
        frame.setContentPane(panel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        // Behavior on exit
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
