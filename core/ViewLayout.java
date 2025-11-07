package core; // // <-- IGNORARRRR

import javax.swing.*;

public abstract class ViewLayout {
    //... (tu código raíz sin cambios) ...
    protected JFrame frame;
    protected final String tag;
    
    public ViewLayout(String tag) {
        this.tag = tag;
    }
    
    public void initialize() {
        createFrame();
        createUI();
        positionFrame();
        frame.setVisible(true);
    }

    protected void positionFrame() {
        frame.setLocationRelativeTo(null);
    }
    
    protected abstract void createUI();
    
    protected void createFrame() {
        frame = new JFrame(tag);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);    
    }
}