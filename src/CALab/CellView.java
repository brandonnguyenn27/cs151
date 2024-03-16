package CALab;

import mvc.Subscriber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellView extends JButton implements ActionListener, Subscriber {
    Cell myCell;
    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {

    }

    public void update() {

    }






}
