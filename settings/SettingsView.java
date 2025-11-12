package settings; 

import core.View; 
import java.awt.event.ActionListener; 

public class SettingsView extends View {
    private SettingsViewLayout myViewLayout;

     public SettingsView() {
        super("SETTINGS");
    }

    @Override
    protected void makeController() {
        myController = new SettingsController(tag);
    }

    @Override
    protected void makeViewLayout() {        
        myViewLayout = new SettingsViewLayout(tag);

        myViewLayout.initialize(); 

        ActionListener increaseCheckboxListener = (e) -> {
            boolean isChecked = myViewLayout.getEnableIncreaseCheckbox().isSelected();
            myController.handleSetIncreaseEnabledEvent(isChecked);
        };

        ActionListener decreaseCheckboxListener = (e) -> {
            boolean isChecked = myViewLayout.getEnableDecreaseCheckbox().isSelected();
            myController.handleSetDecreaseEnabledEvent(isChecked);
        };
        
        ActionListener minLimitListener = (e) -> {
            try {
                String text = myViewLayout.getMinimumValueField().getText();
                int minLimit = Integer.parseInt(text);
                myController.handleSetMinLimitEvent(minLimit);
            } catch (NumberFormatException ex) {
            }
        };

        ActionListener maxLimitListener = (e) -> {
            try {
                String text = myViewLayout.getMaximumValueField().getText();
                int maxLimit = Integer.parseInt(text);
                myController.handleSetMaxLimitEvent(maxLimit);
            } catch (NumberFormatException ex) {
            }
        };

        myViewLayout.getEnableIncreaseCheckbox().addActionListener(increaseCheckboxListener);
        myViewLayout.getEnableDecreaseCheckbox().addActionListener(decreaseCheckboxListener);
        myViewLayout.getMinimumValueField().addActionListener(minLimitListener); 
        myViewLayout.getMaximumValueField().addActionListener(maxLimitListener);
    }

    @Override
    public void display() {        
        int minLimit = myModel.getData().getMinLimit();
        int maxLimit = myModel.getData().getMaxLimit();
        boolean increaseEnabled = myModel.getData().isIncreaseEnabled();
        boolean decreaseEnabled = myModel.getData().isDecreaseEnabled();

        myViewLayout.getEnableIncreaseCheckbox().setSelected(increaseEnabled);
        myViewLayout.getEnableDecreaseCheckbox().setSelected(decreaseEnabled);
        
        myViewLayout.getMinimumValueField().setText(String.valueOf(minLimit));
        myViewLayout.getMaximumValueField().setText(String.valueOf(maxLimit));
    }
}