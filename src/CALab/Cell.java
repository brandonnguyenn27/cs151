package CALab;

import mvc.Publisher;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Cell extends Publisher implements Serializable {
    private int m_row = 0;
    private int m_col = 0;
    private int m_status = 0;
    private Color m_color = Color.WHITE;
    private Cell[][] m_neighbors;

    public int getCol() {
        return m_col;
    }

    public int getRow() {
        return m_row;
    }

    public abstract void observe();
    public abstract void interact();
    public abstract void update();
    public abstract void reset();
    public void setNeighbors(Cell[][] neighbors){ m_neighbors=neighbors;}
    public int getStatus(){return m_status;}
    public void setStatus(int status){m_status = status;}
    public abstract void nextState();
    public abstract void choosePartner();
    public abstract void unPartner();
    public Color getColor(){return m_color;}

}
