import java.util.ArrayList;
import java.util.List;

public class Model {
    private CoreData coreData;
    private List<IObserver> observers = new ArrayList<>();

    // --- Métodos de Observer (add, remove, notify) ---
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }
    // --- Fin de Observer ---

    public Model() {
        this.coreData = new CoreData();
        // ESTA LÍNEA ES CORRECTA. Es la única impresión automática.
        System.out.println("[Model] Current count: " + this.coreData.getCount());
    }

    public int getCount() {
        return this.coreData.getCount();
    }

    // AÑADE ESTE NUEVO MÉTODO
    // El "error" en Main es que no llamaba a esto.
    public void printCurrentState() {
        System.out.println("[Model] Current count: " + this.coreData.getCount());
    }

    public void increment() {
        int currentCount = this.coreData.getCount();
        this.coreData.setCount(currentCount + 1);
        
        // 1. Notifica a todos
        notifyObservers(); 
        
        // 2. LA LÍNEA DE IMPRESIÓN SE ELIMINA DE AQUÍ
    }

    public void decrement() {
        int currentCount = this.coreData.getCount();
        this.coreData.setCount(currentCount - 1);

        // 1. Notifica a todos
        notifyObservers();

        // 2. LA LÍNEA DE IMPRESIÓN SE ELIMINA DE AQUÍ
    }
}