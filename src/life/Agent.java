package life;

import CALab.Cell;

import java.awt.*;

import static life.Society.death;
import static life.Society.rebirth;

public class Agent extends Cell{
    private int state = 0;
    private int ambience = 0;


    @Override
    public void update() {
        if (state == 0 && rebirth.contains(ambience)) {
            state = 1;
        } else if (state == 1 && death.contains(ambience)) {
            state = 0;
        }
    }

    @Override
    public void observe()
    {
        ambience = 0;
        for(Cell row: neighbors) {
            if (row.getStatus() == 1) {
                this.ambience++;
            }
        }
    }
    @Override
    public void nextState()
    {
        if (state == 0 && death.contains(state)) {
            state = 1;
        } else if (state == 1 && death.contains(ambience)) {
            state = 0;
        }
    }
    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            this.state = (int) (Math.random() * 2);
        } else {
            this.state = 0;
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
        public int getAmbience()
        {
            return this.ambience;
        }


    }

