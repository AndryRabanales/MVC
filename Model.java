// Archivo: Model.java
import java.util.*;

public class Model {
    private CoreData coreData;
    private Set<IObserver> observers;

    public Model() {
        coreData = new CoreData();
        observers = new LinkedHashSet<>();
    }

    public void attach(IObserver observer) {
        observers.add(observer);
    }

    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public CoreData getData() {
        return coreData;
    }

    public void increaseCounter() {
        int currentValue = coreData.getCount();
        System.out.println("\n[Model] Current count: " + currentValue);
        coreData.setCount(currentValue + 1);
        notifyObservers();
    }

    public void decreaseCounter() {
        int currentValue = coreData.getCount();
        System.out.println("\n[Model] Current count: " + currentValue);
        coreData.setCount(currentValue - 1);
        notifyObservers();
    }
}