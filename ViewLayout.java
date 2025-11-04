// Archivo: ViewLayout.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewLayout {
    private JFrame frame;
    private JLabel counterLabel;
    private JButton increaseButton;
    private JButton decreaseButton;
    
    private ActionListener increaseActionListener;
    private ActionListener decreaseActionListener;
    private final String tag;

    public ViewLayout(String tag) {
        this.tag = tag;
    }

    public void initialize(
        ActionListener increaseActionListener, 
        ActionListener decreaseActionListener
    ) {
        this.increaseActionListener = increaseActionListener;
        this.decreaseActionListener = decreaseActionListener;
        createUI();
    }

    public JLabel getCounterLabel() {
        return counterLabel;
    }

    // --- INICIO: MODIFICACIÓN PASO #3 ---
    // Métodos para habilitar/deshabilitar botones
    public void setIncreaseButtonEnabled(boolean enabled) {
        increaseButton.setEnabled(enabled);
    }

    public void setDecreaseButtonEnabled(boolean enabled) {
        decreaseButton.setEnabled(enabled);
    }
    // --- FIN: MODIFICACIÓN PASO #3 ---

    private void createUI() {
        // Create the main frame
        frame = new JFrame("["+tag+"] + Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create the counter label with centered text
        counterLabel = new JLabel("Counter: 0", SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create the decrease button
        decreaseButton = new JButton("Decrease");
        decreaseButton.addActionListener(decreaseActionListener);        

        // Create the increase button
        increaseButton = new JButton("Increase");
        increaseButton.addActionListener(increaseActionListener);

        // Add buttons to the panel
        buttonPanel.add(decreaseButton);
        buttonPanel.add(increaseButton);

        // Add components to the frame
        frame.add(counterLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Position the window
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}