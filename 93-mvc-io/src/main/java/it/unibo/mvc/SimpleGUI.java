package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 2;
    private final JFrame frame = new JFrame();

    /**
     * SimpleGUI constructor.
     * 
     * @param controller the controller to use
     */
    public SimpleGUI(final SimpleController controller) {
        final JPanel mainPanel = new JPanel();
        final JPanel buttonsPanel = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        final JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        final JButton btnPrint = new JButton("Print");
        final JButton btnHistory = new JButton("Show history");
        btnPrint.addActionListener((final ActionEvent e) -> {
            controller.setNextStringToPrint(textField.getText());
            controller.printCurrentString();
        });
        btnHistory.addActionListener(e -> {
            textArea.setText("");
            for (final String elem: controller.getPrintedStrings()) {
                textArea.append(elem);
                textArea.append("\n");
            }
        });
        frame.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        frame.add(mainPanel);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        buttonsPanel.add(btnPrint);
        buttonsPanel.add(btnHistory);
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
     * Launch the gui with a new controller.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }
}
