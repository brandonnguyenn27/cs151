package life;
import CALab.*;
public class Agent extends Cell{
    private int state = 0;
    private int ambience = 8;
    public Agent(Grid grid, int row, int col) {
        super(grid,row,col);

    }

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
    public void interact()
    {
        //do nothing
    }
}
