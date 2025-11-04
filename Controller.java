// Implementa IObserver
public class Controller implements IObserver {
    private final String tag;
    private Model model;

    public Controller(String tag) {
        this.tag = tag;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    // Métodos llamados por la Vista
    public void onIncrease() {
        this.model.increment();
    }

    public void onDecrease() {
        this.model.decrement();
    }

    // Método llamado por el Modelo (notifyObservers)
    @Override
    public void update() {
        // Imprime el estado actualizado
        System.out.println("[Controller." + this.tag + "] Updated count: " + model.getCount());
    }
}