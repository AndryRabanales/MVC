package control; // <-- LÍNEA AÑADIDA

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import display.DisplayViewLayout; // <-- LÍNEA AÑADIDA

public class ControlViewLayout extends DisplayViewLayout {

    private JButton increaseButton;
    private JButton decreaseButton;
    
    // --- NUEVO CAMPO (2B) ---
    private JButton resetButton;
    // ------------------------

    private ActionListener increaseActionListener;
    private ActionListener decreaseActionListener;

    // --- NUEVO CAMPO (2B) ---
    private ActionListener resetActionListener;
    // ------------------------

    public ControlViewLayout(String tag) {
        super(tag);
    }

    // --- MÉTODO MODIFICADO (2B) ---
    public void setListeners(
        ActionListener increaseActionListener, 
        ActionListener decreaseActionListener,
        ActionListener resetActionListener
    ) {
        this.increaseActionListener = increaseActionListener;
        this.decreaseActionListener = decreaseActionListener;        
        this.resetActionListener = resetActionListener;
    }
    // ------------------------------

    public JButton getDecreaseButton() {
        return decreaseButton;
    }

    public JButton getIncreaseButton() {
        return increaseButton;
    }

    // --- NUEVO MÉTODO (2B) ---
    public JButton getResetButton() {
        return resetButton;
    }
    // -------------------------
    
    @Override
    protected int makeFontSize() {
        return 40;
    }

    @Override
    protected void createUI() {
        super.createUI();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        decreaseButton = new JButton("Decrease");
        decreaseButton.addActionListener(decreaseActionListener);
        
        increaseButton = new JButton("Increase");
        increaseButton.addActionListener(increaseActionListener);

        // --- NUEVO UI (2B) ---
        resetButton = new JButton("Reset");
        resetButton.addActionListener(resetActionListener);
        // ---------------------

        buttonPanel.add(decreaseButton);
        buttonPanel.add(increaseButton);
        
        // --- NUEVO UI (2B) ---
        buttonPanel.add(resetButton);
        // ---------------------

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void positionFrame() {        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2 - frame.getWidth() / 2 - 10;
        int y = 50 + 200 + 20;
        frame.setLocation(x, y);
    }
}