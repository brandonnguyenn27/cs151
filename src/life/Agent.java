package life;
import CALab.*;

import java.awt.*;

public class Agent extends Cell{
    private int state = 0;
    private int ambience = 8;


    @Override
    public void update()
    {
        this.nextState();
        notifySubscribers();
    }
    @Override
    public void observe()
    {
        this.ambience = 0;
        for(Cell row: neighbors) {
            if (row.getStatus() == 1) {
                this.ambience++;
            }
        }
    }
    @Override
    public void nextState()
    {
        if (state == 0 && ambience == 3) {
            state = 1;
        }
        else {
            state = 0;
        }
    }
    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            state = Math.random() < 0.5 ? 0 : 1; // if randomly is true, set state to 0 or 1
        } else {
            state = 0;
        }
    }

        public Color getColor () {
            if (this.state == 0) { // should it be this.state or this.getStatus()?
                return Color.RED;
            } else {
                return Color.GREEN;
            }
        }
        @Override
        public void setStatus ( int state){
            this.state = state;
        }

        @Override
        public int getStatus () {
            return this.state;
        }

        @Override
        public void interact ()
        {
            //do nothing
        }
        @Override
        public void setNeighbors (Cell[][]neighbors) //idk if we need this?
        {

        }


    }

