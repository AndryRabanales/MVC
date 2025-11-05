public class ControlView extends View {
    private ControlViewLayout myViewLayout;

    public ControlView() {
        super("CONTROL");
    }

    @Override
    protected void makeController() {
        myController = new ControlController(tag);
    }

    @Override
    protected void makeViewLayout() {        
        myViewLayout = new ControlViewLayout(tag);
        myViewLayout.initialize();
    }

    @Override
    public void display() {        
        
    }   
}