import core.Model;
import core.CoreData;
import display.DisplayView;
import control.ControlView;
import settings.SettingsView;

public class Main {
    public static void main(String[] args) {
        // 1. Crear la única fuente de verdad (Modelo y sus datos)
        CoreData coreData = new CoreData();
        Model model = new Model(coreData);

        // 2. Crear las tres Vistas
        DisplayView displayView = new DisplayView();
        ControlView controlView = new ControlView();
        SettingsView settingsView = new SettingsView();

        // 3. Inicializar las Vistas con el Modelo.
        //    El método initialize() de cada Vista se encargará de:
        //    - Guardar el modelo
        //    - Adjuntarse como Observer (model.attach(this))
        //    - Crear su Controlador (makeController())
        //    - Inicializar su Controlador (myController.initialize(model, this))
        //    - Crear su Layout (makeViewLayout())
        displayView.initialize(model);
        controlView.initialize(model);
        settingsView.initialize(model);

        // 4. Forzar una actualización inicial para que todas las vistas
        //    reflejen el estado inicial del modelo.
        model.notifyObservers();
    }
}