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
        
        // --- LÓGICA MODIFICADA (2A) ---
        // Solo actualiza y cuenta la operación si el valor realmente cambió
        if (newCount != currentCount) {
            data.setCount(newCount); 
            data.setOperationsCount(data.getOperationsCount() + 1);
        }
        // --- FIN DE LA MODIFICACIÓN ---
        
        
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
    
    // --- NUEVO MÉTODO IMPLEMENTADO (2B) ---
    @Override
    public void handleResetEvent() {
        CoreData data = myModel.getData();
        int currentCount = data.getCount();
        int initialCount = 0; // Valor inicial definido en CoreData

        // Solo contar la operación si el valor actual es diferente de 0
        if (currentCount != initialCount) {
            data.setCount(initialCount);
            data.setOperationsCount(data.getOperationsCount() + 1);
        }

        // Re-evaluar el estado de los botones después del reset
        // (Similar a la lógica en Leal_Sebastian / updateButtonStatesAutomatic)
        data.setIncreaseEnabled(data.getCount() < data.getMaxLimit());
        data.setDecreaseEnabled(data.getCount() > data.getMinLimit());

        // Notificar a todas las vistas del cambio
        myModel.notifyObservers();
    }
    // ------------------------------------
    
}