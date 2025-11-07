
import core.Model;
import core.CoreData;
import display.DisplayView;
import control.ControlView;
import settings.SettingsView;

public class Main {
    public static void main(String[] args) {
        
        // AÑADIDO: Todo el código de Swing debe ejecutarse en el Event Dispatch Thread
            
            // 1. Inicializar core data y model :)
            CoreData coreData = new CoreData();
            Model model = new Model(coreData);
    
            // 2. Inicializar las 3 ventanas :p
            DisplayView displayView = new DisplayView();
            ControlView controlView = new ControlView();
            SettingsView settingsView = new SettingsView();
    
            // 3. Inicializamos 
            displayView.initialize(model);
            controlView.initialize(model);
            settingsView.initialize(model);
    
            // 4. Es un observador de cada cambio :p
            model.notifyObservers();
    }
}