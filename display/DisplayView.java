public class DisplayView extends View {
    private DisplayViewLayout myViewLayout;

    public DisplayView() {
        super("DISPLAY");
    }

    @Override
    protected void makeController() {
        myController = new DisplayController(tag);
    }

    @Override
    protected void makeViewLayout() {        
        myViewLayout = new DisplayViewLayout(tag);
        myViewLayout.initialize();
    }

    @Override
    public void display() {        
        
    }
}