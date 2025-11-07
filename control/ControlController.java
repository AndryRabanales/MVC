
package control; 

import core.Controller; 
import core.CoreData;
import java.lang.Math; // Necesario para Math.min y Math.max

public class ControlController extends Controller {
    public ControlController(String tag) {
        super(tag);
    }

    /**
     * Reutilización: Lógica central para actualizar el contador y reevaluar límites.
     * Esta función contiene la lógica de negocio clave del contador.
     * @param change El valor de incremento o decremento (+1 o -1).
     */
    private void updateCountAndLimits(int change) {
        CoreData data = myModel.getData();
        int currentCount = data.getCount();
        int minLimit = data.getMinLimit();
        int maxLimit = data.getMaxLimit();
        
        int newCount = currentCount + change;

        // 1. Regla de Negocio: Asegurarse de que el nuevo valor esté dentro de los límites
        newCount = Math.max(minLimit, Math.min(newCount, maxLimit));
        data.setCount(newCount); 
        
        // 2. Lógica de Deshabilitación Automática:
        // El sistema deshabilita el botón si alcanza el límite, PERO solo si el botón estaba habilitado.
        
        // Habilitación de Increase
        if (newCount == maxLimit && data.isIncreaseEnabled()) {
             data.setIncreaseEnabled(false);
        } else if (newCount < maxLimit && !data.isIncreaseEnabled() && change < 0) {
             // Si el contador se aleja del maxLimit (va para abajo) y la bandera estaba en false, se rehabilita
             data.setIncreaseEnabled(true);
        }

        // Habilitación de Decrease
        if (newCount == minLimit && data.isDecreaseEnabled()) {
            data.setDecreaseEnabled(false);
        } else if (newCount > minLimit && !data.isDecreaseEnabled() && change > 0) {
             // Si el contador se aleja del minLimit (va para arriba) y la bandera estaba en false, se rehabilita
             data.setDecreaseEnabled(true);
        }

        // 3. ¡ALERTA! Notificar a todas las Vistas que el estado ha cambiado
        myModel.notifyObservers(); 
    }
    
    @Override
    public void handleIncreaseEvent() {
        // Solo procesar el evento si el botón está habilitado (protección contra doble click)
        if (myModel.getData().isIncreaseEnabled()) {
            updateCountAndLimits(1); // Incremento de 1 unidad
        }
    }  

    @Override
    public void handleDecreaseEvent() {
        // Solo procesar el evento si el botón está habilitado (protección contra doble click)
        if (myModel.getData().isDecreaseEnabled()) {
            updateCountAndLimits(-1); // Decremento de 1 unidad
        }
    }
    
    // Los demás handle*Event() de la base se implementan en SettingsController
}