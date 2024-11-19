package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.undo.StateEditable;


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
        final JTextArea textArea = new JTextArea();
        final JButton btnSave = new JButton("Save");
        final JTextField textField = new JTextField(controller.getPath());
        textField.setEditable(false);
        final JButton btnBrowse = new JButton("Browse...");
        // Set layout
        frame.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        secondPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        frame.add(mainPanel);
        mainPanel.add(secondPanel, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(btnSave, BorderLayout.SOUTH);
        secondPanel.add(textField);
        secondPanel.add(btnBrowse);
        // Save action
        btnSave.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent save) {
                    // try-catch removed because it generates an error during compilation.
                    controller.writeOnFile(textArea.getText());
                }
            }
        );
        // Browse action
        btnBrowse.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final JFileChooser fileChooser = new JFileChooser("Choose the file to save on");
                    fileChooser.setSelectedFile(controller.getFile());
                    final int actionSelect = fileChooser.showSaveDialog(frame);
                    switch (actionSelect) {
                        case JFileChooser.APPROVE_OPTION:
                            controller.setFile(fileChooser.getSelectedFile());
                            textField.setText(controller.getPath());
                            break;
                        case JFileChooser.CANCEL_OPTION: 
                            // Nothing to do
                            break;
                        default:
                            throw new AssertionError();
                    }
                }                
            };
        );
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
