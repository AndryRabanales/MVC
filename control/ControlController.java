
package control; 

import core.Controller; 
import core.CoreData;
import java.lang.Math; 

public class ControlController extends Controller {
    public ControlController(String tag) {
        super(tag);
    }

    private void updateCountAndLimits(int change) {
        CoreData data = myModel.getData();
        int currentCount = data.getCount();
        int minLimit = data.getMinLimit();
        int maxLimit = data.getMaxLimit();
        
        int newCount = currentCount + change;

        newCount = Math.max(minLimit, Math.min(newCount, maxLimit));
        data.setCount(newCount); 
        
        
        if (newCount == maxLimit && data.isIncreaseEnabled()) {
             data.setIncreaseEnabled(false);
        } else if (newCount < maxLimit && !data.isIncreaseEnabled() && change < 0) {
             data.setIncreaseEnabled(true);
        }

        if (newCount == minLimit && data.isDecreaseEnabled()) {
            data.setDecreaseEnabled(false);
        } else if (newCount > minLimit && !data.isDecreaseEnabled() && change > 0) {
             data.setDecreaseEnabled(true);
        }

        myModel.notifyObservers(); 
    }
    
    @Override
    public void handleIncreaseEvent() {
        if (myModel.getData().isIncreaseEnabled()) {
            updateCountAndLimits(1); 
        }
    }  

    @Override
    public void handleDecreaseEvent() {
        if (myModel.getData().isDecreaseEnabled()) {
            updateCountAndLimits(-1); // Decremento de 1 unidad
        }
    }
    
}