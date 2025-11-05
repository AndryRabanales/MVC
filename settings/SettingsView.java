public class SettingsView extends View {
    private SettingsViewLayout myViewLayout;

     public SettingsView() {
        super("SETTINGS");
    }

    @Override
    protected void makeController() {
        myController = new SettingsController(tag);
    }

    @Override
    protected void makeViewLayout() {        
        myViewLayout = new SettingsViewLayout(tag);
        myViewLayout.initialize();
    }

    @Override
    public void display() {        
        
    }
}