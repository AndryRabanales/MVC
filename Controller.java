// Archivo: Controller.java
public class Controller implements IObserver {
    protected Model myModel;
    private View myView;

    protected final String tag;

    public Controller(String tag) {
        this.tag = tag;
    }

    public void initialize(Model model, View view) { 
        myModel = model;
        myView = view;
        myModel.attach(this);
    }

    // --- INICIO: MODIFICACIÓN PASO #3 ---
    // Se añade lógica de guarda (guard clause) para respetar los límites
    // antes de notificar al modelo.
    public void handleIncreaseEvent() {
        if (myModel.getData().getCount() < myModel.getData().getMaxLimit()) {
            myModel.increaseCounter();
        }
    }  

    public void handleDecreaseEvent() {
        if (myModel.getData().getCount() > myModel.getData().getMinLimit()) {
            myModel.decreaseCounter();
        }
    }  
    // --- FIN: MODIFICACIÓN PASO #3 ---

    @Override
    public void update() {
        int count = myModel.getData().getCount();
        System.out.println("[Controller."+tag+"] New count: " + count);
    }
}