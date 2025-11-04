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

    public void setIncreaseButtonEnabled(boolean enabled) {
        increaseButton.setEnabled(enabled);
    }

    public void setDecreaseButtonEnabled(boolean enabled) {
        decreaseButton.setEnabled(enabled);
    }

    private void createUI() {
        frame = new JFrame("["+tag+"] + Counter");
        
        // --- CORRECCIÓN 1: No cerrar todo el programa al cerrar una ventana ---
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        counterLabel = new JLabel("Counter: 0", SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        decreaseButton = new JButton("Decrease");
        decreaseButton.addActionListener(decreaseActionListener);        

        increaseButton = new JButton("Increase");
        increaseButton.addActionListener(increaseActionListener);

        buttonPanel.add(decreaseButton);
        buttonPanel.add(increaseButton);

        frame.add(counterLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // --- CORRECCIÓN 2: Posiciones fijas para que no se tapen ---
        if ("1ST".equals(tag)) {
            frame.setLocation(300, 300); // Posición Ventana 1
        } else if ("2ND".equals(tag)) {
            frame.setLocation(700, 300); // Posición Ventana 2
        } else {
             frame.setLocationRelativeTo(null); 
        }
        
        frame.setVisible(true);
    }
}