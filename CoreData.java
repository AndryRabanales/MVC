// Archivo: CoreData.java
public class CoreData {
    private int count;
    private int minLimit;
    private int maxLimit;
    
    public CoreData() {
        this.count = 0;
        this.minLimit = 0;
        this.maxLimit = 10;
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
}