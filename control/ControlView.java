package control; // <-- LÍNEA AÑADIDA

import core.View; // <-- LÍNEA AÑADIDA

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

    @Override
    protected void makeViewLayout() {        
        myViewLayout = new ControlViewLayout(tag);
        myViewLayout.initialize();
    }

    @Override
    public void display() {        
        int count = myModel.getData().getCount()
        myViewLayout.setCounterLabel(count);

        boolean increaseEnabled = myModel.getData().isIncreaseEnabled();
        boolean decreaseEnabled = myModel.getData().isDecreaseEnabled();
        
        myViewLayout.getIncreaseButton().setEnabled(increaseEnabled);
        myViewLayout.getDecreaseButton().setEnabled(decreaseEnabled);
    }   
}