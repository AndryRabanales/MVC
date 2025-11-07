
package settings; 

import core.View; 
import java.awt.event.ActionListener; // 🚨 IMPORTANTE

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

        // 1. Listener para Checkbox Increase: Delega el estado al Controlador.
        ActionListener increaseCheckboxListener = (e) -> {
            boolean isChecked = myViewLayout.getEnableIncreaseCheckbox().isSelected();
            myController.handleSetIncreaseEnabledEvent(isChecked);
        };

        // 2. Listener para Checkbox Decrease: Delega el estado al Controlador.
        ActionListener decreaseCheckboxListener = (e) -> {
            boolean isChecked = myViewLayout.getEnableDecreaseCheckbox().isSelected();
            myController.handleSetDecreaseEnabledEvent(isChecked);
        };
        
        // 3. Listener para Campo de Mínimo: Delega el valor INT si se presiona ENTER.
        ActionListener minLimitListener = (e) -> {
            try {
                String text = myViewLayout.getMinimumValueField().getText();
                int minLimit = Integer.parseInt(text);
                myController.handleSetMinLimitEvent(minLimit);
            } catch (NumberFormatException ex) {
                // La Vista maneja el error de entrada (no es un número).
            }
        };

        // 4. Listener para Campo de Máximo: Delega el valor INT si se presiona ENTER.
        ActionListener maxLimitListener = (e) -> {
            try {
                String text = myViewLayout.getMaximumValueField().getText();
                int maxLimit = Integer.parseInt(text);
                myController.handleSetMaxLimitEvent(maxLimit);
            } catch (NumberFormatException ex) {
                // La Vista maneja el error de entrada (no es un número).
            }
        };

        // 5. Asignar los Listeners a los componentes
        myViewLayout.getEnableIncreaseCheckbox().addActionListener(increaseCheckboxListener);
        myViewLayout.getEnableDecreaseCheckbox().addActionListener(decreaseCheckboxListener);
        myViewLayout.getMinimumValueField().addActionListener(minLimitListener); 
        myViewLayout.getMaximumValueField().addActionListener(maxLimitListener);
        
        myViewLayout.initialize();
    }

    @Override
    public void display() {        
        // Leer todos los datos de configuración del Modelo y sincronizar UI
        int minLimit = myModel.getData().getMinLimit();
        int maxLimit = myModel.getData().getMaxLimit();
        boolean increaseEnabled = myModel.getData().isIncreaseEnabled();
        boolean decreaseEnabled = myModel.getData().isDecreaseEnabled();

        // Sincronizar Checkboxes
        myViewLayout.getEnableIncreaseCheckbox().setSelected(increaseEnabled);
        myViewLayout.getEnableDecreaseCheckbox().setSelected(decreaseEnabled);
        
        // Sincronizar campos de texto (se mostrarán los valores rechazados o los nuevos)
        myViewLayout.getMinimumValueField().setText(String.valueOf(minLimit));
        myViewLayout.getMaximumValueField().setText(String.valueOf(maxLimit));
    }
}