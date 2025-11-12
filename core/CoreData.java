package core; // <-- ERROR #1 CORREGIDO

public class CoreData {
    private int count;
    private int minLimit;
    private int maxLimit;
    private boolean increaseEnabled;
    private boolean decreaseEnabled;
    
    // --- NUEVO CAMPO (2A) ---
    private int operationsCount;
    // ------------------------

    public CoreData() {
        this.count = 0;
        this.minLimit = 0;
        this.maxLimit = 5;
        
        this.increaseEnabled = true;
        this.decreaseEnabled = false;

        // --- INICIALIZACIÓN (2A) ---
        this.operationsCount = 0;
        // ---------------------------
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    public void setIncreaseEnabled(boolean increaseEnabled) {
        this.increaseEnabled = increaseEnabled;
    } 

    public void setDecreaseEnabled(boolean decreaseEnabled) {
        this.decreaseEnabled = decreaseEnabled;
    } 

    public boolean isDecreaseEnabled() {
        return decreaseEnabled;
    }

    public boolean isIncreaseEnabled() {
        return increaseEnabled;
    }

    // --- NUEVOS MÉTODOS (2A) ---
    public int getOperationsCount() {
        return operationsCount;
    }

    public void setOperationsCount(int operationsCount) {
        this.operationsCount = operationsCount;
    }
    // ---------------------------
}