package CALab;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CellView extends JButton implements ActionListener, Subscriber {
    Cell myCell;
    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setText("" + myCell.getStatus());
    } //copypasted from assignment instructions
    //nextState, getColor, and getStatus should be abstract methods in the Cell class

    public void nextState() {
        myCell.nextState();
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setText("" + myCell.getStatus());
    }

    @Override
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
    }






}
