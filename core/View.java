public abstract class View implements IObserver {
    protected Model myModel;
    protected Controller myController;
    protected final String tag;
    
    public View(String tag) {
        this.tag = tag; 
    }
    
    public void initialize(Model model) {
        myModel = model;
        myModel.attach(this);
        makeController();
        myController.initialize(myModel, this);
        makeViewLayout();
    }
    
    protected abstract void makeController();
    
    protected abstract void makeViewLayout();

    public abstract void display();

    public void setIncreaseEnabled(boolean isEnabled) {

    }
    public void setDecreaseEnabled(boolean isEnabled) {

    }
    
    @Override 
    public void update() {
        display();
    }
}