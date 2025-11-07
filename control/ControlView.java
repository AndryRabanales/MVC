package control; // <-- LÍNEA AÑADIDA

import core.View; // <-- LÍNEA AÑADIDA

import java.awt.event.ActionListener; // 🚨 ¡AÑADIR ESTE IMPORT!

public class ControlView extends View {
    //... (tu código raíz sin cambios) ...
    private ControlViewLayout myViewLayout;

    public ControlView() {
        super("CONTROL");
    }

    @Override
    protected void makeController() {
        myController = new ControlController(tag);
    }

    protected void makeViewLayout() {        
        myViewLayout = new ControlViewLayout(tag);

        // 1. Definir la acción para "Increase": Llama al método del Controlador (Delegación)
        ActionListener increaseActionListener = (e) -> {
            myController.handleIncreaseEvent(); 
        };

        // 2. Definir la acción para "Decrease": Llama al método del Controlador (Delegación)
        ActionListener decreaseActionListener = (e) -> {
            myController.handleDecreaseEvent(); 
        };
        
        // 3. Pasar las acciones al Layout
        myViewLayout.setListeners(increaseActionListener, decreaseActionListener);
        
        myViewLayout.initialize();
    }

    @Override
    public void display() {        
        int count = myModel.getData().getCount();
        myViewLayout.setCounterLabel(count);

        boolean increaseEnabled = myModel.getData().isIncreaseEnabled();
        boolean decreaseEnabled = myModel.getData().isDecreaseEnabled();

        myViewLayout.getIncreaseButton().setEnabled(increaseEnabled);
        myViewLayout.getDecreaseButton().setEnabled(decreaseEnabled);
    }   
}