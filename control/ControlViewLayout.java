package control; // <-- LÍNEA AÑADIDA

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import display.DisplayViewLayout; // <-- LÍNEA AÑADIDA

public class ControlViewLayout extends DisplayViewLayout {
    //... (tu código raíz sin cambios) ...
    private JButton increaseButton;
    private JButton decreaseButton;
    
    private ActionListener increaseActionListener;
    private ActionListener decreaseActionListener;

    public ControlViewLayout(String tag) {
        super(tag);
    }

    public void setListeners(
        ActionListener increaseActionListener, 
        ActionListener decreaseActionListener
    ) {
        this.increaseActionListener = increaseActionListener;
        this.decreaseActionListener = decreaseActionListener;        
    }

    public JButton getDecreaseButton() {
        return decreaseButton;
    }

    public JButton getIncreaseButton() {
        return increaseButton;
    }
    
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

        buttonPanel.add(decreaseButton);
        buttonPanel.add(increaseButton);

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