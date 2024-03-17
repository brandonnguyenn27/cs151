package CALab;

import life.LifeFactory;
import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class CAPanel extends AppPanel {

    public CAPanel(AppFactory factory) {
        super(factory);
        JButton run1 = new JButton("RUN1");
        run1.addActionListener(this);
        JButton run50 = new JButton("RUN50");
        run50.addActionListener(this);
        JButton clear = new JButton("CLEAR");
        clear.addActionListener(this);
        JButton populate = new JButton("POPULATE");
        populate.addActionListener(this);
        controlPanel.add(run1);
        controlPanel.add(run50);
        controlPanel.add(clear);
        controlPanel.add(populate);
        view.setLayout(new GridLayout(1,1));
        view.add(factory.makeView(factory.makeModel()));
    }

    public static void main(String[] args) {
        AppFactory factory = new LifeFactory(); // Change might be needed
        AppPanel panel = new CAPanel(factory);
        panel.display();
    }

}


