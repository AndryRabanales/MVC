package settings; // <-- LÍNEA AÑADIDA

import javax.swing.*;
import java.awt.*;
import core.ViewLayout; // <-- LÍNEA AÑADIDA

public class SettingsViewLayout extends ViewLayout {
    //... (tu código raíz sin cambios) ...
    private JCheckBox enableIncreaseCheckbox;
    private JCheckBox enableDecreaseCheckbox;
    private JTextField minimumValueField;
    private JTextField maximumValueField;

    public SettingsViewLayout(String tag) {
        super(tag);
    }

    @Override
    protected void createUI() {        
        frame.setLayout(new BorderLayout(0, 0));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));        
        
        JPanel increaseCheckBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        enableIncreaseCheckbox = new JCheckBox("Enable INCREASE button");
        enableIncreaseCheckbox.setFont(new Font("Arial", Font.PLAIN, 13));        
        increaseCheckBoxPanel.add(enableIncreaseCheckbox);

        JPanel decreaseCheckBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        enableDecreaseCheckbox = new JCheckBox("Enable DECREASE button");    
        enableDecreaseCheckbox.setFont(new Font("Arial", Font.PLAIN, 13));
        decreaseCheckBoxPanel.add(enableDecreaseCheckbox);
        
        mainPanel.add(increaseCheckBoxPanel);    
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(decreaseCheckBoxPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        
        JSeparator separator = new JSeparator();
        mainPanel.add(separator);
        mainPanel.add(Box.createVerticalStrut(15));
        
        JPanel minimumPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));        
        JLabel minimumLabel = new JLabel("Minimum value:");
        minimumLabel.setFont(new Font("Monospaced", Font.PLAIN, 13));
        minimumValueField = new JTextField("", 8);
        minimumValueField.setFont(new Font("Monospaced", Font.PLAIN, 13));
        minimumPanel.add(minimumLabel);
        minimumPanel.add(minimumValueField);
        
    
        JPanel maximumPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel maximumLabel = new JLabel("Maximum value:");
        maximumLabel.setFont(new Font("Monospaced", Font.PLAIN, 13));
        maximumValueField = new JTextField("", 8);
        maximumValueField.setFont(new Font("Monospaced", Font.PLAIN, 13));

        maximumPanel.add(maximumLabel);
        maximumPanel.add(maximumValueField);
        
        mainPanel.add(minimumPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(maximumPanel);
        
        frame.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    protected void createFrame() {
        super.createFrame();
        frame.setSize(400, 220);
    }

    @Override
    protected void positionFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2 + 300 / 2 + 10 + 50;
        int y = 50 + 200 + 20;
        frame.setLocation(x, y);
    }

    public JCheckBox getEnableIncreaseCheckbox() {
        return enableIncreaseCheckbox;
    }

    public JCheckBox getEnableDecreaseCheckbox() {
        return enableDecreaseCheckbox;
    }

    public JTextField getMinimumValueField() {
        return minimumValueField;
    }

    public JTextField getMaximumValueField() {
        return maximumValueField;
    }
}