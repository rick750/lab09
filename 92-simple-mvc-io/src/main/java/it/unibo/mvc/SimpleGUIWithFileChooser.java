package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame();

    /**
     * Constructor of a SimpleGUIWithFileChooser.
     * 
     * @param controller the controller to use
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel mainPanel = new JPanel();
        final JPanel secondPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton btnSave = new JButton("Save");
        final JTextField textField = new JTextField(controller.getPath());
        textField.setEditable(false);
        final JButton btnBrowse = new JButton("Browse...");
        frame.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        secondPanel.setLayout(new BorderLayout());
        frame.add(mainPanel);
        mainPanel.add(secondPanel, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(btnSave, BorderLayout.SOUTH);
        secondPanel.add(textField, BorderLayout.CENTER);
        secondPanel.add(btnBrowse, BorderLayout.LINE_END);
        btnSave.addActionListener(e -> {
            controller.writeOnFile(textArea.getText());
        });
        btnBrowse.addActionListener(e -> {
            final JFileChooser fileChooser = new JFileChooser("Choose the file to save on");
            fileChooser.setSelectedFile(controller.getFile());
            final int actionSelected = fileChooser.showSaveDialog(frame);
            switch (actionSelected) {
                case JFileChooser.APPROVE_OPTION:
                    controller.setFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getPath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    // Nothing to do
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, actionSelected, "An error occurred", JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.setContentPane(mainPanel);
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
     * Create a new SimpleGUIWithFileChooser and make it start.
     * 
     * @param args the argument passed when the file is called.
     */
    public static void main(final String[] args) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }
}
