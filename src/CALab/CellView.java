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
        update();

    }
    @Override
    public void update() {
        setOpaque(true);
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setText(String.valueOf(myCell.getAmbience()));
    }

}
