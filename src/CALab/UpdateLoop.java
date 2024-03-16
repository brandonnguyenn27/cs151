package CALab;

import mvc.Command;
import mvc.Model;

public class UpdateLoop extends Command {
    private int runTimes = 0;
    public UpdateLoop(Model m,int times) {
        super(m);
        runTimes = times;
    }

    @Override
    public void execute()
    {
        Grid g = (Grid)getModel();
        g.updateLoop(runTimes);
    }
}
