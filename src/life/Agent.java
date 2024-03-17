package life;
import CALab.*;

import java.awt.*;

public class Agent extends Cell{
    private int state = 0;
    private int ambience = 8;


    @Override
    public void update()
    {
        //need to be implemented
    }
    @Override
    public void observe()
    {
        //need to be implemented
    }
    @Override
    public void nextState()
    {
        //need to be implemented
    }
    @Override
    public void reset(boolean randomly)
    {
        //need to be implemented
    }

    @Override
    public Color getColor() {
        //need to be implemented
        return null;
    }
    @Override
    public void setStatus(int state) {
        //need to be implemented
    }
    @Override
    public int getStatus() {
        //need to be implemented
        return 0;
    }

    @Override
    public void interact()
    {
        //do nothing
    }
    @Override
    public void setNeighbors(Cell[][] neighbors)
    {
        //need to be implemented
    }



}
