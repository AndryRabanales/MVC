import java.util.*;

public class Model {
    private CoreData coreData;
    private Set<IObserver> observers;

    public Model(CoreData coreData) {
        this.coreData = coreData;
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
}