package life;

import CALab.Cell;
import CALab.Grid;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class Society extends Grid {
    private int percentAlive = 50;
    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();

    static {
        rebirth.add(3);
        death.add(0);
        death.add(1);
        death.add(4);
        death.add(5);
        death.add(6);
        death.add(7);
        death.add(8);
    }

    @Override
    public int getStatus() { //this is already in Agent class
        int ambience = ((Agent) this).getAmbience();
        if (((Agent) this).isAlive()) {
            if (death.contains(ambience)) {
                return 0;
            }
        } else {
            if (rebirth.contains(ambience)) {
                return 1;
            }
        }
        return ((Agent) this).getStatus();
    }

    @Override
    public Color getColor() { // this is already in Agent class
        if (((Agent) this).isAlive()) {
            return Color.GREEN;
        } else {
            return Color.RED;
        }
    }
    @Override
    public  Agent makeCell(boolean uniform)
    {
        return new Agent();
    }

}
