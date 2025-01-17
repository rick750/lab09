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
    private static final int PROPORTION = 2;
    private final JFrame frame = new JFrame();

    /**
     * Constructor of a SimpleGUI.
     * 
     * @param controller the controller to use
     */
    public SimpleGUI(final Controller controller) {
        frame.setLayout(new BorderLayout());
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        final JTextArea textArea = new JTextArea();
        final JButton bSave = new JButton("Save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(bSave, BorderLayout.SOUTH);
        bSave.addActionListener(e -> {
            controller.writeOnFile(textArea.getText());
        });
        frame.setContentPane(panel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }
}
