// Archivo: View.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements IObserver {
    protected Model myModel;
    protected Controller myController;
    private ViewLayout viewLayout;

    private final String tag;

    public View(String tag) {
        this.tag = tag;        
    }

    public void initialize(Model model) {
        myModel = model;
        myModel.attach(this);
        makeController();
        myController.initialize(myModel, this);
        makeViewLayout();
        
        // --- INICIO: MODIFICACIÓN PASO #3 ---
        // Llama a display() una vez al inicio para establecer
        // el estado inicial correcto de los botones (ej. "Decrease" deshabilitado)
        display(); 
        // --- FIN: MODIFICACIÓN PASO #3 ---
    }

    protected void makeController() {
        myController = new Controller(tag);
    }

    public void display() {
        System.out.println("[View."+tag+"] New count: " + myModel.getData().getCount());
        if (myModel != null) {
            
            // --- INICIO: MODIFICACIÓN PASO #3 ---
            // Obtener todos los datos necesarios
            int currentCount = myModel.getData().getCount();
            int minLimit = myModel.getData().getMinLimit();
            int maxLimit = myModel.getData().getMaxLimit();

            // Actualizar la etiqueta (sin cambios)
            viewLayout.getCounterLabel().setText("Counter: " + currentCount);

            // Actualizar el estado de los botones
            viewLayout.setIncreaseButtonEnabled(currentCount < maxLimit);
            viewLayout.setDecreaseButtonEnabled(currentCount > minLimit);
            // --- FIN: MODIFICACIÓN PASO #3 ---
        }
    }

    @Override  
    public void update() {
        display();
    }
    
    private void makeViewLayout() {
        viewLayout = new ViewLayout(tag);
        viewLayout.initialize(            
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myController.handleIncreaseEvent();
                }
            },
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myController.handleDecreaseEvent();
                }
            }
        );    
    }
}