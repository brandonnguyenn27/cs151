package mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AppPanel extends JPanel implements ActionListener, Subscriber {
    ControlPanel controls;
    AppFactory factory;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void update() {

    }

    class ControlPanel extends JPanel {
        public ControlPanel() {

        }
    }
}
