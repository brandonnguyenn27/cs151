package CALab;

import tools.Publisher;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cell extends Publisher implements Serializable {
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

    public void observe(){}
    public void interact(){}
    public void update(){}
    public void reset(){}
    public void setNeighbors(Cell[][] neighbors){ m_neighbors=neighbors;}
    public int getStatus(){return m_status;}
    public void setStatus(int status){m_status = status;}
    public void nextState(){}
    public void choosePartner(){}
    public void unPartner(){}
    public Color getColor(){return m_color;}

}
