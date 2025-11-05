public class CoreData {
    private int count;
    private int minLimit;
    private int maxLimit;
    private boolean increaseEnabled;
    private boolean decreaseEnabled;
    
    public CoreData() {
        this.count = 0;
        this.minLimit = 0;
        this.maxLimit = 5;
        this.increaseEnabled = (count < maxLimit);
        this.decreaseEnabled = (count > minLimit);
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
}