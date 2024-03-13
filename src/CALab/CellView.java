package CALab;

import mvc.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CellView extends JButton implements ActionListener, Subscriber {
    Cell myCell;
    public CellView(Cell cell) {
        myCell = cell;
    }

    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setText("" + myCell.getStatus());
    } //copypasted from assignment instructions
    //nextState, getColor, and getStatus should be abstract methods in the Cell class

    @Override
    public void update() {

    }





}
