// Implementa IObserver
public class View implements IObserver {
    private final String tag;
    private Controller controller;
    private Model model; // La vista necesita conocer al modelo para pedirle el estado actual

    public View(String tag) {
        this.tag = tag;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void setModel(Model model) {
        this.model = model;
    }

    // Métodos "Tap" llamados por Main
    public void onIncreaseTap() {
        this.controller.onIncrease();
    }

    public void onDecreaseTap() {
        this.controller.onDecrease();
    }

    // Método de display
    public void display(int count) {
        System.out.println("[View." + this.tag + "] Updated count " + count);
    }

    // Método llamado por el Modelo (notifyObservers)
    @Override
    public void update() {
        // Pide el nuevo dato y lo muestra
        display(this.model.getCount());
    }
}