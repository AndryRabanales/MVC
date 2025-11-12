package display; // <-- LÍNEA AÑADIDA

import javax.swing.*;
import java.awt.*;
import core.ViewLayout; // <-- LÍNEA AÑADIDA

public class DisplayViewLayout extends ViewLayout {
    
    private JLabel counterLabel;
    
    // --- CAMPO FALTANTE (2A) ---
    private JLabel operationsLabel;
    // ----------------------------

    public DisplayViewLayout(String tag) {
        super(tag);
    }

    public void setCounterLabel(int count) {
        counterLabel.setText("" + count);
    }
    
    // --- MÉTODO FALTANTE (2A) ---
    public void setOperationsLabel(int operations) {
        operationsLabel.setText("Total operations: " + operations);
    }
    // -----------------------------
    
    protected int makeFontSize() {
        return 70;
    }

    @Override
    protected void createUI() {
        counterLabel = new JLabel("?", SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, makeFontSize()));
        frame.add(counterLabel, BorderLayout.CENTER);

        // --- LÓGICA DE UI FALTANTE (2A) ---
        operationsLabel = new JLabel("Total operations: 0", SwingConstants.CENTER);
        operationsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        operationsLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        frame.add(operationsLabel, BorderLayout.SOUTH);
        // ----------------------------------
    }

    @Override
    protected void positionFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 50;
        frame.setLocation(x, y);
    }
}