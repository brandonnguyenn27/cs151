package mvc;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel implements Subscriber {
    Model model;
    /*
    Constructor for the View class
    @param model the model to be used
     */
    public View(Model model) {
        this.model = model;
        this.model.subscribe( this);
        setLayout(new BorderLayout());
    }
    @Override
    public void update() {
        repaint(); //not sure if this is correct
    }
    public void paintComponent(Graphics gc) { //not sure if this is correct either
        super.paintComponent(gc);
    }


}
