package display;

// LÍNEAS AÑADIDAS
import core.View;
// ---

public class DisplayView extends View {
    //... (tu código raíz sin cambios) ...
    private DisplayViewLayout myViewLayout;

    public DisplayView() {
        super("DISPLAY");
    }

    @Override
    protected void makeController() {
        myController = new DisplayController(tag);
    }

    @Override
    protected void makeViewLayout() {        
        myViewLayout = new DisplayViewLayout(tag);
        myViewLayout.initialize();
    }

    @Override
    public void display() { 
        int count = myModel.getData().getCount();    
        myViewLayout.setCounterLabel(count);
        
    }
}