package core;

import java.util.*;
import java.lang.Math;

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

    private void updateCountAndLimits(int change) {
        int currentCount = coreData.getCount();
        int minLimit = coreData.getMinLimit();
        int maxLimit = coreData.getMaxLimit();
        
        int newCount = currentCount + change;

        newCount = Math.max(minLimit, Math.min(newCount, maxLimit));
        coreData.setCount(newCount); 
        
        if (newCount == maxLimit && coreData.isIncreaseEnabled()) {
             coreData.setIncreaseEnabled(false);
        } else if (newCount < maxLimit && !coreData.isIncreaseEnabled() && change < 0) {
             coreData.setIncreaseEnabled(true);
        }

        if (newCount == minLimit && coreData.isDecreaseEnabled()) {
            coreData.setDecreaseEnabled(false);
        } else if (newCount > minLimit && !coreData.isDecreaseEnabled() && change > 0) {
             coreData.setDecreaseEnabled(true);
        }
        
        notifyObservers(); 
    }

    public void incrementCount() {
        if (coreData.isIncreaseEnabled()) {
            updateCountAndLimits(1);
        }
    }

    public void decrementCount() {
        if (coreData.isDecreaseEnabled()) {
            updateCountAndLimits(-1);
        }
    }
    
    public void setIncreaseEnabled(boolean enabled) {
        coreData.setIncreaseEnabled(enabled);
        notifyObservers();
    }

    public void setDecreaseEnabled(boolean enabled) {
        coreData.setDecreaseEnabled(enabled);
        notifyObservers();
    }
    
    private void adjustCountIfOutOfBound(int minLimit, int maxLimit) {
        int count = coreData.getCount();
        
        if (count < minLimit) {
            coreData.setCount(minLimit);
        } else if (count > maxLimit) {
            coreData.setCount(maxLimit);
        }
    }

    public void setMinLimit(int newMinLimit) {
        int maxLimit = coreData.getMaxLimit();
        
        if (newMinLimit >= maxLimit) {
            System.out.println("ERROR: El límite mínimo (" + newMinLimit + ") debe ser estrictamente menor que el máximo (" + maxLimit + ")");
        } else {
            coreData.setMinLimit(newMinLimit);
            adjustCountIfOutOfBound(newMinLimit, maxLimit);
        }
        
        notifyObservers();
    }

    public void setMaxLimit(int newMaxLimit) {
        int minLimit = coreData.getMinLimit();
        
        if (newMaxLimit <= minLimit) {
             System.out.println("ERROR: El límite máximo (" + newMaxLimit + ") debe ser estrictamente mayor que el mínimo (" + minLimit + ")");
        } else {
            coreData.setMaxLimit(newMaxLimit);
            adjustCountIfOutOfBound(minLimit, newMaxLimit);
        }
        
        notifyObservers();
    }
}