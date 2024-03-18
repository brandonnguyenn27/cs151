package life;

import CALab.Cell;

import java.awt.*;

import static life.Society.death;
import static life.Society.rebirth;

public class Agent extends Cell{
    private int state = 0;
    private int ambience = 0;


    @Override
    public void update()
    {
        this.nextState();
        notifySubscribers();
    }

    @Override
    public void observe()
    {
        for(Cell row: neighbors) {
            if (((Agent)row).getStatus() == 1) {
                this.ambience++;
            }
        }
    }
    @Override
    public void nextState()
    {
        if (state == 0 && rebirth.contains(ambience)) {
            state = 1;
            this.observe();
        }
        else if (state == 1 && death.contains(ambience)) {
            state = 0;
            ambience = 0;
            //should i call observe instead of setting ambience to 0?
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


    }

