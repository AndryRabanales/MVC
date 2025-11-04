// Archivo: TwiceView.java
// NUEVA CLASE PARA PASO #4

public class TwiceView extends View {

    public TwiceView(String tag) {
        super(tag);
    }

    /**
     * Sobreescribe el "Factory Method" de la clase base
     * para instanciar un TwiceController en lugar de un Controller.
     * Esta es la única diferencia necesaria.
     */
    @Override
    protected void makeController() {
        myController = new TwiceController(tag);
    }
}