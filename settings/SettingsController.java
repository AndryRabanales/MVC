
package settings; 

import core.Controller; 
import core.CoreData; 

public class SettingsController extends Controller {
    public SettingsController(String tag) {
        super(tag);
    } 
    
 
    @Override
    public void handleSetIncreaseEnabledEvent(boolean enabled) {
        myModel.getData().setIncreaseEnabled(enabled);
        myModel.notifyObservers();
    }

    @Override
    public void handleSetDecreaseEnabledEvent(boolean enabled) {
        // Requisito: Permite habilitar el botón manualmente (override del sistema).
        myModel.getData().setDecreaseEnabled(enabled);
        myModel.notifyObservers();
    }
    
    // =========================================================================
    // MÉTODO AUXILIAR PARA REUTILIZACIÓN (Ajuste de Contador)
    // =========================================================================
    
    /**
     * Reutilización: Ajusta el valor del contador si queda fuera de los nuevos límites.
     * @param data CoreData
     * @param minLimit Nuevo límite mínimo (o actual)
     * @param maxLimit Nuevo límite máximo (o actual)
     */
    private void adjustCountIfOutOfBound(CoreData data, int minLimit, int maxLimit) {
        int count = data.getCount();
        
        if (count < minLimit) {
            data.setCount(minLimit); // El contador es inferior, ajustarlo al mínimo.
        } else if (count > maxLimit) {
            data.setCount(maxLimit); // El contador excede el máximo, ajustarlo al máximo.
        }
    }

    // =========================================================================
    // LÓGICA DE LÍMITES (Text Fields)
    // =========================================================================

    @Override
    public void handleSetMinLimitEvent(int newMinLimit) {
        CoreData data = myModel.getData();
        int maxLimit = data.getMaxLimit();
        
        // 1. Validación (Regla General: Mínimo debe ser estrictamente menor a Máximo).
        if (newMinLimit >= maxLimit) {
            // Rechazado: El Modelo no se modifica.
            System.out.println("ERROR: El límite mínimo (" + newMinLimit + ") debe ser estrictamente menor que el máximo (" + maxLimit + ")");
        } else {
            // 2. Aplicar el cambio.
            data.setMinLimit(newMinLimit);
            
            // 3. Ajustar el contador (Reutilización).
            adjustCountIfOutOfBound(data, newMinLimit, maxLimit);
        }
        
        // 4. Notificar a todos (para refrescar el valor del contador y el campo de texto de Settings).
        myModel.notifyObservers();
    }

    @Override
    public void handleSetMaxLimitEvent(int newMaxLimit) {
        CoreData data = myModel.getData();
        int minLimit = data.getMinLimit();
        
        // 1. Validación (Regla General: Máximo debe ser estrictamente mayor a Mínimo).
        if (newMaxLimit <= minLimit) {
             // Rechazado: El Modelo no se modifica.
             System.out.println("ERROR: El límite máximo (" + newMaxLimit + ") debe ser estrictamente mayor que el mínimo (" + minLimit + ")");
        } else {
            // 2. Aplicar el cambio.
            data.setMaxLimit(newMaxLimit);
            
            // 3. Ajustar el contador (Reutilización).
            adjustCountIfOutOfBound(data, minLimit, newMaxLimit);
        }
        
        // 4. Notificar a todos.
        myModel.notifyObservers();
    }
}