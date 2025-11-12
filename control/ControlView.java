package control; // <-- LÍNEA AÑADIDA

import core.View; // <-- LÍNEA AÑADIDA

import java.awt.event.ActionListener; 

public class ControlView extends View {

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

        ActionListener increaseActionListener = (e) -> {
            myController.handleIncreaseEvent(); 
        };

        ActionListener decreaseActionListener = (e) -> {
            myController.handleDecreaseEvent(); 
        };
        
        // --- NUEVO LISTENER (2B) ---
        ActionListener resetActionListener = (e) -> {
            myController.handleResetEvent();
        };
        // ---------------------------
        
        // --- LLAMADA MODIFICADA (2B) ---
        myViewLayout.setListeners(
            increaseActionListener, 
            decreaseActionListener,
            resetActionListener
        );
        // -------------------------------
        
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
        
        // El botón de Reset no tiene lógica de habilitación/deshabilitación por ahora
    }   
}