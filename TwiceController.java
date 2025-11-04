// Archivo: TwiceController.java
// VERSIÓN ACTUALIZADA CON LÓGICA DE REDONDEO (Paso #4)

public class TwiceController extends Controller {

    public TwiceController(String tag) {
        super(tag);
    }

    /**
     * Sobreescribe el método base para incrementar de 2 en 2,
     * con lógica especial para los límites.
     * Si está en 9, sube 1 (a 10).
     * Si está en 8, sube 2 (a 10).
     */
    @Override
    public void handleIncreaseEvent() {
        int currentCount = myModel.getData().getCount();
        int maxLimit = myModel.getData().getMaxLimit();

        if (currentCount >= maxLimit) {
            return; // Límite alcanzado, no hacer nada
        }

        // Caso especial: Redondear de 9 a 10
        if (currentCount == (maxLimit - 1)) {
            myModel.increaseCounter(); // Sube 1 (de 9 a 10)
        } 
        // Caso normal: Subir de 2 en 2
        else {
            myModel.increaseCounter(); // Sube 1
            
            // Volver a chequear si aún no llegamos al límite
            // (Esto maneja el caso de 8 -> 9 -> 10)
            if (myModel.getData().getCount() < maxLimit) {
                myModel.increaseCounter(); // Sube el 2do
            }
        }
    }  

    /**
     * Sobreescribe el método base para decrementar de 2 en 2,
     * con lógica especial para los límites.
     * Si está en 1, baja 1 (a 0).
     * Si está en 2, baja 2 (a 0).
     */
    @Override
    public void handleDecreaseEvent() {
        int currentCount = myModel.getData().getCount();
        int minLimit = myModel.getData().getMinLimit();

        if (currentCount <= minLimit) {
            return; // Límite alcanzado, no hacer nada
        }

        // Caso especial: Bajar de 1 a 0
        if (currentCount == (minLimit + 1)) {
            myModel.decreaseCounter(); // Baja 1 (de 1 a 0)
        } 
        // Caso normal: Bajar de 2 en 2
        else {
            myModel.decreaseCounter(); // Baja 1
            
            // Volver a chequear si aún no llegamos al límite
            // (Esto maneja el caso de 2 -> 1 -> 0)
            if (myModel.getData().getCount() > minLimit) {
                myModel.decreaseCounter(); // Baja el 2do
            }
        }
    }
}