package CALab;

import mvc.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellView extends JButton implements ActionListener, Subscriber {
    Cell myCell;
    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        setText(String.valueOf(myCell.getStatus()));
        setBackground(myCell.getColor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setText(String.valueOf(myCell.getStatus()));
        repaint();
    } //copypasted from assignment instructions
    //nextState, getColor, and getStatus should be abstract methods in the Cell class
    @Override
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

}
