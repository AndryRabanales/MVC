import javax.swing.*;
import java.awt.*;

public class DisplayViewLayout extends ViewLayout {
    private JLabel counterLabel;

    public DisplayViewLayout(String tag) {
        super(tag);
    }

    public void setCounterLabel(int count) {
        counterLabel.setText("" + count);
    }
    
    protected int makeFontSize() {
        return 70;
    }

    @Override
    protected void createUI() {
        counterLabel = new JLabel("?", SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, makeFontSize()));
        frame.add(counterLabel, BorderLayout.CENTER);
    }

    @Override
    protected void positionFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 50;
        frame.setLocation(x, y);
    }
}