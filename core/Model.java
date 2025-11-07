package core; // <-- LÍNEA AÑADIDA

import java.util.*;
import core.IObserver; // <-- LÍNEA AÑADIDA

public class Model {
    //... (tu código raíz sin cambios) ...
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